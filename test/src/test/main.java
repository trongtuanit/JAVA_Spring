package test;

import java.util.Scanner;

public class main {

	
	public static int luyThua(int n) {
		if(n>2)
			return n*luyThua(n-1);
		return n;
	}
	
	public static float calc(float x, int n) {
		float sum = x;
		int dau = 1;
		float tu = x;
		float mau;
		for(int i = 1; i < n; i++) {
			dau*=-1;
			tu*=(x*x);
			mau=luyThua(2*i+1);
			sum+=tu/mau*dau;
		}
		return sum;
		
	}
	
	
	public static boolean isPrime(int a) {
	    for (int i = 2; i <= Math.sqrt(a); i++) {
	        if (a % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static int sumOfPrime(int n) {
		int sum = 0;
		for(int i = 0; i <= n; i++) 
			if(isPrime(i))
				sum+=i;
		return sum;
	}
	
    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	int choose = scan.nextInt();
    	
    	switch ( choose ) {
        case  1:
        	System.out.println("nhap so n");
            int n = scan.nextInt();
            System.out.println("tong snt tu 1-> n: " + sumOfPrime(n));
            break;
        case  2:
        	System.out.println("nhap so n");
            n = scan.nextInt();
            System.out.println("nhap so n");
            float x = scan.nextFloat();
            System.out.println("sin(x): " + calc(x, n));
            break;
        default:
            System.out.println("khong co lua chon nay");
    }
    
    	
    	
		
    }
}
