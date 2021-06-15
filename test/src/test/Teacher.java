package test;

import java.util.Scanner;

public class Teacher extends Employee{

	private static Scanner scanner = new Scanner(System.in); 
	
	private double coSalary;
	
	private double salary;
	
	private Subject subject;
	
	private int hours;

	public Teacher(int code, String surname, String name, Date date, int yearWorking, double coSalary, double salary,
			Subject subject, int hours) {
		
		this.coSalary = coSalary;
		this.salary = salary;
		this.subject = subject;
		this.hours = hours;
	}

	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public double getCoSalary() {
		return coSalary;
	}

	public void setCoSalary(double coSalary) {
		this.coSalary = coSalary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	@Override
	public void input() {
		subject = new Subject();
		date = new Date();
		
		System.out.println("Nhap subject code: ");
		int sjCode = scanner.nextInt();
		subject.setCode(sjCode);
		scanner.nextLine();

		System.out.println("Nhap subject name: ");
		String sjName = scanner.nextLine();
		subject.setName(sjName);
		
		
		System.out.println("Nhap ngay: ");
		int dayTmp = scanner.nextInt();
		date.setDay(dayTmp);
		
		
		System.out.println("Nhap thang: ");
		int monthTmp = scanner.nextInt();
		date.setMonth(monthTmp);
		
		
		System.out.println("Nhap nam: ");
		int yearTmp = scanner.nextInt();
		this.date.setYear(yearTmp);
		
		System.out.println("Nhap code: ");
		this.code = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Nhap surname: ");
		this.surname = scanner.nextLine();
		
		System.out.println("Nhap name: ");
		this.name = scanner.nextLine();
		
		System.out.println("Nhap yearWorking: ");
		this.yearWorking = scanner.nextInt();
		
		
		System.out.println("Nhap coSalary: ");
		this.coSalary = scanner.nextDouble();
		
		System.out.println("Nhap salary: ");
		this.salary = scanner.nextDouble();
		
		System.out.println("Nhap hours: ");
		this.hours = scanner.nextInt();

	}
	
	
	
	
	@Override
	public void output() {
	
		System.out.println("code: " + this.code);
		System.out.println("surname: " + this.surname);
		System.out.println("name: " + this.name);
		System.out.println("yearWorking: " + this.yearWorking);
		System.out.println("CoSalary: " + this.getCoSalary());
		System.out.println("Salary: " + this.getSalary());
		System.out.println("Hours: " + this.getHours());
		
		System.out.println("Ngay: "+ this.date.getDay());
		System.out.println("thang: "+ this.date.getMonth());
		System.out.println("nam: "+ this.date.getYear());
		System.out.println("SubjectCode: " + this.subject.getCode());
		System.out.println("SubjectName: " + this.subject.getName());
		
	}
	
	public void calc() {
		System.out.println("salary: " + coSalary * salary);
	}
	
}
