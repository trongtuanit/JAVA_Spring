package com.hit.com.hit.entity;

import java.util.Arrays;
import java.util.List;

public class ProductInfo {
	private String product;
	
	private List<String> images;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public ProductInfo(String product, List<String> images) {
		super();
		this.product = product;
		this.images = images;
	}

	public ProductInfo() {
		super();
		this.images = Arrays.asList("chua co du lieu!");
	}

	@Override
	public String toString() {
		return "ProductInfo [product=" + product + ", images=" + images + "]";
	}
	
	
}
