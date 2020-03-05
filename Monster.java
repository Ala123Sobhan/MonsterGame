package Project;

public class Monster extends Creature {
 
	private boolean isEnraged = false;
	private int enrageThreshold;
	
	
	public Monster(String name, String description, int hitPoints, int damage, int enrageThreshold) {
		super(name, description, hitPoints, damage);
		this.enrageThreshold = enrageThreshold;
		
	}
	public boolean canEnrage() {
		if(super.getHitPoints()< this.enrageThreshold)
		{
			return true;
		}
		else
			return false;
	}
	public void enrage() {
		if(!isEnraged)
		{
			super.setDamage(super.getDamage()*2);
			isEnraged= true;
			System.out.println(super.getName()+" has been enraged");
		}
	}
}
