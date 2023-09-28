package store;
//Class Product
public class Product implements Comparable<Product>{
	//private String set to name
	private String name;
	//private String set to description
	private String description;
	//private double set to price
	private double price;
	//create default constructor
	public Product() {
		
	}
	//Product constructor
	public Product(String name, String description, double price) {
		//set passed name to this objects name
		this.name = name;
		//set passed description to this objects description
		this.description = description;
		//set passed price to this objects price
		this.price = price;
	}
	//Product constructor overloaded
	public Product(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	//custom equals method overloaded
	public boolean equals(Product obj) {
		//set passed object to product p for compiler
		Product p = (Product) obj;
		//if passed object name equals this objects name then...
		if(p.name.equalsIgnoreCase(this.name)) 
			//returns true
			return true;
		//otherwise
		else
			//returns false
			return false;

	}
	//custom toString method override 
	@Override
	public String toString() {
		
		//returns the object that called its name, description, and price
		return this.name + " " + this.description + " $" + this.price;
	}
	

	//public return String getName()
	public String getName() {
		//return String
		return name;
	}

	//public return String getDescription()
	public String getDescription() {
		//return String
		return description;
	}

	//public return double getPrice()
	public double getPrice() {
		//return double
		return price;
	}
	//public return void setName method pass String
	public void setName(String name) {
		//sets this objects name to passed name
		this.name = name;
	}
	//public return void setDescription method pass String
	public void setDescription(String description) {
		//sets this objects description to passed description
		this.description = description;
	}
	//public return void setPrice method pass double
	public void setPrice(double price) {
		//sets this objects price to passed price
		this.price = price;
	}
	public Integer getPriceInt() {
		// TODO Auto-generated method stub
		Integer priceInt = (int) price;
		return priceInt;
	}
	@Override
	public int compareTo(Product p) {
		// TODO Auto-generated method stub
		//declare int value set to result from comparing names of passed obj and this obj
		int value = this.getName().compareTo(p.getName()) - this.getPriceInt().compareTo(p.getPriceInt());
		//if int value is 0 then...
		if(value == 0) {
			//returns int value of comparision of objects
			return this.getName().compareTo(p.getName());
		}
		//otherwise
		else
			//returns value
			return value;
	}
	


	
	

}
