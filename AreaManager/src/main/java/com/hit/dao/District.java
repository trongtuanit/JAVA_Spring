package com.hit.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "districts")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_id", nullable = false)
	private Integer id;

//	@Column(name = "province_id", nullable = false)
//	private Integer provinceId;

	@Column(name = "district_name", nullable = false)
	@Nationalized
	private String name;

	@Column(name = "district_type", nullable = false)
	@Nationalized
	private String type;

	@Column(name = "district_slug", nullable = false)
	private String slug;

	@Column(name = "district_name_with_type", nullable = false)
	@Nationalized
	private String nameWithType;

	@Column(name = "district_path", nullable = false)
	@Nationalized
	private String path;

	@Column(name = "district_path_with_code", nullable = false)
	@Nationalized
	private String pathWithType;

	@Column(name = "district_code", nullable = false, unique = true)
	@Nationalized
	private String code;

	@Column(name = "district_parent_code", nullable = false)
	private String parentCode;

	@ManyToOne
	@JoinColumn( name = "province_id", nullable = false)
	private Province province;


	public District() {
		super();
	}

	public District(Integer id, String name, String type, String slug, String nameWithType, String path,
		String pathWithType, String code, String parentCode, Province province) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.slug = slug;
	this.nameWithType = nameWithType;
	this.path = path;
	this.pathWithType = pathWithType;
	this.code = code;
	this.parentCode = parentCode;
	this.province = province;
}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getNameWithType() {
		return nameWithType;
	}

	public void setNameWithType(String nameWithType) {
		this.nameWithType = nameWithType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPathWithType() {
		return pathWithType;
	}

	public void setPathWithType(String pathWithType) {
		this.pathWithType = pathWithType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}
