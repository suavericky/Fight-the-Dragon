import java.util.*;
//import java.math.*;

public class Character {
	
	private String name, weakness, status;
	private int health, maxHealth, mana, maxMana,
				strength, endurance, intelligence,
				speed, wallet, capacity, maxCapacity;
	private Item weapon, armor;
	private static Item NOTHING = new Item(0,0,0,0,0,0,"nothing","nothing");
	private ArrayList<Item> inventory;
	private ArrayList<Spell> spellbook;
	private ArrayList<Character> bossesBeaten;
	
	public Character(){
		//default constructor
	}
	
	public Character(String n, int t, int e , int i, int p, String w){
		
		this.name = n;
		this.weakness = w;
		this.status = "normal";
		
		this.strength = t;
		this.endurance = e;
		this.intelligence = i;
		this.speed = p;
		
		this.wallet = 0;
		
		this.health = endurance*5 + 50;
		this.maxHealth = health;
		this.mana = intelligence*3 + 10;
		this.maxMana = mana;
		
		this.capacity = 10+strength*2;
		this.maxCapacity = capacity;
		
		this.weapon = NOTHING;
		this.armor = NOTHING;
		
		this.inventory = new ArrayList<Item>();
		this.spellbook = new ArrayList<Spell>();
		this.bossesBeaten = new ArrayList<Character>();
	}
	
	public String getName(){
		return name;
	}
	
	public Character buildCharacter(){
		String name;
		int strength = 0, intelligence = 0, endurance = 0, speed = 0, remaining, temp;
		remaining = 30;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What is your name?");
		name = keyboard.nextLine();
		
		System.out.println("Welcome, "+name+", you may now distribute 30 attribute points.");
		
		System.out.println("Points will be distributed among four primary attributes:\n");
		System.out.println("Strength - Determines physical power and carrying capacity");
		System.out.println("Intelligence - Determines magical power, MP quantity, and magical resistance");
		System.out.println("Endurance - Determines physical defense, HP quantity, and affects magical resistance");
		System.out.println("Speed - Determines command order, command quantity, ranged power, critical rate, and dodge rate\n");
		
		System.out.println("How many will you spend on Strength?");
		temp = keyboard.nextInt();
		if(temp <= remaining && temp >= 0){
			strength = temp;
			remaining = remaining - temp;
		}
		else{
			System.out.println("Invalid quantity entered.");
			System.out.println("You'll have another chance to come back to this attribute.\n");
		}
		
		System.out.println("You have "+remaining+" points remaining.\n");
		
		System.out.println("How many will you spend on Intelligence?");
		temp = keyboard.nextInt();
		if(temp <= remaining && temp >= 0){
			intelligence = temp;
			remaining = remaining - temp;
		}
		else{
			System.out.println("Invalid quantity entered.");
			System.out.println("You'll have another chance to come back to this attribute.\n");
		}
		
		System.out.println("You have "+remaining+" points remaining.\n");
		
		System.out.println("How many will you spend on Endurance?");
		temp = keyboard.nextInt();
		if(temp <= remaining && temp >= 0){
			endurance = temp;
			remaining = remaining - temp;
		}
		else{
			System.out.println("Invalid quantity entered.");
			System.out.println("You'll have another chance to come back to this attribute.\n");
		}
		
		System.out.println("You have "+remaining+" points remaining.\n");
		
		System.out.println("How many will you spend on Speed?");
		temp = keyboard.nextInt();
		if(temp <= remaining && temp >= 0){
			speed = temp;
			remaining = remaining - temp;
		}
		else{
			System.out.println("Invalid quantity entered.");
			System.out.println("You'll have another chance to come back to this attribute.\n");
		}
		
		System.out.println("You have "+remaining+" points remaining.\n");
		
		while(remaining > 0){
			String stat;
			System.out.println("\nPlease allocate your remaining points.");
			System.out.println("Which attribute will you allocate points to? ([S]trength, [E]ndurance, [I]ntelligence, or S[p]eed)");
			stat = keyboard.nextLine();
			
			if(stat.equalsIgnoreCase("Strength") || stat.equalsIgnoreCase("S")){
			
			System.out.println("How many will you spend on Strength?");
			temp = keyboard.nextInt();
			if(temp <= remaining && temp >= 0){
				strength = temp;
				remaining = remaining - temp;
			}
			else{
				System.out.println("Invalid quantity entered.\n");
			}
			
			System.out.println("You have "+remaining+" points remaining.\n");
			
			}
			
			if(stat.equalsIgnoreCase("Intelligence") || stat.equalsIgnoreCase("I")){
			
			System.out.println("How many will you spend on Intelligence?");
			temp = keyboard.nextInt();
			if(temp <= remaining && temp >= 0){
				intelligence = temp;
				remaining = remaining - temp;
			}
			else{
				System.out.println("Invalid quantity entered.\n");
			}
			
			System.out.println("You have "+remaining+" points remaining.\n");
			
			}
			
			if(stat.equalsIgnoreCase("Endurance") || stat.equalsIgnoreCase("E")){
			
			System.out.println("How many will you spend on Endurance?");
			temp = keyboard.nextInt();
			if(temp <= remaining && temp >= 0){
				endurance = temp;
				remaining = remaining - temp;
			}
			else{
				System.out.println("Invalid quantity entered.\n");
			}
			
			System.out.println("You have "+remaining+" points remaining.\n");
			
			}
			
			if(stat.equalsIgnoreCase("Speed") || stat.equalsIgnoreCase("P")){
			
			System.out.println("How many will you spend on Speed?");
			temp = keyboard.nextInt();
			if(temp <= remaining && temp >= 0){
				speed = temp;
				remaining = remaining - temp;
			}
			else{
				System.out.println("Invalid quantity entered.\n");
			}
			
			System.out.println("You have "+remaining+" points remaining.\n");
			
			}
		}
		
		return new Character(name,strength,endurance,intelligence,speed,"none");
		
	}
	
