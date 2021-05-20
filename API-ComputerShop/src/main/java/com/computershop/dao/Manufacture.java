package com.computershop.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "Manufactures")
public class Manufacture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manufacture_id")
	private Long manufactureId;
	
	@Column(name = "name", nullable = false)
	@Nationalized
	private String name;
	
	@Column(name = "warranty_summary", nullable = false)
	@Nationalized
	private String WarrantySummary;
	
	@Column(name = "covered_in_warranty", nullable = false)
	@Nationalized
	private String CoveredInWarranty;
	
	@CreationTimestamp
	private Timestamp createAt;
	
	@UpdateTimestamp
	private Timestamp updateAt;

	public Manufacture(Long manufactureId, String name, String warrantySummary, String coveredInWarranty,
			Timestamp createAt, Timestamp updateAt) {
		super();
		this.manufactureId = manufactureId;
		this.name = name;
		WarrantySummary = warrantySummary;
		CoveredInWarranty = coveredInWarranty;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Manufacture() {
		super();
	}

	public Long getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(Long manufactureId) {
		this.manufactureId = manufactureId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWarrantySummary() {
		return WarrantySummary;
	}

	public void setWarrantySummary(String warrantySummary) {
		WarrantySummary = warrantySummary;
	}

	public String getCoveredInWarranty() {
		return CoveredInWarranty;
	}

	public void setCoveredInWarranty(String coveredInWarranty) {
		CoveredInWarranty = coveredInWarranty;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
}
