package com.computershop.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

//import lombok.Data;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ProductImages")

public class ProductImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private Long imageId;
	
	@Column(name = "image_link", nullable = false)
	private String imageLink;
	
	@Column(name = "public_id", nullable = false)
	private String publicId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@CreationTimestamp
	private Timestamp createAt;
	
	@UpdateTimestamp
	private Timestamp updateAt;

	public ProductImage(long imageId, String imageLink, String publicId, Product product, Timestamp createAt,
			Timestamp updateAt) {
		super();
		this.imageId = imageId;
		this.imageLink = imageLink;
		this.publicId = publicId;
		this.product = product;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public ProductImage() {
		super();
	}

	public ProductImage(Long imageId, String imageLink, String publicId, Product product, Timestamp createAt,
			Timestamp updateAt) {
		super();
		this.imageId = imageId;
		this.imageLink = imageLink;
		this.publicId = publicId;
		this.product = product;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
	
}