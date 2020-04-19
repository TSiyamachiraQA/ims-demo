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
	
	Orderline orderlineFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long productId = resultSet.getLong("product_id");
		
		return new Orderline(orderId, productId);
	}
	
	public List<Orderline> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orderline");) {
			ArrayList<Orderline> orderlines = new ArrayList<>();
			while (resultSet.next()) {
				orderlines.add(orderlineFromResultSet(resultSet));
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
			return orderlineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orderline create(Orderline orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orderline(order_id, product_id) values('" + orderline.getOrderId()
					+ "','" + orderline.getProductId()+"')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orderline readItems(Long orderId) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where order_id = " + orderId);) {
			resultSet.next();
			return orderlineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	public Orderline update(Orderline orderline) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update items set product_id ='" + orderline.getProductId()+
					"' where order_id =" + orderline.getOrderId());
			return readItems(orderline.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	public void delete(long orderId) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from items where order_id = " + orderId);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	

}
