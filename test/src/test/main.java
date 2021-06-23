package test;

//import java.util.ArrayList;
//import java.util.List;

public class main {
	
	public static void main(String[] args) {
		
	    try {
			if(!"hello".equals("what"))
				throw new InvalidException("Thong tin khong hop le!");
			else
				System.out.println("hello world");
		} catch (Exception e) {
			System.out.println(e);
		}
	    
	    
	    try {
			if(!"hello".contains("u"))
				throw new NotFoundException("Khong tim thay du lieu!");
			else
				System.out.println("hello world");
		} catch (Exception e) {
			System.out.println(e);
		}
	    
	}

}