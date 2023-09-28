package store;


//Class Store
public class Store {

	//declare boolean set to storeOpen set to false
	boolean storeOpen = false;
	//declare char set to input

	//public return void purchase() pass int, int, object, object
	public void purchase(Inventory inv, Cart cart, Product obj) {
		//call cart addProduct() pass object and inventory
		cart.addProduct(obj, inv);
	}
	//public return void cancel() pass int, int, object, object
	public void cancel(Product obj, Inventory inv, Cart cart) {
		//call cart remove() pass inventory and object
		cart.remove(inv, obj);
		//call inv addProductToInv() pass obj
		inv.addProductToInv(obj);
	}
	//public return void openStore()
	public void openStore(Inventory inv, Cart cart) {
			//storeOpen equals true
			storeOpen = true;
			//print String
			System.out.println("The Store is open!");
			//print String
			System.out.println("Welcome to the Conquest Outpost!");
			//print String
			System.out.println("Check out our inventory:");
			//call inv showInv()
			inv.showInv();

	}
	//public return void closeStore()
	public void closeStore() {
			//storeOpen equals false
			storeOpen = false;
			//print String
			System.out.println("The Store is closed!");
	}
	
}


