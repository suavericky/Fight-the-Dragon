import java.util.*;
public class Driver {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		//Character fighter = new Character("Fighter",10,10,0,10,"none");
		
		/*String c;
		
		Character fighter = new Character();
		
		System.out.println("Please choose a class.");
		System.out.println("Warrior  Sorcerer  Rogue");
		
		c = input.nextLine();
		
		while(true){
		
		if(c.equals("Warrior")){
			fighter = new Character("Fighter",10,10,0,10,"none");
			break;
		}
		
		else if(c.equals("Sorcerer")){
			fighter = new Character("Fighter",0,10,15,5,"none");
			break;
		}
		
		else if(c.equals("Rogue")){
			fighter = new Character("Fighter",5,5,0,20,"none");
			break;
		}
		
		else{
			System.out.println("Not recognized! Pick one of the classes!");
			c = input.nextLine();
			continue;
		}
		
		}*/
		
		Character fighter = new Character();
		fighter = fighter.buildCharacter();
		
		fighter.acquireMoney(1000);
		
		ArrayList<Character> gauntlet = new ArrayList<Character>();
		int gauntletCount = 0;
		Character dragon1 = new Character("Great Dragon",25,30,10,5,"ice");
		Character dragon2 = new Character("Ebon Dragon",10,25,25,10,"lightning");
		Character dragon3 = new Character("Elder Dragon",25,40,20,5,"earth");
		Character dragon4 = new Character("Undead Dragon",30,20,10,40,"fire");
		
		Character dragon5 = new Character("Mecha-Draconoid",40,30,10,20,"none");
		Character dragon6 = new Character("Demon King Dragon",75,30,20,5,"lightning");
		Character dragon7 = new Character("Two-Headed Dragon",30,40,20,20,"ice");
		Character dragon8 = new Character("Ivory Dragon",20,30,40,20,"fire");
		
		Character dragonX = new Character("Ultimate Dragon",50,50,50,50,"none");
		
		
		Spell fire = new Spell(25,8,100,"Fireball","fire");
		//Spell xfire = new Spell(50,16,500,"Fireblast","fire");
		//Spell lightning = new Spell(35,12,200,"Lightning Bolt","lightning");
		Spell xxice = new Spell(80,16,1000,"Frost Legion","ice");
		Spell sleep = new Spell(0,28,1000,"Slumber","none","sleep");
		Spell ugb = new Spell(200,60,1500,"Ultimate God Blast","none");
		
		Item dc = new Item(10,0,0,0,0,0,"Dragon's Claws");
		Item ds = new Item(0,10,0,0,0,0,"Dragon's Scales");
		Item xdc = new Item(30,0,0,0,0,0,"Dragon's Claws+");
		Item xds = new Item(0,30,0,0,0,0,"Dragon's Scales+");
		
		Item gds = new Item(0,30,0,0,0,0,"resist+","Galvanized Alloy Scales");
		Item thh = new Item(30,0,0,0,0,0,"swiftness","Two-Headed Dragon Horns");
		Item mdc = new Item(30,0,0,0,0,0,"magic+","Mystical Dragon Claws");
		
		Item elixir = new Item(0,0,50,50,0,0,"Elixir");
		
		
		
		dragon2.getSpell(fire);
		dragon1.getSpell(fire);
		dragon8.getSpell(sleep);
		dragon8.getSpell(fire);
		dragon8.getSpell(xxice);
		dragonX.getSpell(ugb);

		gauntlet.add(dragon1);
		gauntlet.add(dragon2);
		gauntlet.add(dragon3);
		gauntlet.add(dragon4);
		gauntlet.add(dragon5);
		gauntlet.add(dragon6);
		gauntlet.add(dragon7);
		gauntlet.add(dragon8);
		gauntlet.add(dragonX);
		
		for(Character temp : gauntlet){
			temp.getItem(dc);
			temp.getItem(ds);
			
			temp.equipWeapon(dc);
			temp.equipArmor(ds);
			
			if(temp.getName().equals("Elder Dragon")){
				temp.getItem(xds);
				temp.equipArmor(xds);
			}
			
			if(temp.getName().equals("Undead Dragon")){
				temp.getItem(dc);
				temp.equipWeapon(dc);
			}
			
			if(temp.getName().equals("Mecha-Draconoid")){
				
				for(int i = 0; i < 10; ++i)
					temp.getItem(elixir);
				
				temp.getItem(gds);
				temp.equipArmor(gds);
				
			}
			
			if(temp.getName().equals("Demon King Dragon")){
				
				temp.getItem(xds);
				temp.getItem(xdc);
				
				temp.equipArmor(xds);
				temp.equipWeapon(xdc);
				
			}
			
			if(temp.getName().equals("Two-Headed Dragon")){
				temp.getItem(thh);
				temp.equipWeapon(thh);
				
				temp.getItem(xds);
				temp.equipArmor(xds);
			}
			
			if(temp.getName().equals("Ivory Dragon")){
				temp.getItem(mdc);
				temp.equipWeapon(mdc);
				
				temp.getItem(xds);
				temp.equipArmor(xds);
			}
			
			if(temp.getName().equals("Ultimate Dragon")){
				temp.getItem(xds);
				temp.equipArmor(xds);
				
				temp.getItem(xdc);
				temp.equipWeapon(xdc);
				
			}
		}
		
