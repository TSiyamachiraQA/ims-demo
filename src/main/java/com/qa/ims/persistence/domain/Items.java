package com.qa.ims.persistence.domain;

import java.math.BigDecimal;

public class Items {
	
	private Long product_id;
	private String title;
	private Integer rating;
	private BigDecimal price;
	private Integer stock;
	
	public Items(String title, Integer rating, BigDecimal price, Integer stock) {
		this.title = title;
		this.rating = rating;
		this.price = price;
		this.stock = stock;
	}

	public Items(Long product_id, String title, Integer rating, BigDecimal price, Integer stock) {
		this.title = title;
		this.rating = rating;
		this.price = price;
		this.product_id = product_id;
		this.stock = stock;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Long getProductid() {
		return product_id;
	}

	public void setProductid(Long product_id) {
		this.product_id = product_id;
	}

	public String getTitle() {
		return title;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String toString() {
		return "product id:" + product_id + " title:" + title + " rating:" + rating + " price:" + price + " stock:" + stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product_id == null) {
			if (other.product_id != null)
				return false;
		} else if (!product_id.equals(other.product_id))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
