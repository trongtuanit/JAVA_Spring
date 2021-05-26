package test;

public class D extends C{
	private String textD;


	public D(String textC) {
		super(textC);
	}

	public D(String textC, String textD) {
		super(textC);
		this.textD = textD;
	}

	public String getTextD() {
		return textD;
	}

	public void setTextD(String a) {
		this.textD = a;
	}
	
	
}
