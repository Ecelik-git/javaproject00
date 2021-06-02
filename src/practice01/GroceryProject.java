package practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryProject {
	
	static List<String> groceriesList= new ArrayList<>();
	static List<Double> pricesList= new ArrayList<>();
	static List<String> basketGrocery= new ArrayList<>();
	static List<Double> basketWeight= new ArrayList<>();
	static List<Double> basketTotalPrice= new ArrayList<>();

	public static void main(String[] args) {
/*
 * Write a basic green grocery shopping program
 * 1. Step: Ask to the user to choose product from productList 
 * and 
 * ask how many kilograms does he/she likes to buy
 
			Num 	Grocery 	Price
			====	 =======	 =========
			00	 Tomatoes   	 $ 2.10 
			01	 Potatoes   	 $ 3.20 
			02	 Pepper     	 $ 1.50 
			03	 Onion      	 $ 2.30 
			04	 Carrot     	 $ 3.10 
			05	 Apple      	 $ 1.20 
			06	 Banana     	 $ 1.90 
			07	 Strawberry 	 $ 6.10 
			08	 Melon      	 $ 4.30 
			09	 Grape      	 $ 2.70 
			10	 Lemon      	 $ 0.50
 
 Please select by number at the beginning
 
 * 2. Step : Ask if he wants to buy any other product or not-- If he doesn't want 
 * show total amount if he wants make him choose any product from the beginning
 
 	Repeat this operation until she/he wants to finish the shopping.
 * 
 * 3. Step: When customer chooses any product and the price of the product will be added 
 * to the total amount.
 * 
 * 4. Step : Show the total amount when the shopping finishes.
 * 
 *  Create two methods named customerChoice() and cash()  
 */
		Scanner scan = new Scanner(System.in);
		
		String[] groceriesArray= {"Tomatoes","Potatoes","Pepper","Onion","Carrot","Apple","Banana",
				"Strawberry","Melon","Grape","Lemon"};
		for(String w: groceriesArray) {
			groceriesList.add(w);
		}
		
		double[] priceArray = {2.10,3.20,1.50,2.30,3.10,1.20,1.90,6.10,4.30,2.70,0.50};
		for(Double w: priceArray) {
			pricesList.add(w);
		}
		
		String continueBuying="y";
		
		do {
			
			printGroceryList();
			
			System.out.println("\nWhich grocery do you want?"+
			"\nPlease select by entering the number at the beginning!");
			System.out.println("Enter your selection");
			
			int groceryNumber=scan.nextInt();
			
			System.out.println("How many kilograms, do you want?"
					+ "\nPlease enter the weight");
			double weight = scan.nextDouble();
			
			//Current basket
			printBasket(groceryNumber,weight);
			
			
			System.out.println("Do you want to continue to shop"
					+ "\nY: Yes or N: No => Go to Cash");
			continueBuying=scan.next();
			
			addBasket(groceryNumber,weight);
			
		} while (continueBuying.equalsIgnoreCase("y"));
		
		printBasketAndCash();
		
	}//main method

	private static void printBasketAndCash() {
		int totalItem=0;
		double totalWeight=0;
		double totalPrice=0;
		System.out.println("************************************************");
		System.out.println("______________Basket and Cash___________________");
		System.out.printf("%-10s \t%s \t%s %n","Grocery","Weight","Total");
		for (int i = 0; i < basketGrocery.size(); i++) {
			System.out.printf("%-10s \t%-3.1f \t $%-5.2f %n",basketGrocery.get(i),basketWeight.get(i),basketTotalPrice.get(i));
			totalItem++;
			totalWeight+=basketWeight.get(i);
			totalPrice+=basketTotalPrice.get(i);
		}
		System.out.printf("%d groceries %.2f kg $%.2f %n",totalItem,totalWeight,totalPrice);
		System.out.println();
		System.out.printf("You will pay $%.2f %n",totalPrice);
		
		System.out.println("************************************************");
	}

	private static void addBasket(int groceryNumber, double weight) {
		basketGrocery.add(groceriesList.get(groceryNumber));
		basketWeight.add(weight);
		basketTotalPrice.add(pricesList.get(groceryNumber)*weight);
	}

	private static void printBasket(int groceryNumber, double weight) {
		System.out.println("_________________Your current basket_________________");
		System.out.printf("%s \t%s \t%s \t%s %n","Num","Grocery","Weight","Total");
		System.out.printf("%02d \t%-10s \t$%.2f %n",
				groceryNumber,groceriesList.get(groceryNumber),weight,pricesList.get(groceryNumber)*weight);
		System.out.println("------------------------------------------------------");
	}

	private static void printGroceryList() {
		System.out.println("Num \t Grocery \t Price");
		System.out.println("=== \t ======= \t ======");
		for(int i=0; i<groceriesList.size();i++) {
			//System.out.println(i+" "+groceriesList.get(i)+" "+pricesList.get(i));
			System.out.printf("%02d \t %-10s \t %5.2f%n",i,groceriesList.get(i),pricesList.get(i));
		}
	}

	

}
