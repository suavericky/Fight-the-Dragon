import java.util.*;

public class Shop {
	
	private String type;
	private ArrayList<Item> inventory, allWeapons, allArmor, allMisc;
	private ArrayList<Spell> spells, allMagic;
	
	public Shop(){
		//default
	}
	
	public Shop(String t){
		this.type = t;
		
		this.inventory = new ArrayList<Item>();
		this.spells = new ArrayList<Spell>();
		
		this.allWeapons = new ArrayList<Item>();
		this.allMagic = new ArrayList<Spell>();
		this.allArmor = new ArrayList<Item>();
		this.allMisc = new ArrayList<Item>();
	}
	
	public String getType(){
		return type;
	}
	
	public ArrayList<Item> getInventory(){
		return inventory;
	}
	
	public ArrayList<Spell> getSpells(){
		return spells;
	}
	
	public Item getFromInventory(String name){
		
		Item theItem = null;
		
		for(int i = 0; i < this.inventory.size(); ++i){
			if(this.inventory.get(i).getName().equals(name)){
				theItem = this.getInventory().get(i);
				this.inventory.remove(i);
			}
		}
		return theItem;
	
	}
	
	public void setType(String s){
		this.type = s;
	}
	
	
	public void initializeItems(){
		
		//private int power, defense, value, healing, regain;
		//private String name
		
		String m = "melee";
		String r = "ranged";
		String a = "armor";
		
		Item is = new Item(30,0,100,0,0,4,m,"Iron Sword");
		Item ss = new Item(40,0,200,0,0,6,m,"Steel Sword");
		Item ts = new Item(50,0,350,0,0,8,m,"Titanium Sword");
		Item ps = new Item(60,0,700,0,0,10,m,"Palladium Sword");
		
		Item sear = new Item(35,0,350,0,0,6,m,"fire","Searing Blade");
		Item cryo = new Item(35,0,350,0,0,6,m,"ice","Cryonic Blade");
		
		Item gcbk = new Item(65,0,1500,0,0,8,m,"crit+","Grass Cutter Blade, Kusanagi");
		Item sosg = new Item(90,0,1500,0,0,10,m,"Sword of St. George");
		Item tbo = new Item(120,0,2500,0,0,25,m,"The Big One");
		
		Item ws = new Item(1,0,100,0,0,1,m,"magic+","Wooden Staff");
		Item cs = new Item(5,0,500,0,0,2,m,"magic++","Crystalline Staff");
		Item mas = new Item(30,0,350,0,0,3,m,"magic+","Mageblade");
		Item xmas = new Item(50,0,700,0,0,3,m,"magic+","Oni Mageblade");
		
		Item jsod = new Item(15,0,1500,0,0,2,m,"magic+++","Jupiter, Staff of Dominion");
		
		Item wn = new Item(30,0,100,0,0,2,m,"swiftness","Wooden Nunchaku");
		Item in = new Item(40,0,350,0,0,4,m,"swiftness","Iron Nunchaku");
		Item sn = new Item(50,0,700,0,0,6,m,"swiftness","Steel Nunchaku");
		
		Item slhn = new Item(60,0,1500,0,0,8,m,"swiftness","Shen Long, Holy Nunchaku");
		
		Item il = new Item(40,0,150,0,0,8,m,"Iron Lance");
		Item sl = new Item(50,0,300,0,0,10,m,"Steel Lance");
		Item tl = new Item(60,0,550,0,0,12,m,"Titanium Lance");
		Item pl = new Item(70,0,800,0,0,14,m,"Palladium Lance");
		
		Item gsos = new Item(80,0,1500,0,0,14,m,"lightning","Gungnir, Spear of Storms");
		
		Item ih = new Item(30,0,200,0,0,2,6,r,"Iron Handgun");
		Item sh = new Item(40,0,400,0,0,3,6,r,"Steel Handgun");
		Item th = new Item(50,0,600,0,0,4,6,r,"Titanium Handgun");
		Item ph = new Item(60,0,800,0,0,5,6,r,"Palladium Handgun");
		
		Item ir = new Item(50,0,350,0,0,6,12,r,"Iron Rifle");
		Item sr = new Item(60,0,500,0,0,8,12,r,"Steel Rifle");
		Item tr = new Item(70,0,750,0,0,10,12,r,"Titanium Rifle");
		Item pr = new Item(80,0,1100,0,0,12,12,r,"Palladium Rifle");
		
		Item twoh = new Item(45,0,800,0,0,6,12,r,"swiftness","Dual .44's");
		Item mtpm = new Item(100,0,1500,0,0,18,50,r,"automatic","Machina, the Peacemaker");
		Item ziz = new Item(200,0,2000,0,0,12,1,r,"crit+","Ziz, the God-Sniper");
		
		
		allWeapons.add(is);
		allWeapons.add(ss);
		allWeapons.add(ts);
		allWeapons.add(ps);
		allWeapons.add(sear);
		allWeapons.add(cryo);
		allWeapons.add(gcbk);
		allWeapons.add(sosg);
		allWeapons.add(tbo);
		allWeapons.add(ws);
		allWeapons.add(cs);
		allWeapons.add(mas);
		allWeapons.add(xmas);
		allWeapons.add(jsod);
		allWeapons.add(wn);
		allWeapons.add(in);
		allWeapons.add(sn);
		allWeapons.add(slhn);
		allWeapons.add(il);
		allWeapons.add(sl);
		allWeapons.add(tl);
		allWeapons.add(pl);
		allWeapons.add(gsos);
		
		allWeapons.add(ih);
		allWeapons.add(sh);
		allWeapons.add(th);
		allWeapons.add(ph);
		allWeapons.add(ir);
		allWeapons.add(sr);
		allWeapons.add(tr);
		allWeapons.add(pr);
		allWeapons.add(twoh);
		allWeapons.add(mtpm);
		allWeapons.add(ziz);
		
		
		Item ia = new Item(0,30,100,0,0,6,a,"Iron Armor");
		Item sa = new Item(0,40,200,0,0,8,a,"Steel Armor");
		Item ta = new Item(0,50,350,0,0,10,a,"Titanium Armor");
		Item pa = new Item(0,60,700,0,0,12,a,"Palladium Armor");
		
		Item aowk = new Item(0,80,1000,0,0,12,a,"Armor of the Warrior King");
		
		Item ea = new Item(0,30,200,0,0,6,a,"resist+","Enchanted Armor");
		Item xea = new Item(0,50,750,0,0,10,a,"resist+","Inquisitor's Armor");
		
		Item hia = new Item(0,45,150,0,0,10,a,"heavy","Heavy Iron Armor");
		Item hpa = new Item(0,90,750,0,0,18,a,"heavy","Heavy Palladium Armor");
		
		Item jha = new Item(0,150,1500,0,0,25,a,"heavy","Juggernaught's Armor");
		
		Item nrp = new Item(0,1,500,0,0,1,a,"weightless","Nimbus Runner's Pants");
		
		allArmor.add(ia);
		allArmor.add(sa);
		allArmor.add(ta);
		allArmor.add(pa);
		allArmor.add(aowk);
		allArmor.add(hia);
		allArmor.add(hpa);
		allArmor.add(jha);
		allArmor.add(ea);
		allArmor.add(xea);
		allArmor.add(nrp);
		
		
		Item potion = new Item(0,0,10,20,0,0,"Potion");
		Item elixir = new Item(0,0,50,50,0,0,"Elixir");
		
		Item mc = new Item(0,0,10,0,20,0,"Mana Crystal");
		Item gmc = new Item(0,0,50,0,50,0,"Grand Mana Crystal");
		
		allMisc.add(potion);
		allMisc.add(elixir);
		allMisc.add(mc);
		allMisc.add(gmc);
		
		//private int power, cost, value;
		//private String name, element;
		
		Spell fire = new Spell(25,8,100,"Fireball","fire");
		Spell xfire = new Spell(50,16,500,"Fireblast","fire");
		Spell xxfire = new Spell(100,32,1000,"Second Sun","fire");
		Spell ice = new Spell(20,4,100,"Frost Arrow","ice");
		Spell xice = new Spell(40,8,500,"Frost Lance","ice");
		Spell xxice = new Spell(80,16,1000,"Frost Legion","ice");
		Spell lightning = new Spell(35,12,200,"Lightning Bolt","lightning");
		Spell xlightning = new Spell(75,24,750,"Lightning Storm","lightning");
		Spell xxlightning = new Spell(160,48,1200,"Cataclysm","lightning");
		Spell cb = new Spell(22,6,100,"Clay Bomb","earth");
		Spell xcb = new Spell(44,12,500,"Giant Clay Bomb","earth");
		Spell xxcb = new Spell(88,26,1000,"Meteor","earth");
		Spell ugb = new Spell(200,60,1500,"Ultimate God Blast","none");
		
		Spell poison = new Spell(0,12,500,"Blight","none","poison");
		Spell sleep = new Spell(0,28,1000,"Slumber","none","sleep");
		
		Spell heal = new Spell(20,4,100,"Heal","none","heal");
		Spell xheal = new Spell(50,12,500,"Great Heal","none","heal");
		Spell xxheal = new Spell(100,36,1000,"Full Heal","none","heal");
		
		
		
		allMagic.add(fire);
		allMagic.add(xfire);
		allMagic.add(xxfire);
		allMagic.add(ice);
		allMagic.add(xice);
		allMagic.add(xxice);
		allMagic.add(lightning);
		allMagic.add(xlightning);
		allMagic.add(xxlightning);
		allMagic.add(cb);
		allMagic.add(xcb);
		allMagic.add(xxcb);
		allMagic.add(ugb);
		allMagic.add(poison);
		allMagic.add(sleep);
		allMagic.add(heal);
		allMagic.add(xheal);
		allMagic.add(xxheal);
		
		//System.out.println("Items initialized");
		
	}
	
