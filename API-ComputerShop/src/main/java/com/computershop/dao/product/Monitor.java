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

import org.hibernate.annotations.Nationalized;

import com.computershop.dao.Category;
import com.computershop.dao.OrderItem;
import com.computershop.dao.Product;
import com.computershop.dao.ProductImage;
import com.computershop.dao.ProductRating;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Monitors")
public class Monitor extends Product {
	@Id
	@Column(name = "monitor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long monitorId;

	@Column(name = "screen_size")
	private String screenSize;

	@Column(name = "maximum_resolution")
	private String maximumResolution;

	@Column(name = "native_resolution")
	private String nativeResolution;

	@Column
	@Nationalized
	private String color;

	@Column(name = "refresh_rate")
	private String refreshRate;

	@Column(name = "aspect_ratio")
	private String aspectRatio;

	@Column(name = "touch_screen")
	@Nationalized
	private String touchScreen;

	@OneToMany(mappedBy = "monitor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems;

	public Monitor(Product product) {
		super(product.getId(), product.getName(), product.getBrand(), product.getProductImages(), product.getRatings(),
				product.getCategories(), product.getManufactures(), product.getDescription(), product.getPrice(),
				product.getSaleOff(), product.getAmount(), product.getQuantitySold(), product.getWarranty(),
				product.getCreateAt(), product.getUpdateAt());

	}

	public Monitor(Product product, Long id2, String screenSize, String maximumResolution, String nativeResolution,
			String color, String refreshRate, String aspectRatio, String touchScreen, List<OrderItem> orderItems) {
		super(product.getId(), product.getName(), product.getBrand(), product.getProductImages(), product.getRatings(),
				product.getCategories(), product.getManufactures(), product.getDescription(), product.getPrice(),
				product.getSaleOff(), product.getAmount(), product.getQuantitySold(), product.getWarranty(),
				product.getCreateAt(), product.getUpdateAt());
		this.monitorId = id2;
		this.screenSize = screenSize;
		this.maximumResolution = maximumResolution;
		this.nativeResolution = nativeResolution;
		this.color = color;
		this.refreshRate = refreshRate;
		this.aspectRatio = aspectRatio;
		this.touchScreen = touchScreen;
		this.orderItems = orderItems;
	}

	public Monitor(Long id, String name, String brand, List<ProductImage> productImages, List<ProductRating> ratings,
			Category categories, Category manufactures, String description, String price, Integer saleOff,
			Integer amount, Integer quantitySold, String warranty, Timestamp createAt, Timestamp updateAt) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
	}

	public Monitor(Long id, String name, String brand, List<ProductImage> productImages, List<ProductRating> ratings,
			Category categories, Category manufactures, String description, String price, Integer saleOff,
			Integer amount, Integer quantitySold, String warranty, Timestamp createAt, Timestamp updateAt, Long id2,
			String screenSize, String maximumResolution, String nativeResolution, String color, String refreshRate,
			String aspectRatio, String touchScreen, List<OrderItem> orderItems) {
		super(id, name, brand, productImages, ratings, categories, manufactures, description, price, saleOff, amount,
				quantitySold, warranty, createAt, updateAt);
		this.monitorId = id2;
		this.screenSize = screenSize;
		this.maximumResolution = maximumResolution;
		this.nativeResolution = nativeResolution;
		this.color = color;
		this.refreshRate = refreshRate;
		this.aspectRatio = aspectRatio;
		this.touchScreen = touchScreen;
		this.orderItems = orderItems;
	}

	public Monitor() {
		super();
	}

	public Long getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(Long id) {
		this.monitorId = id;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getMaximumResolution() {
		return maximumResolution;
	}

	public void setMaximumResolution(String maximumResolution) {
		this.maximumResolution = maximumResolution;
	}

	public String getNativeResolution() {
		return nativeResolution;
	}

	public void setNativeResolution(String nativeResolution) {
		this.nativeResolution = nativeResolution;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}

	public String getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	public String getTouchScreen() {
		return touchScreen;
	}

	public void setTouchScreen(String touchScreen) {
		this.touchScreen = touchScreen;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
