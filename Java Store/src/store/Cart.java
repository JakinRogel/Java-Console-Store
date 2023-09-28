package store;

import java.util.ArrayList;

//Class Cart
public class Cart {
	//private double set to total
	private double total;
	//instatiate Arraylist of Product objects set to cart
	static ArrayList<Product> cart = new ArrayList<Product>();
	//public return void add() params int, int, Object
	
	//public return void remove() pass int, int, object
	public void remove(Inventory inv, Product obj) {
		//for loop int i through cart size...
		for(int i =0; i < cart.size(); i++) {
			//if passed obj equals object in cart then...
			if(obj.equals(cart.get(i)))
				//remove obj from cart at index i
				cart.remove(i);
		}

	}

	
	
	//publi return void removeAll() pass inventory
	public void removeAll(Inventory inv) {
		//set int count to 0
		int count = 0;
		//for loop int i through cart size...
		for(int i = 0; i < cart.size(); i++) {
			//call inv addProductToInv() pass cart object at index i
			inv.addProductToInv(cart.get(i));
			//increment count
			count++;
		}
		//for loop int x through count...
		for(int x = 0; x < count; ++x) {
			//cart remove () at index 0
			cart.remove(0);
		}
	}
	//public double getTotal() pass object
	public double getTotal(Inventory inv) {
		//for loop through cart.size()
		for(int i = 0; i < cart.size(); i++) {
			//double total += call cart.get(i).getPrice() return price
			total += cart.get(i).getPrice();
		}
		//return the double total
		return total;
	}

	//public return void add() pass object
	public void addProduct(Product obj, Inventory inv) {
		//if the object desired is available in the inventory then...
		if(inv.checkAvailability(obj)) {
			//add to the cart array the object returned from the getObject() pass in desired object
			cart.add(inv.getObject(obj));
			//print to console object added
			System.out.println("Item added to cart------->  " + inv.getObject(obj));
			//remove object from the inventory array 
			inv.removeItem(inv.getObject(obj));
		}
		//otherwise...
		else
			//print item not found and object passed 
			System.out.println("Item not found------->  " + obj);
	}
	//public return void showCart()
	public void showCart() {
		//print String
		System.out.println("CART:");
		//for each Product object in cart arraylist
		for(Product p : cart) {
			//print object toString()
				System.out.println(p.toString());
		}
	}
	//public return Product object getObject() pass product obj
	public Product getObject(Product obj) {
		//for each Product object in cart arraylist
		for(Product p : cart) {
			//if passed obj matches object in cart then...
			if(p.equals(obj)) {
				//return object from cart
				return p;
			}
		}
		//returns null
		return null;
	}
	//public return void empty()
	public void empty() {
		//set int count to 0
		int count = 0;
		//for loop int i through cart size...
		for(int i = 0; i < cart.size(); i++) {
			//increment count
			count++;
		}
		//for loop int x through count...
		for(int x = 0; x < count; ++x) {
			//call cart remove() at index 0
			cart.remove(0);
		}
	}


}