	public void levelUp(){
		
		this.health = this.maxHealth;
		this.mana = this.maxMana;
		this.weapon.reload();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Choose a stat to increase. ([S]trength, [E]ndurance, [I]ntelligence, or S[p]eed)");
		String input = in.nextLine();
		
		while(true){
		
		if(input.equalsIgnoreCase("Strength") || input.equalsIgnoreCase("S")){
			++(this.strength);
			break;
		}
		else if(input.equalsIgnoreCase("Endurance") || input.equalsIgnoreCase("E")){
			++(this.endurance);
			break;
		}
		else if(input.equalsIgnoreCase("Intelligence") || input.equalsIgnoreCase("I")){
			++(this.intelligence);
			break;
		}
		else if(input.equalsIgnoreCase("Speed") || input.equalsIgnoreCase("P")){
			++(this.speed);
			break;
		}
		else
			System.out.println("Try again!");
			input = in.nextLine();
		}
		
		this.health = endurance*5;
		this.maxHealth = health;
		this.mana = intelligence*3;
		this.maxMana = mana;
		
		int temp = this.maxCapacity;
		this.maxCapacity = 10+this.strength*2;
		temp = maxCapacity - temp;
		this.capacity = this.capacity + temp;
		
		System.out.println("Strength: "+this.strength);
		System.out.println("Intelligence: "+this.intelligence);
		System.out.println("Endurance: "+this.endurance);
		System.out.println("Speed: "+this.speed);
		
	}
	
	public void healAll(){
		this.mana = this.maxMana;
		this.health = this.maxHealth;
		if(rangedWeapon())
			this.weapon.reload();
	}
	
	public void takeDamage(int damage){
		this.health = this.health-damage;
	}
	
	public void heal(int healing){
		if(healing > this.maxHealth)
			healing = maxHealth;
		this.health = this.health+healing;
	}
	
	public void regainMP(int regen){
		if(regen > this.maxMana)
			regen = maxMana;
		this.mana = this.mana+regen;
	}
	
	public void attack(Character target){
		//wrapper for basic attack.
		if(this.weapon.getType() != null && this.weapon.getType().equals("ranged") 
				&& this.weapon.getAmmo() <= 0){
			
			System.out.println(this.getName()+" reloads!\n");
			this.weapon.reload();
			
		}
		else{
		
		System.out.println(this.getName()+" attacks!");
		dealDamage(this.calcDamage(target), target);
		
		if(this.weapon.getType() != null && this.weapon.getType().equals("ranged") ){
			System.out.println("Ammo: "+this.weapon.getAmmo()+" / "+this.weapon.getMaxAmmo()+"\n");
		}
		}
	}
	
