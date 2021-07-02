package test.models;

public class TBLDiem {
	private Long maSinhVien;

	private Long maMonHoc;

	private Double diemSo;

	public Long getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(Long maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public Long getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(Long maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public Double getDiemSo() {
		return diemSo;
	}

	public void setDiemSo(Double diemSo) {
		this.diemSo = diemSo;
	}

	public TBLDiem(Long maSinhVien, Long maMonHoc, Double diemSo) {
		super();
		this.maSinhVien = maSinhVien;
		this.maMonHoc = maMonHoc;
		this.diemSo = diemSo;
	}

	public TBLDiem() {
		super();
	}

}
