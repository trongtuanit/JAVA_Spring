package test;


public abstract class Employee {
	protected int code;
	
	protected String surname;
	
	protected String name;
	
	protected Date date;
	
	protected int yearWorking;

	public Employee(int code, String surname, String name, Date date, int yearWorking) {
		super();
		this.code = code;
		this.surname = surname;
		this.name = name;
		this.date = date;
		this.yearWorking = yearWorking;
	}

	public Employee() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getYearWorking() {
		return yearWorking;
	}

	public void setYearWorking(int yearWorking) {
		this.yearWorking = yearWorking;
	}
	

	abstract void input();
	
	abstract void output();
	
}
