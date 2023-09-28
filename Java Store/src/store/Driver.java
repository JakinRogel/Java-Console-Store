package store;

import java.io.IOException;
import java.util.Scanner;


/*  Driver class version 2.1 store operations
 */
//Class Driver
public class Driver {
	//main method virtual store with 6 products
	public static void main(String[] args) throws IOException {
		String input;
		char inputChar;
		//accepts input from the keyboard
		Scanner scnr = new Scanner(System.in);
		//instantiation of Inventory set to inv
		Inventory inv = new Inventory();
		//instantiation of Store class
		Store store = new Store();
		//instantiation of Cart class
		Cart cart = new Cart();

		//import objects from json file
		inv.readFromFile("in.json");
		//call Store openStore() pass Inventory and Cart objects
		store.openStore(inv, cart);
		
		do {
			System.out.print("Would you like to change the order of Items? \n Y for yes \n N for No");
			System.out.println();
			
			inputChar = scnr.next().charAt(0);
			
			if(inputChar!='y'&&inputChar!='Y'&&inputChar!='n'&&inputChar!='N') {
				System.out.println("Wrong input try again");
			}
			
		} while(inputChar!='y'&&inputChar!='Y'&&inputChar!='n'&&inputChar!='N');
		
		if(inputChar=='y'||inputChar=='Y') {
			do {
				System.out.println("Order is based on Name and Price \n Select A for Ascending \n Select D for Descending");
				inputChar=scnr.next().charAt(0);
				if(inputChar=='a'||inputChar=='A') {
					inv.orderAscending();
				} else if(inputChar=='d'||inputChar=='D') {
					inv.orderDescending();
				}
				
			} while(inputChar!='a'&&inputChar!='A'&&inputChar!='d'&&inputChar!='D');
		}
		
		inv.showInv();
		//do while
		do {
			//Print string
			System.out.println();
			System.out.println("Input the name of the item you want!");
			//set input to the next entered String from System in
			input = scnr.next();
			//instantiate of Product class with input passed through constructor
			Product inputObj = new Product(input);
			//call Store purchase() pass in Inventory object, Cart object, inputobj 
			store.purchase(inv, cart, inputObj);
			//prompt user
			System.out.println("Select Y to purchase Item \nSelect C to cancel an item \nSelect R to return all items \nSelect N to finish");
			//set char inputChar to the next System in char
			inputChar= scnr.next().charAt(0);
			//returns last item from cart
			if(inputChar=='c'||inputChar=='C') {
				//print String
				System.out.println("Type name of item you would like to cancel: ");
				//call cart showCart method
				cart.showCart();
				//input set to next string input through system in
				input = scnr.next();
				//instantiate of Product class with input passed through constructor
				Product inputObjCancel = new Product(input);
				//call store cancel() pass in cart getObject() pass inputObjCancel, inventory, and cart
				store.cancel(cart.getObject(inputObjCancel), inv, cart);
			}
			//if inputChar is r or R then...
			if(inputChar=='r'||inputChar=='R') {
				//call cart removeAll() pass inventory
				cart.removeAll(inv);
				//call cart showCart()
				cart.showCart();
			}
			//displays the inventory array
			inv.showInv();
		//loop while inputChar is y or Y
		} while(inputChar=='y'||inputChar=='Y'||inputChar=='c'||inputChar=='C'||inputChar=='r'||inputChar=='R');
		//displays the cart array contents
		cart.showCart();
		//prints to console cart total price
		System.out.println("Total $" + cart.getTotal(inv));
		//close scanner
		do {
			//print String
			System.out.println("Press Y to purchase or N to cancel purchase");
			//get char input from user set to inputChar 
			inputChar = scnr.next().charAt(0);
			//if inputChar is y or Y then...
			if(inputChar=='y'||inputChar=='Y') {
				//call cart empty()
				cart.empty();
				//print String
				System.out.println("Thank you for your purchase :) ");
				//call cart showCart()
				cart.showCart();
			//otherwise, if inputChar is n or N then...
			} else if(inputChar=='n'||inputChar=='N') {
				//call cart removeAll() pass inventory
				cart.removeAll(inv);
				//Print String
				System.out.println("Sorry we could not do business today :( ");
				//call cart showCart()
				cart.showCart();
			//otherwise print String
			} else {
				System.out.println("wrong input, try again");
			}
		//do while inputChar is not y & Y & n & N
		} while(inputChar!='y'&&inputChar!='Y'&&inputChar!='n'&&inputChar!='N');

		//close the scanner
		scnr.close();
	}
	
	

}
