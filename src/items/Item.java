package items;

import items.Armour.ArmourSection;

public abstract class Item {
	private potionType type;
	private itemType iType;
	@SuppressWarnings("unused")
	private int incrementalFactor;
	private String itemName;
	@SuppressWarnings("unused")
	private int attackBoost;
	private static Item equippedMeleeItem;
	private Item equippedRangedItem;
	private boolean questItem;
	public static enum potionType{HEALTH,MANA};
	protected static enum weapon{MELEE,RANGED,ARROW}
	public static enum itemType{HELM,CHEST,LEGS,BOOTS,ARROW,MELEE_WEAPON,RANGED_WEAPON,MUNDANE,POTION};
	
	public boolean equals(Item obj){
		if(itemName.equals(obj.getName())&&iType.equals(obj.getItemType())&&this.isQuestItem()==obj.isQuestItem()){
			return true;
		}else{
			return false;
		}
	}
	
	//Constructor's for armour
	public Item(String name, ArmourSection section, ArmourSets set){
		itemName = name;
		switch(section){
		case HELMET:
			iType = itemType.HELM;
			break;
		case CHESTPLATE:
			iType = itemType.CHEST;
			break;
		case LEGGINGS:
			iType = itemType.LEGS;
			break;
		case BOOTS:
			iType = itemType.BOOTS;
			break;
		}
	}
	
	public Item(String name, ArmourSection section, ArmourSets set, boolean qItem){
		itemName = name;
		questItem = qItem;
		switch(section){
		case HELMET:
			iType = itemType.HELM;
			break;
		case CHESTPLATE:
			iType = itemType.CHEST;
			break;
		case LEGGINGS:
			iType = itemType.LEGS;
			break;
		case BOOTS:
			iType = itemType.BOOTS;
			break;
		}
	}
	
	//Constructors for potions
	public Item(String name, potionType type, int incrementalFactor){
		itemName = name;
		this.type = type;
		this.incrementalFactor = incrementalFactor;
		iType = itemType.POTION;
	}
	
	public Item(String name, potionType type, int incrementalFactor, boolean qItem){
		itemName = name;
		this.type = type;
		this.incrementalFactor = incrementalFactor; 
		questItem = qItem;
		iType = itemType.POTION;
	}
	
	//Constructors for weapons
	public Item(String name,int attackBoost, weapon weaponType){
		itemName = name;
		this.attackBoost = attackBoost;
		switch(weaponType){
		case MELEE:
			iType = itemType.MELEE_WEAPON;
			break;
		case RANGED:
			iType = itemType.RANGED_WEAPON;
			break;
		case ARROW:
			iType = itemType.ARROW;
			break;
		}
	}
	
	public Item(String name,int attackBoost, boolean qItem, weapon weaponType){
		itemName = name;
		this.attackBoost = attackBoost;
		questItem = qItem;
		switch(weaponType){
		case MELEE:
			iType = itemType.MELEE_WEAPON;
			break;
		case RANGED:
			iType = itemType.RANGED_WEAPON;
			break;
		case ARROW:
			iType = itemType.ARROW;
			break;
		}
	}
	
	//Constructor for Mundane Items
	public Item(String name){
		itemName = name;
		iType = itemType.MUNDANE;
	}
	
	//Constructor for quest items
	public Item(String name, boolean qItem){
		itemName = name;
		questItem = qItem;
		iType = itemType.MUNDANE;
	}
	
	public abstract int boostMeleeAttack(int int1);
	
	public abstract int boostRangedAttack(int int1);
	
	public abstract boolean playerUsesItem();

	public String getName(){
		return itemName;
	}
	
	public itemType getItemType(){
		return iType;
	}
	
	public boolean isQuestItem(){
		return questItem;
	}
	
	public void equipMeleeItem(Item item){
		equippedMeleeItem = item;
	}
	
	public static Item getMeleeEquipped(){
		return equippedMeleeItem;
	}
	
	public boolean isMeleeItemEquipped(){
		if(equippedMeleeItem != null){
			return true;
		}
		return false;
	}
	
	public boolean isMeleeItemEquipped(Item item){
		if(equippedMeleeItem == item){
			return true;
		}
		return false;
	}
	
	public void equipRangedItem(Item item){
		equippedRangedItem = item;
	}
	
	public Item getRangedEquipped(){
		return equippedRangedItem;
	}
	
	public boolean isRangedItemEquipped(){
		if(equippedRangedItem != null){
			return true;
		}
		return false;
	}
	
	public boolean isRangedItemEquipped(Item item){
		if(equippedRangedItem == item){
			return true;
		}
		return false;
	}
	
	public potionType getPotionType(){
		return type;
	}

}
