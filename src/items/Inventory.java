package items;


public class Inventory {
	
	private Item[] contents;
	private Item[] upgrade;
	private int tier = 1;
	private int tierOneCapacity;
	private int tierTwoCapacity;
	private int tierThreeCapacity;
	private int tierFourCapacity;
	private int tierFiveCapacity;
	
	public Inventory(int tier1){
		contents = new Item[tier1];
		tierOneCapacity = tier1;
	}
	
	public Inventory(int tier1, int tier2){
		contents = new Item[tier1];
		tierOneCapacity = tier1;
		tierTwoCapacity = tier2;
	}

	public Inventory(int tier1, int tier2, int tier3){
		contents = new Item[tier1];
		tierOneCapacity = tier1;
		tierTwoCapacity = tier2;
		tierThreeCapacity = tier3;
	}

	public Inventory(int tier1, int tier2, int tier3, int tier4){
		contents = new Item[tier1];
		tierOneCapacity = tier1;
		tierTwoCapacity = tier2;
		tierThreeCapacity = tier3;
		tierFourCapacity = tier4;
	}

	public Inventory(int tier1, int tier2, int tier3, int tier4, int tier5){
		contents = new Item[tier1];
		tierOneCapacity = tier1;
		tierTwoCapacity = tier2;
		tierThreeCapacity = tier3;
		tierFourCapacity = tier4;
		tierFiveCapacity = tier5;
		
		
	}
	
	public int getTierCapacity(int tier){
		switch(tier){
			case 1:
				return tierOneCapacity;
			case 2:
				return tierTwoCapacity;
			case 3:
				return tierThreeCapacity;
			case 4:
				return tierFourCapacity;
			case 5:
				return tierFiveCapacity;
			default:
				return 0;
		}
	}
	
	public Item getItem(int int1){
		return contents[int1];
		
	}
	
	public void setItem(int int1, Item item){
		contents[int1] = item;
	}
	
	public void voidItem(int int1){
		contents[int1] = null;
	}
	
	public int getTier(){
		return tier;
	}
	
	public void upgradeInventory(int tier){
		upgrade = new Item[getTierCapacity(tier-1)];
		/*for(int i = 0; i < contents.length; i++){
			upgrade[i] = contents[i];
		}*/
		
		this.tier = tier;
		contents = new Item[getTierCapacity(tier)];
		
		/*
		for(int i = 0; i < upgrade.length; i++){
			contents[i] = upgrade[i];
		}*/
	}
	
}
