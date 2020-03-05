package Project;

public class Room {
	 
	
	 private int roomIndex;
	 private String description;
	 private Monster monster;
	 private static int i=0;
	 
	 public Room( String description, Monster monster) {
		 this.roomIndex= i++;
		 this.description= description;
		 this.monster= monster;
	 }
	 public int getRoomIndex() {
			return roomIndex;
		}
		
	public String getDescription() {
			return description;
		}
		
	public Monster getMonster() {
			return monster;
		}
	 public boolean isComplete() {
		 if(!monster.isAlive())   //if the monster die
			 return true;
		 else
			 return false;
	 }
    public String toString() {
    	return String.format("Room index %2d, description %20s, monster name %20s", roomIndex,description,monster.getName());
    }
    public void enter(Player player) {
    	System.out.println(player.getName()+ " This Room is "+this.description+", and has "+monster.getName());
    	 if(this.monster.isAlive()) {    
    	                              //FIXME
    	   Battle b = new Battle(player, monster);
    	   b.run();
    }
    	 else {
    		 System.out.println(monster.getName()+" in room "+(roomIndex+1)+" is dead");
    	 }
    }
}
