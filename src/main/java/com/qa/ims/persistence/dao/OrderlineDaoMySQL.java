package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;

public class OrderlineDaoMySQL implements Dao<Orderline>{
	
	public static final Logger LOGGER = Logger.getLogger(OrderlineDaoMySQL.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderlineDaoMySQL(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.242.180.128:3306/ims";
		this.username = username;
		this.password = password;
	}
	
	public OrderlineDaoMySQL(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	
	Orderline OrderlineFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long product_id = resultSet.getLong("product_id");
		
		return new Orderline(order_id, product_id);
	}
	
	public List<Orderline> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orderline");) {
			ArrayList<Orderline> orderlines = new ArrayList<>();
			while (resultSet.next()) {
				orderlines.add(OrderlineFromResultSet(resultSet));
			}
			return orderlines;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();			
	}
	
	public Orderline readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return OrderlineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orderline create(Orderline orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orderline(order_id, product_id) values('" + orderline.getOrder_id()
					+ "','" + orderline.getProduct_id()+"')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orderline readItems(Long order_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where order_id = " + order_id);) {
			resultSet.next();
			return OrderlineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	public Orderline update(Orderline orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update items set product_id ='" + orderline.getProduct_id()+
					"' where order_id =" + orderline.getOrder_id());
			return readItems(orderline.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	public void delete(long order_id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from items where order_id = " + order_id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	

}
