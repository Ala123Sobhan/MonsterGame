package Project;

import java.util.Scanner;

public class Battle {
	 private Player player;
	 private Monster monster;
	 char c;
	 
	 public Battle(Player p, Monster m){
		 player =p;
		 monster=m;
	 }
	 void run() {
		 
		 
		  while( monster.isAlive() && player.isAlive()) {//battle until one of them dies, so while two r alive - fight
			  System.out.println("Battle begins: "+player.getName()+" vs. "+monster.getName());
			  System.out.println("Player Turn: ");
			  System.out.println("Player hitPoints: "+player.getHitPoints()+"\t"+"Monster hitPoints: "+monster.getHitPoints());
		      System.out.println("What do you want: press attack (a) or heal (h)");
			  Scanner sc = new Scanner(System.in);
			  c = sc.next().charAt(0);  
			  
			  
		  if(c=='a')
		  {
			  player.attack(monster);
			  monster.takeDamage(player.getDamage());; //FIXME
			  if(!monster.isAlive())
			  {
				  System.out.println("The "+monster.getName()+" died.");
			  }
			 
			  
		  }
		  if(c=='h')
		  {
			  player.heal();
		  }
		 
		  System.out.println("Monster Turn: ");
		
		  if(monster.canEnrage())
		  {
			  monster.enrage();
			  monster.attack(player);
			  player.takeDamage(monster.getDamage());
			  if(!player.isAlive())
			  {
				  System.out.println(player.getName()+" died.");
				  System.out.println("GAME OVER!!");
				  break;                                          //Game over
			  }
			  
			 
		  }
		  else
		  {
			  player.takeDamage(monster.getDamage());
			  if(!player.isAlive())
			  {
				  System.out.println(player.getName()+" died.");
				  System.out.println("GAME OVER!!");
				  break;                                           //Game over
			  }
		  }
		  
		  }
	 }
	 
	 
	 
	 
	 
	 
	 
}
