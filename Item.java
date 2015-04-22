
public class Item {
	
	private int power, defense, value, healing, regain, weight, ammo = 0, maxAmmo = 0;
	private String name, flag, type;
	
	//Basic Items
	
	public Item(int p, int d, int v, int h, int r, int w, String n){
		this.power = p;
		this.defense = d;
		this.value = v;
		this.healing = h;
		this.regain = r;
		this.weight = w;
		this.type = null;
		this.flag = null;
		this.name = n;
	}
	
	//Equips
	
	public Item(int p, int d, int v, int h, int r, int w,String t, String n){
		this.power = p;
		this.defense = d;
		this.value = v;
		this.healing = h;
		this.regain = r;
		this.weight = w;
		this.type = t;
		this.flag = null;
		this.name = n;
	}
	
	//Equips with flags
	
	public Item(int p, int d, int v, int h, int r, int w,String t, String f, String n){
		this.power = p;
		this.defense = d;
		this.value = v;
		this.healing = h;
		this.regain = r;
		this.weight = w;
		this.type = t;
		this.flag = f;
		this.name = n;
	}
	
	//Guns
	
public Item(int p, int d, int v, int h, int r, int w, int a,String t, String n){
		
		this.power = p;
		this.defense = d;
		this.value = v;
		this.healing = h;
		this.regain = r;
		this.weight = w;
		this.ammo = a;
		this.type = t;
		this.flag = null;
		this.name = n;
		
		this.maxAmmo = ammo;
	}

	//Guns with flags
	
	public Item(int p, int d, int v, int h, int r, int w, int a,String t, String f, String n){
		
		this.power = p;
		this.defense = d;
		this.value = v;
		this.healing = h;
		this.regain = r;
		this.weight = w;
		this.ammo = a;
		this.type = t;
		this.flag = f;
		this.name = n;
		
		this.maxAmmo = ammo;
	}
	
	public int getRegain(){
		return regain;
	}
	
	public int getPower(){
		return power;
	}
	
	public int getDefense(){
		return defense;
	}
	
	public int getValue(){
		return value;
	}
	
	public int getHealing(){
		return healing;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public int getAmmo(){
		return ammo;
	}
	
	public int getMaxAmmo(){
		return maxAmmo;
	}
	
	public String getType(){
		return type;
	}
	
	public String getFlag(){
		return flag;
	}
	
	public String getName(){
		return name;
	}
	
	public void reload(){
		this.ammo = this.maxAmmo;
	}
	
	public void fireRound(){
		--(this.ammo);
	}

}
