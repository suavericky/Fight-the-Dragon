import java.util.*;

public class Arena {
	
	private ArrayList<Character> allEnemies;
	private ArrayList<Character> enemies;
	private ArrayList<Item> loot;
	private Character player;
	private Battle arenaBattle;
	
	public Arena(){
		
		//Default constructor
		this.allEnemies = new ArrayList<Character>();
		this.enemies = new ArrayList<Character>();
		this.loot = new ArrayList<Item>();
		this.arenaBattle = new Battle(null,null);
	
	}
	
	public Arena(Character p){
		
		this.player = p;
		this.allEnemies = new ArrayList<Character>();
		this.enemies = new ArrayList<Character>();
		this.loot = new ArrayList<Item>();
		this.arenaBattle = new Battle(null,null);
	
	}
	
	public void initialize(Character p){
		
		this.player = p;
		this.allEnemies = new ArrayList<Character>();
		this.enemies = new ArrayList<Character>();
		this.loot = new ArrayList<Item>();
		//this.arenaBattle = new Battle(null,null);
		
		//int BST = this.getPlayer().calcBST();
		
		Character dragon1 = new Character("Great Dragon",25,30,10,5,"ice");
		Character juggs = new Character("Juggernaut", 25,25,0,5,"none");
		Character bwp = new Character("Blackwater Phantom",5,20,25,20,"fire");

		Character gg = new Character("Golden Goblin", 5,10,20,60,"none");
		Character sgg = new Character("Super Golden Goblin",10,30,20,90,"none");
		
		Item dc = new Item(10,0,0,0,0,0,"Dragon's Claws");
		Item jsod = new Item(15,0,1500,0,0,2,"melee","magic+++","Jupiter, Staff of Dominion");
		Item pl = new Item(70,0,800,0,0,14,"melee","Palladium Lance");
		Item gobg = new Item(80,0,2000,0,0,1,20,"ranged","swiftness","Goblin Guns");
		
		Item ds = new Item(0,10,0,0,0,0,"Dragon's Scales");
		Item jha = new Item(0,150,1500,0,0,25,"armor","heavy","Juggernaught's Armor");
		Item xxea = new Item(0,70,1500,0,0,10,"armor","resist+","Phantom Armor");
		Item sgs = new Item(0,50,10000,0,0,1,"armor","weightless","Super Goblin Suit");
		
		Spell poison = new Spell(0,12,500,"Blight","none","poison");
		Spell ice = new Spell(20,4,100,"Frost Arrow","ice");
		
		loot.add(gobg);
		loot.add(sgs);
		loot.add(xxea);
		loot.add(pl);
		
		
		dragon1.getItem(dc);
		dragon1.getItem(ds);
		dragon1.equipWeapon(dc);
		dragon1.equipArmor(ds);
		
		bwp.getItem(jsod);
		bwp.getItem(xxea);
		bwp.equipWeapon(jsod);
		bwp.equipArmor(xxea);
		
		bwp.getSpell(poison);
		bwp.getSpell(ice);
		
		juggs.getItem(pl);
		juggs.getItem(jha);
		juggs.equipWeapon(pl);
		juggs.equipArmor(jha);
		
		gg.getItem(gobg);
		gg.getItem(sgs);
		gg.equipWeapon(gobg);
		gg.equipArmor(sgs);
		
		sgg.getItem(gobg);
		sgg.getItem(sgs);
		sgg.equipWeapon(gobg);
		sgg.equipArmor(sgs);
		
		allEnemies.add(dragon1);
		allEnemies.add(bwp);
		allEnemies.add(juggs);
		allEnemies.add(gg);
		allEnemies.add(sgg);
		
		if(player.bossCheck("Great Dragon"))
			enemies.add(dragon1);
		
		if(player.bossCheck("Elder Dragon"))
			enemies.add(juggs);
		
		if(player.bossCheck("Juggernaught") && player.bossCheck("Undead Dragon"))
			enemies.add(bwp);
		
		if(player.bossCheck("Blackwater Phantom")){
			enemies.add(gg);
		}
		
		if(player.bossCheck("Golden Goblin") && player.bossCheck("Ivory Dragon")){
			enemies.add(sgg);
		}
		
	}
	
