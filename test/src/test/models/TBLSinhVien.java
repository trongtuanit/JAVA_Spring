package test.models;

import java.util.Date;

public class TBLSinhVien {
	public enum Gender{
		Nam, Nữ
	}
	
	private Long maSV;
	
	private String hoDem;
	
	private String ten;
	
	private Date NgaySinh;
	
	private Gender gioiTinh;

	public TBLSinhVien(Long maSV, String hoDem, String ten, Date ngaySinh, Gender gioiTinh) {
		super();
		this.maSV = maSV;
		this.hoDem = hoDem;
		this.ten = ten;
		NgaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}

	public TBLSinhVien() {
		super();
	}

	public Long getMaSV() {
		return maSV;
	}

	public void setMaSV(Long maSV) {
		this.maSV = maSV;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public Gender getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Gender gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}
