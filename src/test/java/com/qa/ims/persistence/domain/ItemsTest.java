package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ItemsTest {
	
	private Items items;
	private Items other;

	@Before
	public void setUp() {
		items = new Items(1L, "Gears of War", Integer.valueOf(18), BigDecimal.valueOf(Double.valueOf(37.50)), Integer.valueOf(10));
		other = new Items(1L, "Gears of War", Integer.valueOf(18), BigDecimal.valueOf(Double.valueOf(37.50)), Integer.valueOf(10));
	}
	
	@Test
	public void settersTest() {
		assertNotNull(items.getProduct_id());
		assertNotNull(items.getTitle());
		assertNotNull(items.getRating());
		assertNotNull(items.getPrice());
		assertNotNull(items.getStock());
		
		items.setProduct_id(null);
		assertNull(items.getProduct_id());
		items.setTitle(null);
		assertNull(items.getTitle());
		items.setRating(null);
		assertNull(items.getRating());
		items.setPrice(null);
		assertNull(items.getPrice());
		items.setStock(null);
		assertNull(items.getStock());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(items.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(items.equals(new Object()));
	}
	
	@Test
	public void createItemsWithId() {
		assertEquals(1L, items.getProduct_id(), 0);
		assertEquals("Gears of War", items.getTitle());
		assertEquals(Integer.valueOf(18), items.getRating());
		assertEquals(BigDecimal.valueOf(Double.valueOf(37.50)), items.getPrice());
		assertEquals(Integer.valueOf(10), items.getStock());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(items.equals(items));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(items.equals(other));
	}
//	
//	
//	
	@Test
	public void itemsTitleNullButOtherNameNotNull() {
		items.setTitle(null);
		assertFalse(items.equals(other));
	}
	
	@Test
	public void itemsTitlesNotEqual() {
		other.setTitle("MADDEN 20");
		assertFalse(items.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullTitle() {
		items.setTitle(null);
		other.setTitle(null);
		assertTrue(items.equals(other));
	}
//	
//	
//	
	@Test
	public void nullProductId() {
		items.setProduct_id(null);
		assertFalse(items.equals(other));
	}
	
	@Test
	public void nullProductIdOnBoth() {
		items.setProduct_id(null);
		other.setProduct_id(null);
		assertTrue(items.equals(other));
	}
	
	@Test
	public void otherProductIdDifferent() {
		other.setProduct_id(2L);
		assertFalse(items.equals(other));
	}
//	
//	
//	
	@Test
	public void nullRating() {
		items.setRating(null);
		assertFalse(items.equals(other));
	}
	
	@Test
	public void nullRatingOnBoth() {
		items.setRating(null);
		other.setRating(null);
		assertTrue(items.equals(other));
	}
	
	@Test
	public void otherRatingDifferent() {
		other.setRating(15);
		assertFalse(items.equals(other));
	}
	
//	
//	
	
	@Test
	public void nullPrice() {
		items.setPrice(null);
		assertFalse(items.equals(other));
	}
	
	@Test
	public void nullPriceOnBoth() {
		items.setPrice(null);
		other.setPrice(null);
		assertTrue(items.equals(other));
	}
	
	@Test
	public void otherPriceDifferent() {
		other.setPrice(BigDecimal.valueOf(Double.valueOf(25.99)));
		assertFalse(items.equals(other));
	}
//	
//	
	@Test
	public void nullStock() {
		items.setStock(null);
		assertFalse(items.equals(other));
	}
	
	@Test
	public void nullStockOnBoth() {
		items.setStock(null);
		other.setStock(null);
		assertTrue(items.equals(other));
	}
	
	@Test
	public void otherStockDifferent() {
		other.setStock(25);
		assertFalse(items.equals(other));
	}	
//	
//	
	@Test
	public void constructorWithoutProductId() {
		items = new Items(1L, "Gears of War", Integer.valueOf(18), BigDecimal.valueOf(Double.valueOf(37.50)), Integer.valueOf(10));
		assertNotNull(items.getTitle());
		assertNotNull(items.getRating());
		assertNotNull(items.getPrice());
		assertNotNull(items.getStock());
	}
//
//	
	@Test
	public void hashCodeTest() {
		assertEquals(items.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Items items = new Items(null, null,null, null);
		Items other = new Items(null, null,null, null);
		assertEquals(items.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "product id:1 title:Gears of War rating:18 price:37.5 stock:10";
		assertEquals(toString, items.toString());
	}
}
