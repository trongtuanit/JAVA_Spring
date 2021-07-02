package test.models;

public class TBLMonHoc {
	private Long maMonHoc;

	private String tenMonHoc;

	private Double heSoMonHoc;

	public TBLMonHoc(Long maMonHoc, String tenMonHoc, Double heSoMonHoc) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.heSoMonHoc = heSoMonHoc;
	}

	public TBLMonHoc() {
		super();
	}

	public Long getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(Long maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public Double getHeSoMonHoc() {
		return heSoMonHoc;
	}

	public void setHeSoMonHoc(Double heSoMonHoc) {
		this.heSoMonHoc = heSoMonHoc;
	}

}
