package items;

public class ArmourSets {
	
	private String name;
	private int protection;
	
	public ArmourSets(String name, int protection){
		this.setName(name);
		this.setProtection(protection);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}
	
}
