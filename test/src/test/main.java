package test;

import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args) {
		List<HCN> listHCN = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			HCN a = new HCN();
			listHCN.add(a);
		}
		for(int i = 0; i < 3; i++) {
			
			System.out.println(listHCN.get(i).toString());
		}
		System.out.println("Hello");
	}
}