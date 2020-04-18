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

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.OrdersServices;

@RunWith(MockitoJUnitRunner.class)
public class OrdersControllerTest {

	@Mock
	private OrdersServices ordersServices;
	

	@Spy
	@InjectMocks
	private OrdersController ordersController;
	
	@Test
	public void readAllTest() {
		OrdersController ordersController = new OrdersController(ordersServices);
		List<Orders> orders = new ArrayList<>();
		orders.add(new Orders(1L, 3, BigDecimal.valueOf(Double.valueOf(50.89))));
		orders.add(new Orders(2L, 4, BigDecimal.valueOf(Double.valueOf(39.89))));
		orders.add(new Orders(4L, 12, BigDecimal.valueOf(Double.valueOf(23.99))));
		Mockito.when(ordersServices.readAll()).thenReturn(orders);
		assertEquals(orders, ordersController.readAll());
	}
	
	@Test
	public void createTest() {
		Long customer_id = Long.valueOf(14);
		Integer quantity = Integer.valueOf(2);
		BigDecimal total = BigDecimal.valueOf(Double.valueOf(78.9));
		String customer_id1 = "14";
		String quantity1 = "2";
		String total1 = "78.9";
		Mockito.doReturn(customer_id1, quantity1, total1).when(ordersController).getInput();
		Orders orders = new Orders(customer_id, quantity, total);
		Orders savedOrders = new Orders(2L, 1L, Integer.valueOf(2), BigDecimal.valueOf(Double.valueOf(78.9)));
		Mockito.when(ordersServices.create(orders)).thenReturn(savedOrders);
		assertEquals(savedOrders, ordersController.create());
	}
	
	@Test
	public void updateTest() {
		String order_id1 = "1";
		String customer_id1 = "1";
		String quantity1 = "2";
		String total1 = "78.9";
		Mockito.doReturn(order_id1, customer_id1, quantity1, total1).when(ordersController).getInput();
		Orders orders = new Orders(1L, 1L, Integer.valueOf(2), BigDecimal.valueOf(Double.valueOf(78.9)));
		Mockito.when(ordersServices.update(orders)).thenReturn(orders);
		assertEquals(orders, ordersController.update());
		
		
	}
	
	@Test
	public void deleteTest() {
		String orders_id = "1";
		Mockito.doReturn(orders_id).when(ordersController).getInput();
		ordersController.delete();
		Mockito.verify(ordersServices, Mockito.times(1)).delete(1L);
	}
	
}