	public void accessArena(Character p){
		
		this.setPlayer(p);
		Scanner input = new Scanner(System.in);
		String command = "";
		
		System.out.println("Welcome to the Arena!");
		while(!command.equalsIgnoreCase("Leave") || !command.equalsIgnoreCase("L")){
			System.out.println("[F]ight  [A]sk  [L]eave");
			command = input.nextLine();
			if(command.equalsIgnoreCase("Fight") || command.equalsIgnoreCase("F")){
				System.out.println("Who will you challenge?");
				printEnemies();
				command = input.nextLine();
				Character toFight = new Character(command,0,0,0,0,"");
				for(Character temp : enemies){
					if(toFight.getName().equals(temp.getName())){
						arenaBattle = new Battle(player, temp);
						boolean result = arenaBattle.doBattle();
						if(result){
							getLoot(temp);
							player.heal(player.getMaxHealth() - player.getHealth());
							enemies.remove(nameToCharacter(toFight.getName()));
							break;
						}
						else{
							//System.out.println("You have been defeated!");
							System.exit(0);
						}
					}
				}
			}
			else if(command.equalsIgnoreCase("Ask") || command.equalsIgnoreCase("A")){
				System.out.println("Who are you curious about?");
				printEnemies();
				command = input.nextLine();
				if(nameToCharacter(command) != null){
					Character boss = nameToCharacter(command);
					System.out.println("This fighter has registered stats at: ");
					System.out.println("Strength: "+boss.getStrength());
					System.out.println("Intelligence: "+boss.getIntelligence());
					System.out.println("Endurance: "+boss.getEndurance());
					System.out.println("Speed: "+boss.getSpeed());
				}
				
			}
			else if(command.equalsIgnoreCase("Leave") || command.equalsIgnoreCase("L")){
				break;
			}
		}
		
	}
	
	public void printEnemies(){
		
		if(!enemies.isEmpty()){
		
		for(Character temp : enemies){
			System.out.println(" o "+temp.getName());
		}
		
		}
		else
			System.out.println("There don't seem to be any fighters here yet.");
	}
	
	public Character nameToCharacter(String name){
		for(Character temp : enemies){
			if(temp.getName().equals(name))
				return temp;
		}
		return null;
	}
	
	public void getLoot(Character defeated){
		
		int money = (defeated.calcBST() * 5);
		//money = money - (money % 100);
		
		Item drop = null;
		
		if(defeated.getName().equals("Golden Goblin"))
			drop = findBossLoot("Goblin Guns");
		
		if(defeated.getName().equals("Super Golden Goblin"))
			drop = findBossLoot("Super Goblin Suit");
		
		if(defeated.getName().equals("Blackwater Phantom"))
			drop = findBossLoot("Phantom Armor");
		
		if(defeated.getName().equals("Golden Goblin"))
			drop = findBossLoot("Goblin Guns");
		
		if(defeated.getName().equals("Juggernaught"))
			drop = findBossLoot("Palladium Lance");
		

		if(money > 0){
			player.acquireMoney(money);
			System.out.println(money+" gold acquired!");
		}
		
		if(drop != null){
			player.getItem(drop);
			System.out.println(drop.getName()+" acquired!");
		}
		
	}
	
	public Item findBossLoot(String itemName){
		
		Item toFind = new Item(0,0,0,0,0,0,itemName);
		
		for(Item temp : loot){
			if(toFind.getName().equals(temp.getName()))
				return temp;
		}
		
		return null;
		
	}
	
	public Character getPlayer(){
		return player;
	}
	
	public void setPlayer(Character p){
		this.player = p;
	}

}
