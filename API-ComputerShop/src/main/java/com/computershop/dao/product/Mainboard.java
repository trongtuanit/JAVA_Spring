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
	private Long mainboardId;

	@Column(name = "chipset_support")
	private String chipset; // chipset

	@Column(name = "cpu_support")
	private String cpu; // cpu hỗ trợ

	@Column(name = "socket")
	private String socket; // socket ho tro

	@Column(name = "accessories")
	private String accessories; // phu kien

	@Column(name = "formFactors")
	private String formFactors; // kich thuoc

	@Column(name = "OS_support")
	private String OSs; // os ho tro

	@OneToMany(mappedBy = "mainboard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems;

	public Mainboard(Product product) {
		super(product.getId(), product.getName(), product.getBrand(), product.getProductImages(), product.getRatings(),
				product.getCategories(), product.getManufactures(), product.getDescription(), product.getPrice(),
				product.getSaleOff(), product.getAmount(), product.getQuantitySold(), product.getWarranty(),
				product.getCreateAt(), product.getUpdateAt());

	}

	public Mainboard(Product product, Long id2, String chipset, String cpu, String socket, String accessories,
			String formFactors, String oSs, List<OrderItem> orderItems) {
		super(product.getId(), product.getName(), product.getBrand(), product.getProductImages(), product.getRatings(),
				product.getCategories(), product.getManufactures(), product.getDescription(), product.getPrice(),
				product.getSaleOff(), product.getAmount(), product.getQuantitySold(), product.getWarranty(),
				product.getCreateAt(), product.getUpdateAt());
		this.mainboardId = id2;
		this.chipset = chipset;
		this.cpu = cpu;
		this.socket = socket;
		this.accessories = accessories;
		this.formFactors = formFactors;
		this.OSs = oSs;
		this.orderItems = orderItems;
	}

	public Mainboard(Long id, String name, String brand, List<ProductImage> productImages, List<ProductRating> ratings,
			Category categories, Category manufactures, String description, String price, Integer saleOff,
			Integer amount, Integer quantitySold, String warranty, Timestamp createAt, Timestamp updateAt) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
	}

	public Mainboard(Long id, String name, String brand, List<ProductImage> productImages, List<ProductRating> ratings,
			Category categories, Category manufactures, String description, String price, Integer saleOff,
			Integer amount, Integer quantitySold, String warranty, Timestamp createAt, Timestamp updateAt, Long id2,
			String chipset, String cpu, String socket, String accessories, String formFactors, String oSs,
			List<OrderItem> orderItems) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
		this.mainboardId = id2;
		this.chipset = chipset;
		this.cpu = cpu;
		this.socket = socket;
		this.accessories = accessories;
		this.formFactors = formFactors;
		this.OSs = oSs;
		this.orderItems = orderItems;
	}

	public Long getMainboardId() {
		return mainboardId;
	}

	public void setMainboardId(Long id) {
		this.mainboardId = id;
	}

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public String getFormFactors() {
		return formFactors;
	}

	public void setFormFactors(String formFactors) {
		this.formFactors = formFactors;
	}

	public String getOSs() {
		return OSs;
	}

	public void setOSs(String oSs) {
		OSs = oSs;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