	public void dealDamage(int damage, Character target){
		
		damage = damage - RNG()%10;
		int speedCheckPlayer = this.getSpeed();
		int speedCheckEnemy = target.getSpeed();
		boolean swiftness = false;
		boolean automatic = false;
		boolean critical = false;
		boolean dodge = false;
		
		
		
		
		
		
		if(this.checkFlagsWeapon() != null){
			
			if(this.weapon.getFlag() != null && this.weapon.getFlag().equals("swiftness"))
				swiftness = true;
		
			if(this.weapon.getFlag() != null && this.weapon.getFlag().equals("crit+"))
				speedCheckPlayer = speedCheckPlayer*2;
			
			if(this.weapon.getFlag() != null && this.weapon.getFlag().equals("automatic"))
				automatic = true;
		
		}
		
		
		
		if(checkFlagsArmor() != null){
		
		if(target.armor.getFlag() != null && target.armor.getFlag().equals("heavy"))
			speedCheckEnemy = speedCheckEnemy/2;
		
		if(target.armor.getFlag() != null && target.armor.getFlag().equals("weightless"))
			speedCheckEnemy = speedCheckEnemy*3;
		
		}
		
		for(int i = 0; i < speedCheckEnemy; ++i){
			if(RNG() == 99){
				dodge = true;
				break;
			}	
		}
		
		
		
		if(swiftness){
			
			int temp;
			
			for(int i = 0; i < 2; ++i){
				
				temp = damage;
				
				if(RNG() == 99){
					System.out.println("It's a critical hit!");
					critical = true;
					}
				
				if(dodge){
					System.out.println(target.getName()+" dodges at the last minute!");
					temp = 0;
					target.takeDamage(temp);
					System.out.println(this.getName()+" swiftly dealt "+temp+" damage to "+target.getName()+"\n");
					critical = false;
					if(this.weapon.getType() != null && this.weapon.getType().equals("ranged")){
						this.weapon.fireRound();
					}
					continue;
				}
				
				if(critical)
					temp = temp*2;
				
				temp = temp - RNG()%5;
				
				if(temp > target.getHealth())
					temp = target.getHealth();
				
				if(temp < 1)
					temp = 1;
				
				target.takeDamage(temp);
				System.out.println(this.getName()+" swiftly dealt "+temp+" damage to "+target.getName()+"\n");
				critical = false;
				
				if(target.getHealth() <= 0)
					break;
				
				if(this.weapon.getType() != null && this.weapon.getType().equals("ranged")){
					this.weapon.fireRound();
				}
			}
			
		}
		else if(automatic){
			
			damage = damage/10;
			int temp = damage;
			
			for(int i = 0; i < 10; ++i){
				
				if(RNG() == 99){
					System.out.println("It's a critical hit!");
					critical = true;
					}
				
				if(dodge){
					System.out.println(target.getName()+" dodges at the last minute!");
					temp = 0;
					target.takeDamage(temp);
					System.out.println(this.getName()+" dealt "+temp+" damage to "+target.getName()+"\n");
					critical = false;
					if(this.weapon.getType() != null && this.weapon.getType().equals("ranged")){
						this.weapon.fireRound();
					}
					continue;
				}
				
				if(critical)
					temp = temp*2;
				
				temp = temp-RNG()%3;
				
				if(temp < 1)
					temp = 1;
				
				target.takeDamage(temp);
				System.out.println(this.getName()+" dealt "+temp+" damage to "+target.getName()+"\n");
				critical = false;
				
				if(target.getHealth() <= 0)
					break;
				
				if(this.weapon.getType() != null && this.weapon.getType().equals("ranged")){
					this.weapon.fireRound();
				}
				
			}
		}
		else{
			
			if(RNG() == 99){
				System.out.println("It's a critical hit!");
				critical = true;
				}
			
			
			if(damage > target.getHealth())
				damage = target.getHealth();
			
			if(damage < 1 )
				damage = 1;
			
			if(dodge){
				System.out.println(target.getName()+" dodges at the last minute!");
				damage = 0;
			}
			
			
			target.takeDamage(damage);
			System.out.println(this.getName()+" dealt "+damage+" damage to "+target.getName()+"\n");
			critical = false;
			
			if(this.weapon.getType() != null && this.weapon.getType().equals("ranged") ){
				this.weapon.fireRound();
			}
		}
		
	}
	
	
	public int calcDamage(Character enemy){
		
		int standardDamage = (2*this.strength+this.weapon.getPower())-(enemy.endurance+enemy.armor.getDefense());
		
		if(this.weapon.getType() != null && this.weapon.getType().equals("ranged") ){
			standardDamage = (this.speed+this.weapon.getPower()-(enemy.endurance+enemy.armor.getDefense()));
		}
		
		if(this.weapon.getFlag() == null)
			return standardDamage;
		
		else{
			if(weaknessCheck(this.weapon, enemy)){
				System.out.println("Weakness Exploited!");
				return 2*standardDamage;
			}
			else
				return standardDamage;
		}
	}
	