	public void generateShop(String type){
		
		this.initializeItems();
		
		this.setType(type);
		Item itemToAdd;
		Spell spellToAdd;
		
		if(type.equals("Weapons")){
			for(int i = 0; i < allWeapons.size(); ++i){
				itemToAdd = allWeapons.get(i);
				this.inventory.add(itemToAdd);
			}
		}
		
		if(type.equals("Magic")){
			for(int i = 0; i < allMagic.size(); ++i){
				spellToAdd = allMagic.get(i);
				this.spells.add(spellToAdd);
			}
		}
		
		if(type.equals("Armor")){
			for(int i = 0; i < allArmor.size(); ++i){
				itemToAdd = allArmor.get(i);
				this.inventory.add(itemToAdd);
			}
		}
		
		if(type.equals("Misc")){
			for(int i = 0; i < allMisc.size(); ++i){
				itemToAdd = allMisc.get(i);
				this.inventory.add(itemToAdd);
			}
		}
		//System.out.println("Shop Generated.");
	}
	
	public Item findItemWithName(String name){
		Item found = null;
		
		for(Item temp : this.inventory){
			if(temp.getName().equals(name))
				found = temp;
		}
		
		return found;
	}
	
	public Spell findSpellWithName(String name){
		Spell found = null;
		
		for(Spell temp : this.spells){
			if(temp.getName().equals(name))
				found = temp;
		}
		
		return found;
	}
	
