package com.hit.dao;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "provinces")
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "province_id", nullable = false)
	private Integer id;

	@Column(name = "province_name", nullable = false)
	@Nationalized
	private String name;

	@Column(name = "province_slug", nullable = false)
	@Nationalized
	private String slug;

	@Column(name = "province_type", nullable = false)
	@Nationalized
	private String type;

	@Column(name = "province_name_with_type", nullable = false)
	@Nationalized
	private String nameWithType;

	@Column(name = "province_code", nullable = false, unique = true)
	private String code;

	@JsonIgnore
	@OneToMany(mappedBy = "province", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<District> listDistricts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNameWithType() {
		return nameWithType;
	}

	public void setNameWithType(String nameWithType) {
		this.nameWithType = nameWithType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<District> getListDistricts() {
		return listDistricts;
	}

	public void setListDistricts(List<District> listDistricts) {
		this.listDistricts = listDistricts;
	}

	public Province(Integer id, String name, String slug, String type, String nameWithType, String code,
			List<District> listDistricts) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.type = type;
		this.nameWithType = nameWithType;
		this.code = code;
		this.listDistricts = listDistricts;
	}

	public Province() {
		super();
	}

}
