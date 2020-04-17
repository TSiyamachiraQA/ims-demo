package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orderline;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderlineController implements CrudController<Orderline> {
	
public static final Logger LOGGER = Logger.getLogger(OrderlineController.class);
	
	private CrudServices<Orderline> orderlineService;
	
	public OrderlineController(CrudServices<Orderline> orderlineService) {
		this.orderlineService = orderlineService;
	}
	
	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Orderline> readAll() {
		List<Orderline> orderlines = orderlineService.readAll();
		for(Orderline orderline: orderlines) {
			LOGGER.info(orderline.toString());
		}
		return orderlines;
	}

	@Override
	public Orderline create() {
		LOGGER.info("Please enter the id of the order you want to add");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the id of the product you want to add");
		Long product_id = Long.valueOf(getInput());
		Orderline orderline = orderlineService.create(new Orderline(order_id, product_id));
		LOGGER.info("Orderline added to inventory");
		return orderline;
	}

	@Override
	public Orderline update() {
		LOGGER.info("Please enter the id of the order you want to update");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the id of the product you want to update");
		Long product_id = Long.valueOf(getInput());
		Orderline orderline = orderlineService.update(new Orderline(order_id, product_id));
		LOGGER.info("Orderline has been updated");
		return orderline;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the order id of the orderline you would like to delete");
		Long order_id = Long.valueOf(getInput());
		orderlineService.delete(order_id);
		LOGGER.info("Orderline Deleted");
		
	}

}
