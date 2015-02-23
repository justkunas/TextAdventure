package player;

import items.Inventory;
import items.Item;

public class PlayerQuiver {
	
	private static Inventory quiver = new Inventory(1,16,32,64,128);
	private static int quiverTier = 1;
	
	public static int getQuiverTier(){
		return quiver.getTier();
	}
	
	public static void upgrade(int tier){
		quiver.upgradeInventory(tier);
		quiverTier = tier;
	}
	
	public static void upgrade(){
		quiver.upgradeInventory(++quiverTier);
	}
	
	public static int getQuiverSize(){
		return quiver.getTierCapacity(quiverTier);
	}
	
	public static int getQuiverSize(int Tier){
		return quiver.getTierCapacity(Tier);
	}
	
	public static void forceItemAt(int int1, Item item){
		quiver.setItem(int1, item);
	}
	
	public static void setItemAt(int int1, Item item){
		if(quiver.getItem(int1) == null){
			quiver.setItem(int1, item);
		}
	}
	
	public static void playerGathersArrow(Item item){
		for(int i = 0; i < getQuiverSize(); i++){
			if(getItemAt(i)==null){
				quiver.setItem(i, item);
				break;
			}else if(i == getQuiverSize()){
				System.out.println("No inventory size");
			}
		}
	}

	public static Item getItemAt(int int1){
		return quiver.getItem(int1);
	}
	
	public static void setItemNull(int int1){
		quiver.voidItem(int1);
	}
	
	public static void printEntireQuiver(){
		for(int i = 0; i < getQuiverSize(); i++){
			if(getItemAt(i) != null){
			System.out.println(getItemAt(i).getName());
			}else{
				System.out.println("--Empty--");
			}
		}
	}

}
