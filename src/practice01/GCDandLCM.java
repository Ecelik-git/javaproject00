package practice01;

import java.util.Scanner;

public class GCDandLCM {
	// Take 2 integers from user and find GCD (Greatest Common Divisor)
	//and LCM (Least Common Multiplier)
	// Hint: Take the greater number is bounded as maximum 50.000
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter 2 numbers space separated");
		gcd(scan.nextInt(), scan.nextInt());
		System.out.println();
		lcm(scan.nextInt(), scan.nextInt());
		
		scan.close();
	}
	public static void gcd(int a, int b) {
		int max=1, i;
		if(a>0 && b>0) {
			if(a>b) {
				for (i=1; i<=b; i++) {
					if(a%i==0 && b%i==0) {
						max=i;
					}
				}
			}else {
				for (i=1; i<=a; i++) {
					if(a%i==0 && b%i==0) {
						max=i;
					}
				}
			}
		}
		System.out.println(max);
	}
	
	public static void lcm(int a, int b) {
		int min=1, i;
		if(a>0 && b>0) {
			if(a>b) {
				for(i=b; i>0; i--) {
					if(a%i==0 && b%i==0) {
						min = i;
					}
				}
			}
		}
		System.out.println(min);
	}

}
