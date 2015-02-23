package player;

import reference.Core;
import items.*;
import items.Item.itemType;

public class PlayerInv {
	
	private static Inventory inv = new Inventory(8,16,24,32);
	private static int invTier = 1;
	
	private static MeleeWeapon meleeWeapon;
	private static RangedWeapon rangedWeapon;
	
	private static ArmourPiece helmet;
	private static ArmourPiece chestplate;
	private static ArmourPiece leggings;
	private static ArmourPiece boots;
	
	private static ArmourSets helmetSet;
	private static ArmourSets chestplateSet;
	private static ArmourSets leggingsSet;
	private static ArmourSets bootSet;
	
	public static void initilizeArmour(){
		if(getEquippedHelmet() != null){
			helmetSet = PlayerInv.getEquippedHelmet().getSet();
		}
		if(getEquippedChestplate() != null){
			chestplateSet = PlayerInv.getEquippedChestplate().getSet();
		}
		if(getEquippedLeggings() != null){
			leggingsSet = PlayerInv.getEquippedLeggings().getSet();
		}
		if(getEquippedBoots() != null){
			bootSet = PlayerInv.getEquippedBoots().getSet();
		}
	}
	
	public static void forceItemAt(int int1, Item item){
		inv.setItem(int1, item);
	}
	
	public static void setItemAt(int int1, Item item){
		if(inv.getItem(int1) == null){
			inv.setItem(int1, item);
		}
	}
	
	public static void playerGathersItem(Item item){
		if(item.getItemType() == itemType.ARROW){
			PlayerQuiver.playerGathersArrow(item);
		}else{
			for(int i = 0; i < getInvSize(); i++){
				if(getItemAt(i)==null){
					inv.setItem(i, item);
					break;
				}else if(i == getInvSize()){
					System.out.println("No inventory size");
				}
			}
		}
	}
	
	public static int getInvTier(){
		return inv.getTier();
	}
	
	public static void upgrade(int tier){
		inv.upgradeInventory(tier);
		invTier = tier;
	}
	
	public static void upgrade(){
		inv.upgradeInventory(++invTier);
	}
	
	public static int getInvSize(){
		return inv.getTierCapacity(invTier);
	}
	
	public static int getInvSize(int Tier){
		return inv.getTierCapacity(Tier);
	}
	
	public static MeleeWeapon getEquippedMelee(){
		return meleeWeapon;
	}	
	
	public static boolean equipMeleeItem(MeleeWeapon item){
		if(meleeWeapon == null){
			meleeWeapon = item;
			return true;
		}else{
			System.out.println("Please unquip " + meleeWeapon.getName() + " before equipping another item.");
			return false;
		}
	}
	
	public static RangedWeapon getEquippedRanged(){
		return rangedWeapon;
	}	
	
	public static void equipRangedItem(RangedWeapon item){
		if(rangedWeapon == null){
			rangedWeapon = item;
		}else{
			System.out.println("Please unquip " + rangedWeapon.getName() + " before equipping another item.");
		}
	}
	
	public static Item getItemAt(int int1){
		return inv.getItem(int1);
	}
	
	public static void setItemNull(int int1){
		inv.voidItem(int1);
	}
	
	public static void printEntireInventory(){
		for(int i = 0; i < getInvSize(); i++){
			if(getItemAt(i) != null){
				System.out.println(getItemAt(i).getName());
			}else{
				System.out.println("--Empty--");
			}
		}
	}
	
	public static boolean playerUsesItem(Item item){
		return item.playerUsesItem();
	}
	
	public static boolean checkIfEmpty(){
		for(int i = 0; i < getInvSize(); i++){
			if(getItemAt(i) != null){
				return false;
			}else if(i == getInvSize()-1){
				return true;
			}
		}
		return false;
	}
	
	public static ArmourPiece getEquippedHelmet(){
		return helmet;
	}	
	
	public static boolean equipHelmet(ArmourPiece item){
		if(helmet == null){
			helmet = item;
			initilizeArmour();
			return true;
		}else{
			System.out.println("Please unquip " + helmet.getName() + " before equipping another item.");
			return false;
		}
	}

	public static ArmourPiece getEquippedChestplate(){
		return chestplate;
	}	
	
	public static boolean equipChestplate(ArmourPiece item){
		if(chestplate == null){
			chestplate = item;
			initilizeArmour();
			return true;
		}else{
			System.out.println("Please unquip " + chestplate.getName() + " before equipping another item.");
			return false;
		}
	}

	public static ArmourPiece getEquippedLeggings(){
		return leggings;
	}	
	
	public static boolean equipLeggings(ArmourPiece item){
		if(leggings == null){
			leggings = item;
			initilizeArmour();
			return true;
		}else{
			System.out.println("Please unquip " + leggings.getName() + " before equipping another item.");
			return false;
		}
		
	}

	public static ArmourPiece getEquippedBoots(){
		return boots;
	}	
	
	public static boolean equipBoots(ArmourPiece item){
		if(boots == null){
			boots = item;
			initilizeArmour();
			return true;
		}else{
			System.out.println("Please unquip " + boots.getName() + " before equipping another item.");
			return false;
		}
	}
	
	public static boolean fullArmourSet(){
		if(!(helmet == null || chestplate == null || leggings == null || boots == null) && (helmetSet == chestplateSet && chestplateSet == leggingsSet && leggingsSet == bootSet)){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static int getArmourProtection(){
		int armourProtection = 0;
		
		if(helmet != null){
			armourProtection += helmet.getPieceProtection();
		}
		if(chestplate != null){
			armourProtection += chestplate.getPieceProtection();
		}
		if(leggings != null){
			armourProtection += leggings.getPieceProtection();
		}
		if(boots != null){
			armourProtection += boots.getPieceProtection();
		}
		return armourProtection;
	}
	
	public static int getTotalDefence(){
		if(PlayerInv.fullArmourSet()){
			return Core.player.stats.getDefence() + PlayerInv.getEquippedChestplate().getSet().getProtection();
		}else{
			return Core.player.stats.getDefence() + PlayerInv.getArmourProtection();
		}
	}
}
