package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.ItemsServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemsControllerTest {

	@Mock
	private ItemsServices itemsServices;
	
	
	@Spy
	@InjectMocks
	private ItemsController itemsController;
	
	
	@Test
	public void readAllTest() {
		ItemsController itemsController = new ItemsController(itemsServices);
		List<Items> items = new ArrayList<>();
		items.add(new Items("GTA IV", 18 , BigDecimal.valueOf(Double.valueOf(34.89)) , 10));
		items.add(new Items("FIFA", 12 , BigDecimal.valueOf(Double.valueOf(49.89)) , 100));
		items.add(new Items("F1", 3 , BigDecimal.valueOf(Double.valueOf(39.12)) , 50));
		Mockito.when(itemsServices.readAll()).thenReturn(items);
		assertEquals(items, itemsController.readAll());
	}

	@Test
	public void createTest() {
		String title = "Gears of War";
		Integer rating = Integer.valueOf(18);
		BigDecimal price = BigDecimal.valueOf(Double.valueOf(37.5));
		Integer stock = Integer.valueOf(10);
		Mockito.doReturn(title, rating, price, stock).when(itemsController).getInput();
		Items items = new Items(title, rating, price, stock);
		Items savedItems = new Items(1L, "Gears of War", Integer.valueOf(18), BigDecimal.valueOf(Double.valueOf(37.5)), Integer.valueOf(10));
		Mockito.when(itemsServices.create(items)).thenReturn(savedItems);
		assertEquals(savedItems, itemsController.create());
	}
	
	@Test
	public void updateTest() {
		Long product_id = Long.valueOf(1);
		String title = "Gears of War";
		Integer rating = Integer.valueOf(18);
		BigDecimal price = BigDecimal.valueOf(Double.valueOf(37.5));
		Integer stock = Integer.valueOf(10);
		Mockito.doReturn(product_id, title, rating, price, stock).when(itemsController).getInput();
		Items items = new Items(1L, "Gears of War", Integer.valueOf(18), BigDecimal.valueOf(Double.valueOf(37.5)), Integer.valueOf(10));
		Mockito.when(itemsServices.update(items)).thenReturn(items);
		assertEquals(items, itemsController.update());
		
		
	}
	
	@Test
	public void deleteTest() {
		String product_id = "1";
		Mockito.doReturn(product_id).when(itemsController).getInput();
		itemsController.delete();
		Mockito.verify(itemsServices, Mockito.times(1)).delete(1L);
	}
	
}
