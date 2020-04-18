package com.qa.ims.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders>{
	
public static final Logger LOGGER = Logger.getLogger(OrdersController.class);
	
	private CrudServices<Orders> ordersService;
	
	public OrdersController(CrudServices<Orders> ordersService) {
		this.ordersService = ordersService;
	}

	String getInput() {
		return Utils.getInput();
	}
	
	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersService.readAll();
		for(Orders order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Orders create() {
		LOGGER.info("Please enter the customer id");
		Long customer_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the quantity of products ordered");
		Integer quantity = Integer.valueOf(getInput());
		LOGGER.info("Please enter the total price of the order");
		BigDecimal total = BigDecimal.valueOf(Double.valueOf(getInput()));
		Orders order = ordersService.create(new Orders(customer_id, quantity, total));
		LOGGER.info("Product added to inventory");
		return order;
		
	}
 
	@Override
	public Orders update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the customer id");
		Long customer_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the quantity of products ordered");
		Integer quantity = Integer.valueOf(getInput());
		LOGGER.info("Please enter the total price of the order");
		BigDecimal total = BigDecimal.valueOf(Double.valueOf(getInput()));
		Orders order = ordersService.update(new Orders(order_id, customer_id, quantity, total));
		LOGGER.info("Product Updated");
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = Long.valueOf(getInput());
		ordersService.delete(order_id);
		LOGGER.info("Product Deleted");
		
	}
	
}
