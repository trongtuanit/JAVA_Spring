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
@Table(name = "GraphicCards")
public class GraphicCard extends Product {
	@Id
	@Column(name = "graphic_card_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long graphicCardId;

	@Column(name = "dimensions")
	private String dimensions;

	@Column
	private String weight;

	@Column(name = "vga_memory")
	private String VGAMemory;

	@Column(name = "bandwidth")
	private String bandwidth;

	@OneToMany(mappedBy = "graphicCard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems;

	@Column
	private String voltage;

	public GraphicCard(Long id, String name, String brand, List<ProductImage> productImages,
			List<ProductRating> ratings, Category categories, Category manufactures, String description, String price,
			Integer saleOff, Integer amount, Integer quantitySold, String warranty, Timestamp createAt,
			Timestamp updateAt) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
	}

	public GraphicCard(Product product) {
		super(product.getId(), product.getName(), product.getBrand(), product.getProductImages(), product.getRatings(),
				product.getCategories(), product.getManufactures(), product.getDescription(), product.getPrice(),
				product.getSaleOff(), product.getAmount(), product.getQuantitySold(), product.getWarranty(),
				product.getCreateAt(), product.getUpdateAt());

	}

	public GraphicCard(Product product, Long id2, String dimensions, String weight, String vGAMemory, String bandwidth,
			List<OrderItem> orderItems, String voltage) {
		super(product.getId(), product.getName(), product.getBrand(), product.getProductImages(), product.getRatings(),
				product.getCategories(), product.getManufactures(), product.getDescription(), product.getPrice(),
				product.getSaleOff(), product.getAmount(), product.getQuantitySold(), product.getWarranty(),
				product.getCreateAt(), product.getUpdateAt());
		this.graphicCardId = id2;
		this.dimensions = dimensions;
		this.weight = weight;
		this.VGAMemory = vGAMemory;
		this.bandwidth = bandwidth;
		this.orderItems = orderItems;
		this.voltage = voltage;
	}

	public GraphicCard(Long id, String name, String brand, List<ProductImage> productImages,
			List<ProductRating> ratings, Category categories, Category manufactures, String description, String price,
			Integer saleOff, Integer amount, Integer quantitySold, String warranty, Timestamp createAt,
			Timestamp updateAt, Long id2, String dimensions, String weight, String vGAMemory, String bandwidth,
			List<OrderItem> orderItems, String voltage) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
		this.graphicCardId = id2;
		this.dimensions = dimensions;
		this.weight = weight;
		this.VGAMemory = vGAMemory;
		this.bandwidth = bandwidth;
		this.orderItems = orderItems;
		this.voltage = voltage;
	}

	public GraphicCard() {
		super();
	}

	public Long getGraphicCardId() {
		return graphicCardId;
	}

	public void setGraphicCardId(Long id) {
		this.graphicCardId = id;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVGAMemory() {
		return VGAMemory;
	}

	public void setVGAMemory(String vGAMemory) {
		VGAMemory = vGAMemory;
	}

	public String getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

}
