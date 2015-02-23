package reference;

import items.*;
import items.Armour.ArmourSection;

public class ArmourObjects {
	
	//Total protection value is recommended to be divisible by 10
	public static ArmourSets set1 = new ArmourSets("Set 1", 100);
	public static ArmourSets set2 = new ArmourSets("Set 2", 30);
	public static ArmourSets debugSet = new ArmourSets("Debug Set",Integer.MAX_VALUE-Core.player.stats.getDefence());
	
	public static ArmourPiece helm = new ArmourPiece("Leather Helemt", ArmourSection.HELMET, set1);
	public static ArmourPiece chest = new ArmourPiece("Leather Chestpiece", ArmourSection.CHESTPLATE, set1);
	public static ArmourPiece legs = new ArmourPiece("Leather Leggings", ArmourSection.LEGGINGS, set1);
	public static ArmourPiece boots = new ArmourPiece("Leather Boots", ArmourSection.BOOTS, set1);
	
	public static ArmourPiece debugHelm = new ArmourPiece("Debug Helemt", ArmourSection.HELMET, debugSet);
	public static ArmourPiece debugChest = new ArmourPiece("Debug Chestpiece", ArmourSection.CHESTPLATE, debugSet);
	public static ArmourPiece debugLegs = new ArmourPiece("Debug Leggings", ArmourSection.LEGGINGS, debugSet);
	public static ArmourPiece debugBoots = new ArmourPiece("Debug Boots", ArmourSection.BOOTS, debugSet);
}
