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
@Table(name = "Mainboards")
public class Mainboard extends Product {
	@Id
	@Column(name = "mainboard_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "chipset_support")
	private List<String> chipset; // chipset

	@Column(name = "cpu_support")
	private List<String> cpu; // cpu hỗ trợ

	@Column(name = "socket")
	private List<String> socket; // socket ho tro

	@Column(name = "accessories")
	private List<String> accessories; // phu kien

	@Column(name = "formFactors")
	private String formFactors; // kich thuoc

	@Column(name = "OS_support")
	private List<String> OSs; // os ho tro

	@OneToMany(mappedBy = "mainboard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems;

	public Mainboard(Long id, String name, String brand, List<ProductImage> imageLinks, List<ProductRating> ratings,
			Category categories, String description, String price, Integer saleOff, Integer amount,
			Integer quantitySold, Timestamp createAt, Timestamp updateAt, Long id2, List<String> chipset,
			List<String> cpu, List<String> socket, List<String> accessories, String formFactors, List<String> oSs,
			List<OrderItem> orderItems) {
		super(id, name, brand, imageLinks, ratings, categories, description, price, saleOff, amount, quantitySold,
				createAt, updateAt);
		id = id2;
		this.chipset = chipset;
		this.cpu = cpu;
		this.socket = socket;
		this.accessories = accessories;
		this.formFactors = formFactors;
		OSs = oSs;
		this.orderItems = orderItems;
	}

	public Mainboard() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getChipset() {
		return chipset;
	}

	public void setChipset(List<String> chipset) {
		this.chipset = chipset;
	}

	public List<String> getCpu() {
		return cpu;
	}

	public void setCpu(List<String> cpu) {
		this.cpu = cpu;
	}

	public List<String> getSocket() {
		return socket;
	}

	public void setSocket(List<String> socket) {
		this.socket = socket;
	}

	public List<String> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<String> accessories) {
		this.accessories = accessories;
	}

	public String getFormFactors() {
		return formFactors;
	}

	public void setFormFactors(String formFactors) {
		this.formFactors = formFactors;
	}

	public List<String> getOSs() {
		return OSs;
	}

	public void setOSs(List<String> oSs) {
		OSs = oSs;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
