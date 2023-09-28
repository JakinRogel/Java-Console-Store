package store;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
//Public class DataClass
public class DataClass {
	//private List of health objects named health
	private List<Health> health;
	//private List of Armour objects named armour
	private List<Armour> armour;
	//private List of Weapons objects named weapons
	private List<Weapons> weapons;
	//default DataClass constructor
	public DataClass() {
		
	}
	//Json getter of class Health
	@JsonGetter("Health")
	//public return list of health objects getHealth()
	public List<Health> getHealth() {
		//returns health list
		return health;
	}
	//Json setter of class Health
	@JsonSetter("Health")
	//public return void setHealth() pass list of Health objects
	public void setHealth(List<Health> health) {
		//sets this health list to passed health list
		this.health = health;
	}
	//Json getter of class Armour
	@JsonGetter("Armour")
	//public return list of armour objects getArmour()
	public List<Armour> getArmour() {
		//returns armour list
		return armour;
	}
	//Json setter of class Armour
	@JsonSetter("Armour")
	//public return void setArmour() pass list of Armour objects
	public void setArmour(List<Armour> armour) {
		//sets this armour list to passed armour list
		this.armour = armour;
	}
	//Json getter of class Weapons
	@JsonGetter("Weapons")
	//public return list of Weapons objects getWeapons()
	public List<Weapons> getWeapons() {
		//returns weapons list
		return weapons;
	}
	//Json setter of class Weapons
	@JsonSetter("Weapons")
	//public return void setWeapons() pass list of Weapons objects
	public void setWeapons(List<Weapons> weapons) {
		//sets this weapons list to passed weapons list
		this.weapons = weapons;
	}

}