	public void accessShop(Character customer){
		
		Scanner input = new Scanner(System.in);
		String command = "";
		
		System.out.println("\nWelcome to my "+this.getType()+" Shop!");
		if(this.getType().equals("Magic")){
			System.out.println("I currently have these spells in stock!");
			for(Spell temp : spells){
				System.out.println(" o "+temp.getName()+" "+temp.getValue());
			}
		}
		
		else{
			System.out.println("I currently have these items in stock!");
			for(Item temp : inventory){
				System.out.println(" o "+temp.getName()+" "+temp.getValue());
			}
		}
		
		System.out.println("\nHow may I help you?");
		
		while(!command.equalsIgnoreCase("Leave") || !command.equalsIgnoreCase("L")){
		System.out.println("[B]uy  [S]ell  [A]sk  [L]eave");
		System.out.println("Current Funds: "+customer.getWallet());
		System.out.println("Capacity: "+customer.getCapacity()+" / "+customer.getMaxCapacity());
		command = input.nextLine();
		
		if(command.equalsIgnoreCase("Buy") || command.equalsIgnoreCase("B")){
			System.out.println("What would you like to buy?");
			command = input.nextLine();
			if(this.findItemWithName(command) != null || this.findSpellWithName(command) != null)
				if(this.findItemWithName(command) != null){
					
					boolean misc = false;
					if(this.type.equals("Misc"))
						misc = true;
					
					Item theItem = this.findItemWithName(command);
					
					if(misc){
						System.out.println("How many?");
						int q = input.nextInt();
						for(int i = 0; i < q; ++i)
							customer.buy(theItem);
					}
					else if(customer.buy(theItem)){
						if(!this.type.equals("Misc"))
						this.inventory.remove(theItem);
					}
				}
				else if(this.findSpellWithName(command) != null){
					Spell theSpell = this.findSpellWithName(command);
					if(customer.buy(theSpell))
						this.spells.remove(theSpell);
				}
		}
		
		else if(command.equalsIgnoreCase("Sell") || command.equalsIgnoreCase("S")){
			System.out.println("What would you like to sell?");
			
			if(this.type.equals("Magic"))
				customer.printSpellbook();
			else
				customer.printInventory();
			
			command = input.nextLine();
			if(customer.findItemWithName(command) != null || customer.findSpellWithName(command) != null)
				if(customer.findItemWithName(command) != null){
					Item theItem = customer.findItemWithName(command);
					if(customer.sell(theItem))
						this.inventory.add(theItem);
				}
				else if(customer.findSpellWithName(command) != null){
					Spell theSpell = customer.findSpellWithName(command);
					if(customer.sell(theSpell))
						this.spells.add(theSpell);
				}
			
			
		}
		
		else if(command.equalsIgnoreCase("Ask") || command.equalsIgnoreCase("A")){
			System.out.println("Which one are you curious about?");
			command = input.nextLine();
			if(this.findItemWithName(command) != null || this.findSpellWithName(command) != null){
				if(this.findItemWithName(command) != null){
					Item theItem = this.findItemWithName(command);
					System.out.println("Here's what I know...");
					
					if(theItem.getPower() > 0)
						System.out.println("Power: "+theItem.getPower());
					if(theItem.getDefense() > 0)
						System.out.println("Defense: "+theItem.getDefense());
					if(theItem.getHealing() > 0)
						System.out.println("Healing: "+theItem.getHealing());
					if(theItem.getRegain() > 0)
						System.out.println("Regain: "+theItem.getRegain());
					if(theItem.getWeight() > 0)
						System.out.println("Weight: "+theItem.getWeight());
					if(theItem.getMaxAmmo() > 0)
						System.out.println("Ammo Capacity: "+theItem.getMaxAmmo());
					if(theItem.getFlag() != null)
						System.out.println("Special Attribute: "+theItem.getFlag());
					
					
					System.out.println("Value: "+theItem.getValue());
				}
				else if(this.findSpellWithName(command) != null){
					Spell theSpell = this.findSpellWithName(command);
					System.out.println("Here's what I know...");
					
					System.out.println("Power: "+theSpell.getPower());
					System.out.println("Cost: "+theSpell.getCost());
					System.out.println("Element: "+theSpell.getElement());
					System.out.println("Value: "+theSpell.getValue());
				}

			}
			
		}
		
		else if(command.equalsIgnoreCase("Leave") || command.equalsIgnoreCase("L"))
			break;
		
			System.out.println("Can I help you with anything else? Or are you ready to leave?");
		}
	}
}


