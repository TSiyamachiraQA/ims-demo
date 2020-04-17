package com.qa.ims.services;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;


@RunWith(MockitoJUnitRunner.class)
public class ItemsServicesTest {
	@Mock
	private Dao<Items> itemsDao;
	
	@InjectMocks
	private ItemsServices itemsServices;
	
	@Test
	public void customerServicesCreate() {
		Items items = new Items("Gears of War", Integer.valueOf(18), BigDecimal.valueOf(Double.valueOf(37.50)), Integer.valueOf(10));
		itemsServices.create(items);
		Mockito.verify(itemsDao, Mockito.times(1)).create(items);
	}
	
	@Test
	public void customerServicesRead() {
		itemsServices.readAll();
		Mockito.verify(itemsDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void customerServicesUpdate() {
		Items items = new Items("Gears of War", Integer.valueOf(18), BigDecimal.valueOf(Double.valueOf(37.50)), Integer.valueOf(10));
		itemsServices.update(items);
		Mockito.verify(itemsDao, Mockito.times(1)).update(items);
	}
	
	@Test
	public void customerServicesDelete() {
		itemsServices.delete(1L);;
		Mockito.verify(itemsDao, Mockito.times(1)).delete(1L);
	}

}
