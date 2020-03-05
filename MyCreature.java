package Project;

public class MyCreature extends Creature{
	
	public MyCreature() {
		super();
	}

	public MyCreature(String name, String description, int hitPoints, int damage) {
		super(name, description, hitPoints, damage);
		
	}
	
	@Override
	public void attack(Creature creature) {
		System.out.println(super.getName()+" attacks "+creature.getName()+",dealing "+super.getDamage()+" damage");
		
	}
	@Override
	public void takeDamage(int damage) {
		if((super.getHitPoints()-damage)>0)
		{
		       super.setHitPoints(super.getHitPoints()-damage);
		}
		else
		    super.setHitPoints(0);
	}
	@Override
	public boolean isAlive()
	{
		if(super.getHitPoints()<0)
			return false;
		else
			return true;
	}
	@Override
	public String toString() {
		return String.format("name %15s, description %20s, hitPoints %03d, damage %02d",super.getName(),super.getDescription(),super.getHitPoints(),super.getDamage());
	}
	
	

}
