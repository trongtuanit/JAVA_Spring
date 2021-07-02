package test.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import test.controllers.DataController;
import test.controllers.DataUtility;
import test.models.TBLSinhVien;
import test.models.TBLSinhVien.Gender;

public class View {
	private final static String TBLSinhVien_filename = "TBLSinhVien.txt";
	
	// tra ve true neu khong co sinh vien co id ton tai
	public static boolean kiemTraSinhVienTonTaiTheoId(List<TBLSinhVien> list, Long maSV) {
		for(TBLSinhVien s : list) 
			if(s.getMaSV()==maSV)
				return false; 
		return true; 
	}
	
	private static Date convertStringToDate(String dateString) throws ParseException {
		final DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
		Date date = df1.parse(dateString);
        return date;
	}
	
	public static void main(String[] args) throws Exception {
		DataController dataController = new DataController();
		DataUtility dataUtility = new DataUtility();
		
		ArrayList<TBLSinhVien> listSinhVien;
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
            System.out.println("------------------------------MENU----------------------");
            System.out.println("1. Add student");
            System.out.println("0. Exit");
            
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();
            
            switch (choice) {
			case 1:
				listSinhVien = dataController.DocTBLSinhVienTuFile(TBLSinhVien_filename);
				boolean idTonTai = false;
				Long studentId;
				String hoDem, ten, ngaySinh, gioiTinh;
				do {
					System.out.print("Nhập mã sinh viên: ");
					studentId = scanner.nextLong();
					scanner.nextLine();
					if(kiemTraSinhVienTonTaiTheoId(listSinhVien, studentId) == false) {
						System.out.println("MSV đã tồn tại!");
						idTonTai = kiemTraSinhVienTonTaiTheoId(listSinhVien, studentId);
					}
				}while(idTonTai);
				
				System.out.print("Nhập vào họ đệm sinh viên: ");
				hoDem = scanner.nextLine();
				System.out.print("Nhập vào tên sinh viên: ");
				ten = scanner.nextLine();
				System.out.print("Nhập vào ngày sinh sinh viên: ");
				ngaySinh = scanner.nextLine(); // kiem tra tinh hop le dung` regex
				do {
					System.out.print("Nhập vào giới tính sinh viên(nAm/nỮ): ");
					gioiTinh = scanner.nextLine().trim().replaceAll("\\s+", " ");
					if(gioiTinh.toLowerCase().compareTo("nam") != 0 && gioiTinh.toLowerCase().compareTo("nữ") != 0)
						System.out.println("Vui lòng nhập đúng định dạng!");
				} while (gioiTinh.toLowerCase().compareTo("nam")!=0 && gioiTinh.toLowerCase().compareTo("nữ")!=0);
				Gender gt = null;
				if(gioiTinh.toLowerCase().compareTo("nam") == 0)
					gt = Gender.Nam;
				if(gioiTinh.toLowerCase().compareTo("nữ") == 0)
					gt = Gender.Nữ;
				TBLSinhVien newTBLSinhVien = new TBLSinhVien(studentId,hoDem,ten,convertStringToDate(ngaySinh), gt);
				listSinhVien.add(newTBLSinhVien);
				dataController.GhiTBLSinhVienVaoFile(TBLSinhVien_filename, newTBLSinhVien);
				break;

			case 2:
				break;
			default:
				break;
			}
		}while(choice!=0);
		scanner.close();
		
	}
}
