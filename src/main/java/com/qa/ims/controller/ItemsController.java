package com.qa.ims.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {
	
	public static final Logger LOGGER = Logger.getLogger(ItemsController.class);
	
	private CrudServices<Items> itemsService;
	
	public ItemsController(CrudServices<Items> itemsService) {
		this.itemsService = itemsService;
	}
	
	String getInput() {
		return Utils.getInput();
	}

	
	@Override
	public List<Items> readAll() {
		List<Items> items = itemsService.readAll();
		for(Items item: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	
	@Override
	public Items create() {
		LOGGER.info("Please enter the title of the product");
		String title = getInput();
		LOGGER.info("Please enter the rating of the product");
		Integer rating = Integer.valueOf(getInput());
		LOGGER.info("Please enter the price of the product");
		BigDecimal price = BigDecimal.valueOf(Double.valueOf(getInput()));
		LOGGER.info("Please enter the available stock of the product");
		Integer stock = Integer.valueOf(getInput());
		Items item = itemsService.create(new Items(title, rating, price, stock));
		LOGGER.info("Product added to inventory");
		return item;

	}

	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the product you would like to update");
		Long productId = Long.valueOf(getInput());
		LOGGER.info("Please enter the title of the product");
		String title = getInput();
		LOGGER.info("Please enter the rating of the product");
		Integer rating = Integer.valueOf(getInput());
		LOGGER.info("Please enter the price of the product");
		BigDecimal price = BigDecimal.valueOf(Double.valueOf(getInput()));
		LOGGER.info("Please enter the available stock of the product");
		Integer stock = Integer.valueOf(getInput());
		Items item = itemsService.update(new Items(productId, title, rating, price, stock));
		LOGGER.info("Product Updated");
		return item;
	
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the product you would like to delete");
		Long productId = Long.valueOf(getInput());
		itemsService.delete(productId);
		LOGGER.info("Product Deleted");
		
	}
}