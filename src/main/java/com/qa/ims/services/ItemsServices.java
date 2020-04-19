package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;

public class ItemsServices implements CrudServices<Items> {
	
private Dao<Items> itemsDao;
	
	public ItemsServices(Dao<Items> itemsDao) {
		this.itemsDao = itemsDao;
	}
	
	public List<Items> readAll() {
		return itemsDao.readAll();
	}

	public Items create(Items items) {
		return itemsDao.create(items);
	}

	public Items update(Items items) {
		return itemsDao.update(items);
	}

	public void delete(Long productId) {
		itemsDao.delete(productId);
	}

}
