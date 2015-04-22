
public class Battle {
	
	private Character player, enemy;
	
	public Battle(Character p, Character e){
		this.player = p;
		this.enemy = e;
	}
	
	
	public void playerCommand(String command){
		
		boolean sleep = false;
		boolean poison = false;
		
		if(player.getStatus().equals("sleep"))
			sleep = true;
		if(player.getStatus().equals("poison"))
			poison = true;
			
		if(sleep){
			if(player.RNG() >= 66){
				player.normalize();
				System.out.println(player.getName()+" woke up!\n");
			}
			else
			System.out.println(player.getName()+" is in a deep sleep!\n");
		}
		else{
		
		command = player.issueCommand();
		boolean success = player.execute(command, enemy);
		
		while(success == false){
			command = player.issueCommand();
			success = player.execute(command, enemy);
		}
		
		if(poison){
			if(player.RNG() >= 95){
				player.normalize();
				System.out.println(player.getName()+"'s poison dissipated!\n");
			}
			else{
			int damage = player.getMaxHealth()/20;
			
			if(damage > player.getHealth())
				damage = player.getHealth();
			
			System.out.println(player.getName()+" took "+damage+" damage from the the poison!\n");
			player.takeDamage(damage);
			}
		}
			
		}
		
		
		player.printStatus();
		enemy.printStatus();
		
	}
	
	public void enemyCommand(ComplexCMD ai){
		
		boolean sleep = false;
		boolean poison = false;
		
		if(enemy.getStatus().equals("sleep"))
			sleep = true;
		if(enemy.getStatus().equals("poison"))
			poison = true;
			
		if(sleep){
			if(enemy.RNG() >= 66){
				enemy.normalize();
				System.out.println(enemy.getName()+" woke up!\n");
			}
			else
				System.out.println(enemy.getName()+" is in a deep sleep!\n");
			}
			else{
			
		
				ai = enemy.computeCommand();
				enemy.execute(ai, player);
				
				if(poison){
					if(enemy.RNG() >= 95){
						enemy.normalize();
						System.out.println(enemy.getName()+"'s poison dissipated!\n");
					}
					else{
					int damage = enemy.getMaxHealth()/20;
					
					if(damage > enemy.getHealth())
						damage = enemy.getHealth();
					
					System.out.println(enemy.getName()+" took "+damage+" damage from the the poison!\n");
					enemy.takeDamage(damage);
					}
				}
			}
		
		player.printStatus();
		enemy.printStatus();
		
	}
	

	
	public boolean doBattle(){	
		
		String command = "";
		ComplexCMD ai = new ComplexCMD();
		
		System.out.println("The "+enemy.getName()+" approaches!\n\n");
		System.out.println("Begin Battle!\n\n");
		
		int speedCheckPlayer = player.getSpeed();
		int speedCheckEnemy = enemy.getSpeed();
		
		if(player.checkFlagsArmor() != null && player.checkFlagsArmor().equals("heavy"))
			speedCheckPlayer = speedCheckPlayer/2;
		if(enemy.checkFlagsArmor() != null && enemy.checkFlagsArmor().equals("heavy"))
			speedCheckEnemy = speedCheckEnemy/2;
	
		while(player.getHealth() != 0 && enemy.getHealth() != 0){
			
			int turns;
			
			if(speedCheckPlayer >= speedCheckEnemy){
				
				turns = speedCheckPlayer/speedCheckEnemy;
				if(turns > 4) //maximum 4 commands per turn cycle
					turns = 4;
				
				for(int i = turns; i > 0; --i){
					playerCommand(command);
					if(player.getHealth() == 0 || enemy.getHealth() == 0)
						break;
				}
				if(player.getHealth() == 0 || enemy.getHealth() == 0)
					continue;
				
				enemyCommand(ai);
				
			}
			else{
				
				turns = speedCheckEnemy/speedCheckPlayer;
				if(turns > 4) //maximum 4 commands per turn cycle
					turns = 4;
				
				for(int i = turns; i > 0; --i){
					enemyCommand(ai);
					if(player.getHealth() == 0 || enemy.getHealth() == 0)
						break;
				}
				if(player.getHealth() == 0 || enemy.getHealth() == 0)
					continue;
				
				playerCommand(command);
				
			}
		}
		if(enemy.getHealth() == 0){
			System.out.println("You have won the battle! Congratulations!");
			player.healAll();
			player.addBossBeaten(enemy);
			return true;
		}
		else if(player.getHealth() == 0){
			System.out.println("You have been defeated!");
			return false;
		}
		else{
			//Should never happen.
			return false;
		}
	
}
}
