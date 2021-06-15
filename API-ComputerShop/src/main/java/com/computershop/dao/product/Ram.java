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
@Table(name = "Rams")
public class Ram extends Product {
	@Id
	@Column(name = "ram_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "part_number")
	private String partNumber; // Mã SP

	@Column
	private String capacity; // dung lượng (8gb/16gb..)

	@Column
	private String DDR; // DDR4, DDR3, ....

	@Column(name = "type_of_bus")
	private String typeOfBus; // Buss 2400, Bus 2133,

	@Column(name = "dimm_type")
	private String DimmType; // UDIMM, RDIMM...

	@OneToMany(mappedBy = "ram", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems;

	public Ram(Long id, String name, String brand, List<ProductImage> productImages, List<ProductRating> ratings,
			Category categories, Category manufactures, String description, String price, Integer saleOff,
			Integer amount, Integer quantitySold, String warranty, Timestamp createAt, Timestamp updateAt) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
	}

	public Ram(Long id, String name, String brand, List<ProductImage> productImages, List<ProductRating> ratings,
			Category categories, Category manufactures, String description, String price, Integer saleOff,
			Integer amount, Integer quantitySold, String warranty, Timestamp createAt, Timestamp updateAt, Long id2,
			String partNumber, String capacity, String dDR, String typeOfBus, String dimmType,
			List<OrderItem> orderItems) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
		id = id2;
		this.partNumber = partNumber;
		this.capacity = capacity;
		DDR = dDR;
		this.typeOfBus = typeOfBus;
		DimmType = dimmType;
		this.orderItems = orderItems;
	}

	public Ram() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getDDR() {
		return DDR;
	}

	public void setDDR(String dDR) {
		DDR = dDR;
	}

	public String getTypeOfBus() {
		return typeOfBus;
	}

	public void setTypeOfBus(String typeOfBus) {
		this.typeOfBus = typeOfBus;
	}

	public String getDimmType() {
		return DimmType;
	}

	public void setDimmType(String dimmType) {
		DimmType = dimmType;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
