package test;

import java.util.HashMap;

public class C {
	private String textC;

	private D d;
	
	private E e;
	
	private HashMap<Object, Integer> hashMap;

	public C(String textC, D d, HashMap<Object, Integer> hashMap) {
		super();
		this.textC = textC;
		this.d = d;
		this.hashMap = hashMap;
	}

	public C() {
		super();
	}

	public String getTextC() {
		return textC;
	}

	public void setTextC(String textC) {
		this.textC = textC;
	}

	public D getD() {
		return d;
	}

	public void setD(D d) {
		this.d = d;
	}

	public HashMap<Object, Integer> getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap<Object, Integer> hashMap) {
		this.hashMap = hashMap;
	}

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}
	
	
	
	
}
