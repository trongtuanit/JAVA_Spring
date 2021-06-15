package test;

public class Subject {
	private int code;
	private String name;
	
	public Subject(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public Subject() {
		super();
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
