package test;

public class main {

	public static void main(String[] args) throws Exception {

//		try {
//			if (!"hello".equals("what"))
//				throw new InvalidException("Thong tin khong hop le!");
//			else
//				System.out.println("hello world");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		try {
//			if (!"hello".contains("u"))
//				throw new NotFoundException("Khong tim thay du lieu!");
//			else
//				System.out.println("hello world");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		// Neu nhu khong co try - catch thi sau thi nem ra 1 loi chuong trinh se dung lai luon
		if (!"hello".contains("u"))
			throw new NotFoundException("Khong tim thay du lieu!");
			
		if (!"hello".equals("what"))
			throw new InvalidException("Thong tin khong hop le!");
	}

}