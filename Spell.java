
public class Spell {
	
	private int power, cost, value;
	private String name, element, flag;
	
	public Spell(int p, int c, int v, String n, String e){
		this.power = p;
		this.cost = c;
		this.value = v;
		this.name = n;
		this.element = e;
	}
	
	public Spell(int p, int c, int v, String n, String e, String f){
		this.power = p;
		this.cost = c;
		this.value = v;
		this.name = n;
		this.element = e;
		this.flag = f;
	}
	
	public int getPower(){
		return power;
	}
	
	public int getCost(){
		return cost;
	}

	public int getValue(){
		return value;
	}
	
	public String getName(){
		return name;
	}
	
	public String getElement(){
		return element;
	}
	
	public String getFlag(){
		return flag;
	}
	

}
