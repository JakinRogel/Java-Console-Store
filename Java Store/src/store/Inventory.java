package store;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
//Class Inventory
public class Inventory {
	//declare private arraylist of product objects named products
	private ArrayList<Product> products;
	//inventory constructor
	public Inventory() {
		//set products type product arraylist to new product arraylist
		setProducts(new ArrayList<Product>());
		
	}
	//public return void addProductToInv() pass Product object
	public void addProductToInv(Product obj) {
		//add Product object to products arraylist
		getProducts().add(obj);
	}
	//public return void removeItem() pass Product object
	public void removeItem(Product obj) {
		//for loop int i is zero through products array size increment i
		for(int i =0; i < getProducts().size(); i++) {
			//if statmenet checks to see if the passed object equals an object in the products array
			if(obj.equals(getProducts().get(i)))
				//remove object from products array at index i 
				getProducts().remove(i);
		}
	}
	
	//used to get how much of each unique object class is in the products array
	//public return int pass product object
	public int invProductQuantity(Product obj) {
		
		int count = 0;
		//for each through products array
		for(Product p : getProducts()) {
			//checks to see if passed object has the same class as products array objects
			if(p.getClass() == obj.getClass()) {
				//increment count
				count++;
				
			}
		}
		//return the int count
		return count;
	}
	//gets the size of products array
	public int invQuantity() {
		//return products array size
		return products.size();
	}
	//displays the current objects in inventory array 
	public void showInv() {
		//Print String
		System.out.println("INVENTORY:");
		//for each through products array
		for(Product p : products) {
			//print to console objects in products array with overriden toString()
			System.out.println(p.toString());
		}
	}
	//checks to see if an object is in the products array
	public boolean checkAvailability(Product obj) {
		//for each Product object in products array
		for(Product p : products) {
			//if object in products array equals object passed then...
			if(p.equals(obj)) {
		//returns true
		return true;
		} 
		}
		//returns false
		return false;
	}
	//returns the corresponding object from products array
	public Product getObject(Product obj) {
		// TODO Auto-generated method stub
		for(Product p : products) {
			//if product object equals passed object then...
			if(p.equals(obj)) {
				//return product object p
				return p;
			}
		}
		//returns null
		return null;
	}
	//public return ArrayList of Product getProducts method
	public ArrayList<Product> getProducts() {
		//returns products objects in arraylist
		return products;
	}
	//public return void setProducts method pass arraylist of product
	public void setProducts(ArrayList<Product> products) {
		//set object product arraylist to passed product arraylist
		this.products = products;
	}
	//public return arraylist of Product readFromFile method pass String
	public ArrayList<Product> readFromFile(String filename) {
		//try catch statment
		try {
				//Instantiate objectMapper from ObjectMapper class
				ObjectMapper objectMapper = new ObjectMapper();
				//Instantiate data from DataClass class, call objectMapper readValue() pass entire file relay to DataClass
				DataClass data = objectMapper.readValue(Files.readString(Path.of(filename)), DataClass.class);
				//add all data with Health class to products arraylist
				products.addAll(data.getHealth());
				//add all data with Armour class to products arraylist
				products.addAll(data.getArmour());
				//add all data with Weapons class to products arraylist
				products.addAll(data.getWeapons());
		//catch an IOException set to e
		} catch (IOException e) {
			//call IOException printStackTrack()
			e.printStackTrace();
		}
		//return products arraylist
		return products;
	}
	
	public void orderAscending() {
		int count = products.size();
		
		List<Product> list = new ArrayList<Product>();
		
		for(Product p : products) {
			list.add(p);
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < count; ++i) {
			products.remove(0);
			products.add(list.get(i));
		}

}

public void orderDescending() {
	int count = products.size();
	
	List<Product> list = new ArrayList<Product>();
	
	for(Product p : products) {
		list.add(p);
	}
	
	Collections.reverse(list);
	
	for(int i = 0; i < count; ++i) {
		products.remove(0);
		products.add(list.get(i));
	}

}
	
	

}