	public boolean getItem(Item thing){
		if(thing.getWeight() <= this.capacity){
			this.inventory.add(thing);
			this.capacity = capacity - thing.getWeight();
			return true;
		}
		else{
			System.out.println("You don't have the strength to carry this.");
			return false;
		}
	}
	
	public void getSpell(Spell magic){
		this.spellbook.add(magic);
	}
	
	public boolean useItem(Item thing){
		
		//Limited to healing properties
		
		if(this.inventory.contains(thing)){
			
			if(thing.getHealing() > 0){
				this.heal(thing.getHealing());
				System.out.println("You have healed "+thing.getHealing()+" HP!");
			}
			
			if(thing.getRegain() > 0){
				this.regainMP(thing.getRegain());
				System.out.println("You have regained "+thing.getRegain()+" MP!");
			}
			
			this.inventory.remove(thing);
			this.capacity = capacity + thing.getWeight();
			
		}
		else{
			System.out.println("You don't have this item");
			return false;
		}
		if(this.getHealth() > this.maxHealth)
			this.health = maxHealth;
		return true;
	}
	
	public void equipWeapon(Item thing){
		if(this.inventory.contains(thing))
			this.weapon = thing;
		else
			System.out.println("You don't have this equipment");
	}
	
	public void equipArmor(Item thing){
		if(this.inventory.contains(thing))
			this.armor = thing;
		else
			System.out.println("You don't have this equipment");
	}
	
	public Spell commandToSpell(String command){
		for(int i = 0; i < this.spellbook.size(); ++i){
			if(this.spellbook.get(i).getName().equals(command))
				return this.spellbook.get(i);
		}
		return null;
	}
	
	public Item commandToItem(String command){
		for(int i = 0; i < this.inventory.size(); ++i){
			if(this.inventory.get(i).getName().equals(command))
				return this.inventory.get(i);
		}
		return null;
	}
	
	public boolean weaknessCheck(Spell which, Character target){
	String type1, type2;
	
	type1 = which.getElement();
	type2 = target.getWeakness();
	
	if(type1.equals("fire") && type2.equals("fire"))
		return true;
	if(type1.equals("ice") && type2.equals("ice"))
		return true;
	if(type1.equals("earth") && type2.equals("earth"))
		return true;
	if(type1.equals("lightning") && type2.equals("lightning"))
		return true;
	else
		return false;
	
	}
	
	public boolean weaknessCheck(Item which, Character target){
		String type1, type2;
		
		type1 = which.getFlag();
		type2 = target.getWeakness();
		
		if(type1.equals("fire") && type2.equals("fire"))
			return true;
		if(type1.equals("ice") && type2.equals("ice"))
			return true;
		if(type1.equals("earth") && type2.equals("earth"))
			return true;
		if(type1.equals("lightning") && type2.equals("lightning"))
			return true;
		else
			return false;
		
		}
	
	public boolean castSpell(Spell which, Character target){
		if(this.spellbook.contains(which)){
			if(which.getCost() <= this.mana){
				System.out.println(this.getName()+" cast "+which.getName()+"!");
				
				if(which.getFlag() != null){
					
					if(which.getFlag().equals("heal")){
						int healing = (which.getPower()/100)*(this.getMaxHealth());
						if(healing > this.getMaxHealth())
							healing = this.getMaxHealth();
						if(healing < 0)
							healing = 0; //should never happen
						System.out.println("You have healed "+healing+" HP!");
						this.heal(healing);
					}
					if(which.getFlag().equals("poison")){
						
						System.out.println(target.getName()+" was poisoned!");
						target.setStatus("poison");
					}
					if(which.getFlag().equals("sleep")){
						
						System.out.println(target.getName()+" drifted off into a deep sleep!");
						target.setStatus("sleep");
					}
					
				}
				else{
				
				int damage = ((2*this.intelligence+which.getPower())-(target.intelligence+target.endurance/2+target.armor.getDefense()/2));
				
				if(this.checkFlagsWeapon() != null){
					if(this.weapon.getFlag() != null && this.weapon.getFlag().equals("magic+"))
						damage = (damage*12)/10;
					if(this.weapon.getFlag() != null && this.weapon.getFlag().equals("magic++"))
						damage = (damage*15)/10;
					if(this.weapon.getFlag() != null && this.weapon.getFlag().equals("magic+++"))
						damage = (damage*20)/10;
				}
				
				if(target.armor.getFlag() != null && target.armor.getFlag().equals("resist+"))
					damage = damage/2;
				if(weaknessCheck(which, target) == true){
					System.out.println("Weakness Exploited!");
					damage = damage*2;
				}
				this.mana = this.mana - which.getCost();
				this.dealDamage(damage, target);
				return true;
			}
			}
			else{
				System.out.println("You don't have enough mana!");
				return false;
			
			}
		
		}
		else
			System.out.println("You don't know this spell");
			return false;
	}
	
