package test.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import test.models.TBLSinhVien.Gender;
import test.models.TBLSinhVien;

public class DataController {

	private  FileWriter fileWriter;
	
	private BufferedWriter bufferedWriter;
	
	private PrintWriter printWriter;
	
	private Scanner scanner;
	
	
	private Date convertStringToDate(String dateString) throws Exception {
		final DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
		Date date =  df1.parse(dateString);
		
        return date;
	}
	
	public void OpenFileToWrite(String filename) {
		try {
			fileWriter = new FileWriter(filename, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void CloseFileAfterWrite() {
		try {
			printWriter.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void OpenFileToRead(String filename) {
		try {
			File file = new File(filename);
			if(!file.exists()) {
				file.createNewFile();
			}
			scanner = new Scanner(Paths.get(filename));
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void CloseFileAfterRead() {
		try {
			scanner.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void GhiTBLSinhVienVaoFile(String filename, TBLSinhVien sv) throws ParseException {
		OpenFileToWrite(filename);
		
		
	
		LocalDate localDate = sv.getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Integer year  = localDate.getYear();
		Integer month = localDate.getMonthValue();
		Integer day   = localDate.getDayOfMonth();
		String date = day.toString() + "-" + month.toString() + "-" + year.toString(); 
		printWriter.println(sv.getMaSV()+"|"+sv.getHoDem()+"|"+sv.getTen()
							+"|"+date+"|"+sv.getGioiTinh());
		
		CloseFileAfterWrite();
	}
	
	private TBLSinhVien TaoTBLSinhVienTuData(String data) throws Exception {
        String[] datas = data.split("\\|");
        Gender a = null;
        if(datas[4].compareTo("Nam")==0)
    		a = Gender.Nam;
        else if(datas[4].compareTo("Nữ")==0)
    		a = Gender.Nữ;
//        TBLSinhVien sv = new TBLSinhVien();
        TBLSinhVien sv = new TBLSinhVien(Long.getLong(datas[0]), datas[1], datas[2], convertStringToDate(datas[3]), a);
        return sv;
    }  

	
	public ArrayList<TBLSinhVien> DocTBLSinhVienTuFile(String filename) throws Exception {
		OpenFileToRead(filename);
		
		ArrayList<TBLSinhVien> DSTBLSinhVien = new ArrayList<>();
		while(scanner.hasNext()) {
			String data = scanner.nextLine();
			TBLSinhVien sv = TaoTBLSinhVienTuData(data);
			DSTBLSinhVien.add(sv);
		}
		
		CloseFileAfterRead();
		
		return DSTBLSinhVien;
	}
	
	public void UpdateFileData_TBLSinhVien(ArrayList<TBLSinhVien> listTBLSinhVien, String filename) {
		File file = new File(filename);
		if(file.exists()) {
			file.delete();
		}
		OpenFileToWrite(filename);
		for(TBLSinhVien sv : listTBLSinhVien) {
			printWriter.println(sv.getMaSV()+"|"+sv.getHoDem()+"|"+sv.getTen()
			+"|"+sv.getNgaySinh()+"|"+sv.getGioiTinh());
		}
		CloseFileAfterWrite();
	}
	
	
}
