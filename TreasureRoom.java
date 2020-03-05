package Project;

public class TreasureRoom extends Room {
	
	private String treasure;

	public TreasureRoom( String description, Monster monster, String t) {
		super( description, monster);    //not what given roomIndex
		treasure = t;                           
	}
	@Override
	public void enter(Player player) {
		
		if(super.getMonster().isAlive())
		{     
			super.enter(player);
			if(player.isAlive())
			{
				
				System.out.println("You explored the room and found the hidden treasure!");
			}
		}
	}
	
	

}