	public String issueCommand(){
		
		System.out.println("Issue a command!");
		
		String auto = "Attack";
		
		System.out.println("[A]ttack  [S]pell  [I]tem");
		Scanner keyboard = new Scanner(System.in);
		String command = keyboard.nextLine();
		
		//System.out.println(command);
		
		if(command.equalsIgnoreCase("Attack") || command.equalsIgnoreCase("A"))
			return "Attack";
		
		if(command.equalsIgnoreCase("Spell") || command.equalsIgnoreCase("S"))
			return "Spell";
		
		if(command.equalsIgnoreCase("Item") || command.equalsIgnoreCase("I"))
			return "Item";
		
		else{
			return auto;
		}
	}
	
	public ComplexCMD computeCommand(){
		int var = RNG()%10;
		ComplexCMD temp = new ComplexCMD();
		boolean heal = false;
		boolean spell = false;
		
		if(this.health < this.maxHealth/2){
			
			for(int i = 0; i  < this.inventory.size(); ++i){
				if(heal == true && this.health > this.maxHealth/8){
					heal = false;
					break;
				}
				if(this.inventory.get(i).getHealing() > 0){
					temp.setCommand("Item");
					temp.setOption(this.inventory.get(i).getName());
					heal = true;
					return temp;
				}
			}
			
			temp.setCommand("Attack");
			temp.setOption("Attack");
			heal = false;
			spell = false;
			return temp;
		}
		else if(this.mana > 0){
			int count = 0;
			
			while(count <= this.spellbook.size() && 0 != this.spellbook.size()){
				int i = RNG()%this.spellbook.size();
				
				if(spell == true && var > 6){
					spell = false;
					break;
				}
				
				if(this.spellbook.get(i).getCost() <= this.mana){
					temp.setCommand("Spell");
					temp.setOption(this.spellbook.get(i).getName());
					spell = true;
					return temp;
				}
				++count;

			}
			temp.setCommand("Attack");
			temp.setOption("Attack");
			heal = false;
			spell = false;
			return temp;
		}
			
		else{
			temp.setCommand("Attack");
			temp.setOption("Attack");
			heal = false;
			spell = false;
			return temp;
		}
		
	}
	

	public boolean execute(String command, Character target){
		
		//For player commands
		
		Scanner keyboard = new Scanner(System.in);
		if(command.equals("Attack")){
			this.attack(target);
			return true;
		}
		else if(command.equals("Spell")){
			System.out.println("Choose a spell to cast!");
			
			for(Spell temp : this.spellbook){
				Spell which = temp;
				System.out.println(" o "+which.getName()+" "+which.getPower()+" / "+which.getCost());
			}
			
			command = keyboard.nextLine();
			Spell cast = this.commandToSpell(command);
			return this.castSpell(cast, target);
		}
		else if(command.equals("Item")){
			System.out.println("Choose an item to use!");
			
			for(Item temp : inventory){
				System.out.println(" o "+temp.getName());
			}
			
			command = keyboard.nextLine();
			Item use = this.commandToItem(command);
			return this.useItem(use);
		}
		else{
			return false;
		}
	}
	
	public void execute(ComplexCMD cmd, Character target){
		
		//For AI commands
		
		String command = cmd.getCommand();
		String option = cmd.getOption();
		
		if(command.equals("Attack"))
			this.attack(target);
		if(command.equals("Spell")){
			
			Spell cast = this.commandToSpell(option);
			this.castSpell(cast, target);
		}
		if(command.equals("Item")){
			
			Item use = this.commandToItem(option);
			this.useItem(use);
		}
	}
	
