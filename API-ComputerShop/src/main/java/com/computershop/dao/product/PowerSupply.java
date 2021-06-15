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
@Table(name = "PowerSupplies")
public class PowerSupply extends Product {
	@Id
	@Column(name = "power_supply_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "connector_type")
	private String connectorType; // Sata/Data

	@Column
	private String dimentions;

	@Column(name = "input_voltage")
	private String inputVoltage;

	@Column(name = "rated_current")
	private String ratedCurrent; // 7A, 1.5A, 2A, ...

	@Column(name = "output_voltage")
	private String outputVoltage;

	@OneToMany(mappedBy = "powerSupply", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems;

	public PowerSupply(Long id, String name, String brand, List<ProductImage> productImages, List<ProductRating> ratings,
			Category categories, Category manufactures, String description, String price, Integer saleOff,
			Integer amount, Integer quantitySold, String warranty, Timestamp createAt, Timestamp updateAt) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
	}

	public PowerSupply(Long id, String name, String brand, List<ProductImage> productImages, List<ProductRating> ratings,
			Category categories, Category manufactures, String description, String price, Integer saleOff,
			Integer amount, Integer quantitySold, String warranty, Timestamp createAt, Timestamp updateAt, Long id2,
			String connectorType, String dimentions, String inputVoltage, String ratedCurrent, String outputVoltage,
			List<OrderItem> orderItems) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
		id = id2;
		this.connectorType = connectorType;
		this.dimentions = dimentions;
		this.inputVoltage = inputVoltage;
		this.ratedCurrent = ratedCurrent;
		this.outputVoltage = outputVoltage;
		this.orderItems = orderItems;
	}

	public PowerSupply() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConnectorType() {
		return connectorType;
	}

	public void setConnectorType(String connectorType) {
		this.connectorType = connectorType;
	}

	public String getDimentions() {
		return dimentions;
	}

	public void setDimentions(String dimentions) {
		this.dimentions = dimentions;
	}

	public String getInputVoltage() {
		return inputVoltage;
	}

	public void setInputVoltage(String inputVoltage) {
		this.inputVoltage = inputVoltage;
	}

	public String getRatedCurrent() {
		return ratedCurrent;
	}

	public void setRatedCurrent(String ratedCurrent) {
		this.ratedCurrent = ratedCurrent;
	}

	public String getOutputVoltage() {
		return outputVoltage;
	}

	public void setOutputVoltage(String outputVoltage) {
		this.outputVoltage = outputVoltage;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
