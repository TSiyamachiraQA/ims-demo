package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orderline;

public class OrderlineServices implements CrudServices<Orderline> {
	
private Dao<Orderline> orderlineDao;
	
	public OrderlineServices(Dao<Orderline> orderlineDao) {
		this.orderlineDao = orderlineDao;
	}
	
	public List<Orderline> readAll() {
		return orderlineDao.readAll();
	}

	public Orderline create(Orderline orderlines) {
		return orderlineDao.create(orderlines);
	}

	public Orderline update(Orderline orderlines) {
		return orderlineDao.update(orderlines);
	}

	public void delete(Long order_id) {
		orderlineDao.delete(order_id);
	}

}

