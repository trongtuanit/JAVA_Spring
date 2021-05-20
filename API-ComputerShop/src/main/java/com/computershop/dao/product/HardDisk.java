package com.computershop.dao.product;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.computershop.dao.Category;
import com.computershop.dao.OrderItem;
import com.computershop.dao.Product;
import com.computershop.dao.ProductImage;
import com.computershop.dao.ProductRating;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "HardDisks")
public class HardDisk extends Product {
	@Id
	@Column(name = "hard_disk_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "interface_type")
	private String interfaceType;

	@Column
	private String cache;

	@Column
	private String capacity;

	@Column
	private String style; // HDD, SSD ...

	@Column
	private String size;

	@OneToMany(mappedBy = "hardDisk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems;

	public HardDisk(Long id, String name, String brand, List<ProductImage> imageLinks, List<ProductRating> ratings,
			Category categories, String description, String price, Integer saleOff, Integer amount,
			Integer quantitySold, Timestamp createAt, Timestamp updateAt, Long id2, String interfaceType, String cache,
			String capacity, String style, String size, List<OrderItem> orderItems) {
		super(id, name, brand, imageLinks, ratings, categories, description, price, saleOff, amount, quantitySold,
				createAt, updateAt);
		id = id2;
		this.interfaceType = interfaceType;
		this.cache = cache;
		this.capacity = capacity;
		this.style = style;
		this.size = size;
		this.orderItems = orderItems;
	}

	public HardDisk() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
