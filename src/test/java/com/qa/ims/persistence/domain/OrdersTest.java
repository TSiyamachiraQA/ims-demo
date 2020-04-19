package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class OrdersTest {
	
	private Orders orders;
	private Orders other;

	@Before
	public void setUp() {
		orders = new Orders(1L, 1L, Integer.valueOf(10), BigDecimal.valueOf(Double.valueOf(37.50)));
		other = new Orders(1L, 1L, Integer.valueOf(10), BigDecimal.valueOf(Double.valueOf(37.50)));
	}
	
	@Test
	public void settersTest() {
		assertNotNull(orders.getOrderId());
		assertNotNull(orders.getCustomerId());
		assertNotNull(orders.getQuantity());
		assertNotNull(orders.getTotal());
		
		
		orders.setOrderId(null);
		assertNull(orders.getOrderId());
		orders.setCustomerId(null);
		assertNull(orders.getCustomerId());
		orders.setQuantity(null);
		assertNull(orders.getQuantity());
		orders.setTotal(null);
		assertNull(orders.getTotal());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(orders.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(orders.equals(new Object()));
	}
	
	@Test
	public void createOrderWithId() {
		assertEquals(1L, orders.getOrderId(), 0);
		assertEquals(Long.valueOf(1L), orders.getCustomerId());
		assertEquals(Integer.valueOf(10), orders.getQuantity());
		assertEquals(BigDecimal.valueOf(Double.valueOf(37.50)), orders.getTotal());

	}
	 
	@Test
	public void checkEquality() {
		assertTrue(orders.equals(orders));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(orders.equals(other));
	}
	
//	
//	
	
	@Test
	public void customersIdNullButOtherNameNotNull() {
		orders.setCustomerId(null);
		assertFalse(orders.equals(other));
	}
	
	@Test
	public void customersIdNotEqual() {
		other.setCustomerId(3L);
		assertFalse(orders.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullTitle() {
		orders.setCustomerId(null);
		other.setCustomerId(null);
		assertTrue(orders.equals(other));
	}
//	
//	
	@Test
	public void nullOrderId() {
		orders.setOrderId(null);
		assertFalse(orders.equals(other));
	}
	
	@Test
	public void nullOrderIdOnBoth() {
		orders.setOrderId(null);
		other.setOrderId(null);
		assertTrue(orders.equals(other));
	}
	
	@Test
	public void otherOrderIdDifferent() {
		other.setOrderId(2L);
		assertFalse(orders.equals(other));
	}
//	
//	
	@Test
	public void nullQuantity() {
		orders.setQuantity(null);
		assertFalse(orders.equals(other));
	}
	
	@Test
	public void nullQuantityOnBoth() {
		orders.setQuantity(null);
		other.setQuantity(null);
		assertTrue(orders.equals(other));
	}
	
	@Test
	public void otherQuantityDifferent() {
		other.setQuantity(15);
		assertFalse(orders.equals(other));
	}
//	
//	
	@Test
	public void nullTotal() {
		orders.setTotal(null);
		assertFalse(orders.equals(other));
	}
	
	@Test
	public void nullTotalOnBoth() {
		orders.setTotal(null);
		other.setTotal(null);
		assertTrue(orders.equals(other));
	}
	
	@Test
	public void otherTotalDifferent() {
		other.setTotal(BigDecimal.valueOf(Double.valueOf(15.3)));
		assertFalse(orders.equals(other));
	}
//	
//	
	@Test
	public void constructorWithoutOrderId() {
		orders = new Orders(2L, Integer.valueOf(18), BigDecimal.valueOf(Double.valueOf(37.50)));
		assertNotNull(orders.getCustomerId());
		assertNotNull(orders.getQuantity());
		assertNotNull(orders.getTotal());
	}
//	
//	
	@Test
	public void hashCodeTest() {
		assertEquals(orders.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Orders orders = new Orders(null, null,null);
		Orders other = new Orders(null, null,null);
		assertEquals(orders.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "order id:1 customer id:1 order placed:10 total:37.5";
		assertEquals(toString, orders.toString());
	}
}