	public void printStatus(){
		System.out.println(this.getName());
		System.out.println("HP: "+this.health+" / "+this.maxHealth);
		System.out.println("MP: "+this.mana+" / "+this.maxMana);
		System.out.println("");
	}
	
	public void acquireMoney(int money){
		this.wallet = wallet + money;
	}
	
	public void loseMoney(int money){
		if(money > this.wallet)
			money = wallet;
		
		this.wallet = wallet - money;
	}
	
	public boolean buy(Item toBuy){
		
		if(this.capacity < toBuy.getWeight()){
			System.out.println("You won't be able to carry this.");
			return false;
		}
		
		if(this.wallet >= toBuy.getValue()){
			this.wallet = wallet - toBuy.getValue();
			this.inventory.add(toBuy);
			this.capacity = capacity - toBuy.getWeight();
			
			if(toBuy.getPower() > 0){
				this.equipWeapon(toBuy);
				System.out.println(toBuy.getName()+" was equipped!");
			}
			
			else if(toBuy.getDefense() > 0){
				this.equipArmor(toBuy);
				System.out.println(toBuy.getName()+" was equipped!");
			}
			
			return true;
		}
		else{
			System.out.println("You don't have enough money.");
			return false;
		}
	}
	
	public boolean buy(Spell toBuy){
		if(this.wallet >= toBuy.getValue()){
			this.wallet = wallet - toBuy.getValue();
			this.spellbook.add(toBuy);
			return true;
		}
		else{
			System.out.println("You don't have enough money.");
			return false;
		}
	}
	
	public boolean sell(Item toSell){
		if(this.inventory.contains(toSell)){
			this.inventory.remove(toSell);
			
			if(this.weapon.getName() == toSell.getName())
				this.weapon = NOTHING;
			if(this.armor.getName() == toSell.getName())
				this.armor = NOTHING;
			
			this.capacity = capacity + toSell.getWeight();
			
			if(this.capacity > this.maxCapacity)
				this.capacity = this.maxCapacity;
			
			this.wallet = wallet + toSell.getValue()/2;
			return true;
		}
		else{
			System.out.println("You can't sell that.");
			return false;
		}
		
	}
	
	public boolean sell(Spell toSell){
		if(this.spellbook.contains(toSell)){
			this.spellbook.remove(toSell);
			this.wallet = wallet + toSell.getValue()/2;
			return true;
		}
		else{
			System.out.println("You can't sell that.");
			return false;
		}
		
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
		
		for(Spell temp : this.spellbook){
			if(temp.getName().equals(name))
				found = temp;
		}
		
		return found;
	}

	public int getHealth() {
		return health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public String getWeakness(){
		return weakness;
	}
	
	public int getMaxHealth(){
		return maxHealth;
	}
	
	public int getMaxMana(){
		return maxMana;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public int getMaxCapacity(){
		return maxCapacity;
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String s){
		this.status = s;
	}
	
	public void normalize(){
		this.status = "normal";
	}
	
	public void printInventory(){
		System.out.println(" + Weapon: "+this.weapon.getName());
		System.out.println(" + Armor: "+this.armor.getName());
		for(Item temp : this.inventory){
			System.out.println(" o "+temp.getName());
		}
	}
	
	public void printSpellbook(){
		for(Spell temp : this.spellbook){
			System.out.println(" o "+temp.getName());
		}
	}
	
	public int getWallet(){
		return wallet;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public int getIntelligence(){
		return intelligence;
	}
	
	public int getEndurance(){
		return endurance;
	}
	
	public void addBossBeaten(Character boss){
		this.bossesBeaten.add(boss);
	}
	
	public boolean bossCheck(String bossName){
		
		for(Character temp : bossesBeaten){
			if(temp.getName().equals(bossName))
				return true;
		}

			return false;
	}
	
	public boolean rangedWeapon(){
		if(this.weapon.getType().equals("ranged"))
			return true;
		else
			return false;
	}
	
	public String checkFlagsArmor(){
		
		if(this.armor.getFlag() != null)
			return this.armor.getFlag();
		else
			return null;
			
	}
	
	public String checkFlagsWeapon(){
		
		if(this.weapon.getFlag() != null)
			return this.weapon.getFlag();
		else
			return null;
			
	}

	public int calcBST(){
		int BST = 0;
		BST += this.strength;
		BST += this.intelligence;
		BST += this.endurance;
		BST += this.speed;
		return BST;
	}
	
	public int RNG(){
		return (int)(Math.random()*100);
	}
	
	

}
