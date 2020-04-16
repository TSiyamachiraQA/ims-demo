package com.qa.ims.persistence.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;

public class ItemsDaoMySQL implements Dao<Items>{
	
	public static final Logger LOGGER = Logger.getLogger(ItemsDaoMySQL.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ItemsDaoMySQL(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.242.180.128:3306/ims";
		this.username = username;
		this.password = password;
	}
	
	public ItemsDaoMySQL(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	
	Items itemsFromResultSet(ResultSet resultSet) throws SQLException {
		Long product_id = resultSet.getLong("product_id");
		String title = resultSet.getString("title");
		Integer rating = resultSet.getInt("rating");
		BigDecimal price = resultSet.getBigDecimal("price");
		Integer stock = resultSet.getInt("stock");
		
		return new Items(product_id, title, rating, price, stock);
	}
	
	public List<Items> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from items");) {
			ArrayList<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(itemsFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();			
	}
	
	public Items readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY product_id DESC LIMIT 1");) {
			resultSet.next();
			return itemsFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	public Items create(Items items) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into items(title, rating, price, stock) values('" + items.getTitle()
					+ "','" + items.getRating() + "','" + items.getPrice() +"','" + items.getStock() +"')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Items readItems(Long product_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items where product_id = " + product_id);) {
			resultSet.next();
			return itemsFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	public Items update(Items items) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update items set title ='" + items.getTitle() + "', rating ='"
					+ items.getRating() + "', price ='" + items.getPrice() + "', stock ='" + items.getStock() +
					"' where product_id =" + items.getProduct_id());
			return readItems(items.getProduct_id());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	public void delete(long product_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from items where product_id = " + product_id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}