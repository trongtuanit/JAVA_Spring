package test;

import java.util.Random;

public class HCN {
	private int dai, rong, cao;

	public HCN(int dai, int rong, int cao) {
		super();
		this.dai = dai;
		this.rong = rong;
		this.cao = cao;
	}

	public HCN() {
		Random rd = new Random();
		this.dai = rd.nextInt(101);
		this.rong = rd.nextInt(101);
		this.cao = rd.nextInt(101);
	}

	public int getDai() {
		return dai;
	}

	public void setDai(int dai) {
		this.dai = dai;
	}

	public int getRong() {
		return rong;
	}

	public void setRong(int rong) {
		this.rong = rong;
	}

	public int getCao() {
		return cao;
	}

	public void setCao(int cao) {
		this.cao = cao;
	}

	@Override
	public String toString() {
		return "HCN [dai=" + dai + ", rong=" + rong + ", cao=" + cao + "]";
	}
	
	
}
