package store;
//Armour class subclass of Product implements Comparable of Product objects
public class Armour extends Product implements Comparable<Product> {
	//public Armour default constructor
	public Armour() {
		
	}
	//Armour Constructor
	public Armour(String name, String description, double price) {
		//pass parameters to super class
		super(name, description, price);
	}
	
//	@Override
//	//public return int compareTo() pass product object
//	public int compareTo(Product p) {
//		// TODO Auto-generated method stub
//		//declare int value set to result from comparing names of passed obj and this obj
//		int value = this.getName().compareTo(p.getName());
//		//if int value is 0 then...
//		if(value == 0) {
//			//returns int value of comparision of objects
//			return this.getName().compareTo(p.getName());
//		}
//		//otherwise
//		else
//			//returns value
//			return value;
//
//	}

}