		/*
		
		//Initialize basic fighter
		
		Item sword = new Item(20,0,0,0,0,"Sword");
		fighter.getItem(sword);
		fighter.equipWeapon(sword);
		
		Item armor = new Item(0,20,0,0,0,"Armor");
		fighter.getItem(armor);
		fighter.equipArmor(armor);
		
		Item mc = new Item(0,0,0,0,20,"Mana Crystal");
		for(int i = 0; i < 5; ++i){
			fighter.getItem(mc);
		}
		
		Item potion = new Item(0,0,0,20,0,"Potion");
		for(int i = 0; i < 5; ++i){
			fighter.getItem(potion);
		}
		
		//Initialize basic mage
		
		Spell fire = new Spell(16,8,0,"Fireball","fire");
		Spell ice = new Spell(10,5,0,"Frost Arrow","ice");
		Spell lightning = new Spell(20,12,0,"Lightning Bolt","lightning");
		Spell cb = new Spell(12,5,0,"Clay Blast","earth");
		Spell ugb = new Spell(100,60,0,"Ultimate God Blast","none");
		
		fighter.getSpell(ugb);
		fighter.getSpell(fire);
		fighter.getSpell(ice);
		fighter.getSpell(lightning);
		fighter.getSpell(cb);
		
		dragon.getSpell(fire);
		dragon.getSpell(lightning);
		dragon.getItem(potion);
		
		
		Battle testFighter = new Battle(fighter,dragon);
		
		*/
		String command = "";
		while(fighter.getHealth() > 0){
			
			fighter.heal(fighter.getMaxHealth()-fighter.getHealth());
			Town newTown = new Town();
			System.out.println("Welcome to town! Would you like to visit a shop?\n");
			command = "";
			while(!command.equals("Leave")){
				System.out.println("[W]eapons  [A]rmor  [M]agic  M[i]sc  A[r]ena  In[v]entory  [L]eave");
				command = input.nextLine();
				if(newTown.checkValid(command)){
					Shop theShop = newTown.commandToShop(command);
					newTown.accessShop(fighter, theShop);
				}
				else if(command.equalsIgnoreCase("Inventory") || command.equalsIgnoreCase("V")){

					fighter.printInventory();
					System.out.println("[E]quip  [C]heck");
					
					if(command.equalsIgnoreCase("Equip") ||command.equalsIgnoreCase("E")){
					
					System.out.println("What do you want to equip?");
					command = input.nextLine();
					Item toEquip = fighter.findItemWithName(command);
					if(toEquip != null){
						if(toEquip.getPower() > 0)
							fighter.equipWeapon(toEquip);
						else if(toEquip.getDefense() > 0)
							fighter.equipArmor(toEquip);
						else{
							System.out.println("That isn't going to help much.");
							command = "";
						}
						
					}
						
					}
					
					else if(command.equalsIgnoreCase("Check") ||command.equalsIgnoreCase("C")){
						
						System.out.println("What do you want to check?");
						command = input.nextLine();
						Item toCheck = fighter.findItemWithName(command);
						
						if(toCheck.getPower() > 0)
							System.out.println("Power: "+toCheck.getPower());
						if(toCheck.getDefense() > 0)
							System.out.println("Defense: "+toCheck.getDefense());
						if(toCheck.getHealing() > 0)
							System.out.println("Healing: "+toCheck.getHealing());
						if(toCheck.getRegain() > 0)
							System.out.println("Regain: "+toCheck.getRegain());
						if(toCheck.getWeight() > 0)
							System.out.println("Weight: "+toCheck.getWeight());
						if(toCheck.getMaxAmmo() > 0)
							System.out.println("Ammo Capacity: "+toCheck.getMaxAmmo());
						if(toCheck.getFlag() != null)
							System.out.println("Special Attribute: "+toCheck.getFlag());
						
						System.out.println("Value: "+toCheck.getValue());
						
						command = "";
						
						
					}
						
				}
				else if(command.equalsIgnoreCase("Arena") || command.equalsIgnoreCase("R")){
					newTown.accessArena(fighter);
				}
				else if(command.equalsIgnoreCase("Leave") || command.equalsIgnoreCase("L"))
					break;
			}
			
			Battle fight = new Battle(fighter,gauntlet.get(gauntletCount));
			boolean result = fight.doBattle();
			
			if(result){
				for(int k = 0; k < 3; ++k)
					fighter.levelUp();
				fighter.acquireMoney(500);
				if(gauntletCount < 8)
				++gauntletCount;
				else{
					System.out.println("Congratulations! You have defeated all the mighty dragons!");
					System.exit(0);
				}
				
			}
			else if(!result)
				break;
			
		}
		
		
		//testFighter.doBattle();
		
		
		
	}

}
