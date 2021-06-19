package test;

import java.util.ArrayList;
import java.util.List;

public class main {
	
	public static int theTich(HCN hcn) {
		return hcn.getCao()*hcn.getDai()*hcn.getRong();
	}
	
	public static void sap(List<HCN> listHCN) {
		for(int i = 0; i < listHCN.size()-1; i++) {
			for(int j = i+1; j < listHCN.size(); j++) {
				if(theTich(listHCN.get(i)) > theTich(listHCN.get(j))) {
					HCN tmp = listHCN.get(i);
					listHCN.set(i,listHCN.get(j));
					listHCN.set(j,tmp);
				}
			}
		}
	}
	
	public static void xoa(List<HCN> listHCN) {
		for(int i = 0; i < listHCN.size(); i++) {
			if(listHCN.get(i).getCao()<10)
				listHCN.remove(i);
		}
	}
	
	public static void main(String[] args) {
		List<HCN> listHCN = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			HCN a = new HCN();
			listHCN.add(a);
		}
		
		System.out.println("\nDS HCN: ");
		for(int i = 0; i < listHCN.size(); i++) {
			System.out.println(listHCN.get(i).toString());
		}
		
		sap(listHCN);
		xoa(listHCN);
		
		System.out.println("\nDS HCN: ");
		for(int i = 0; i < listHCN.size(); i++) {
			System.out.println(listHCN.get(i).toString() + ", the tich: " +theTich(listHCN.get(i)));
		}
		
	}
}