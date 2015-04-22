
public class Town {
	
	private Shop weapons, magic, armor, misc;
	private Arena arena;
	
	public Town(){
		
		weapons = new Shop("Weapons");
		magic = new Shop("Magic");
		armor = new Shop("Armor");
		misc = new Shop("Misc");
		arena = new Arena();
		
		weapons.generateShop("Weapons");
		magic.generateShop("Magic");
		armor.generateShop("Armor");
		misc.generateShop("Misc");
		//arena.initialize();
		
	}
	
	public void accessShop(Character player, Shop which){
		
		if(which.getType().equals("Magic")){
			magic.accessShop(player);
			}
		else if(which.getType().equals("Weapons")){
			weapons.accessShop(player);
			}
		else if(which.getType().equals("Armor")){
			armor.accessShop(player);
			}
		else if(which.getType().equals("Misc")){
			misc.accessShop(player);
			}
		
		}
	
	public void accessArena(Character player){
		arena.initialize(player);
		arena.setPlayer(player);
		arena.accessArena(player);
	}
	
	public boolean checkValid(String type){
		if(type.equalsIgnoreCase("Magic")
			|| type.equalsIgnoreCase("Weapons")
			|| type.equalsIgnoreCase("Armor")
			|| type.equalsIgnoreCase("Misc")
			|| type.equalsIgnoreCase("M")
			|| type.equalsIgnoreCase("W")
			|| type.equalsIgnoreCase("A")
			|| type.equalsIgnoreCase("I"))
			return true;
		else
			return false;
	}
	
	public Shop commandToShop(String s){
		if(s.equalsIgnoreCase("Magic") || s.equalsIgnoreCase("M"))
			return magic;
		if(s.equalsIgnoreCase("Weapons") || s.equalsIgnoreCase("W"))
			return weapons;
		if(s.equalsIgnoreCase("Armor") || s.equalsIgnoreCase("A"))
			return armor;
		if(s.equalsIgnoreCase("Misc") || s.equalsIgnoreCase("I"))
			return misc;
		else
			return null;
	}
	
	}
