package Project;

public class Creature {
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	private Room room;
	
	public Creature() {
		name = "";
		description= "";
		hitPoints =0;
		damage =0;
	}
	
	public Creature(String name, String description, int hitPoints, int damage) {
		this.name = name;
		this.description= description;
		this.hitPoints= hitPoints;
		this.damage = damage;
		room= null;
		
	}

	public String getName() {
		return name;
	}

	

	public String getDescription() {
		return description;
	}

	

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public void attack(Creature creature) {
		System.out.println(this.name+" attacks "+creature.name+",dealing "+this.damage+" damage");
		
	}
	public void takeDamage(int damage) {
		if((hitPoints-damage)>0)
		{
			hitPoints= hitPoints-damage;
		}
		else
			hitPoints = 0;
	}
	public boolean isAlive()
	{
		if(hitPoints>0)
			return true;
		else
			return false;
	}
	public String toString() {
		return String.format("name %15s, description %20s, hitPoints %03d, damage %02d",name,description,hitPoints,damage);
	}

}
