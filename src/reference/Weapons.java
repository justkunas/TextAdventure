package reference;

import items.Arrow;
import items.MeleeWeapon;
import items.RangedWeapon;

public class Weapons {
	
	//default player Strength 25-30
	public static MeleeWeapon largeClever = new MeleeWeapon("Large Cleaver", 5);
	public static RangedWeapon woodenBow = new RangedWeapon("Wooden Bow", 0);
	public static Arrow basicArrow = new Arrow("Wooden Arrow",1);
	public static Arrow steelArrow = new Arrow("Steel Arrow",6);
	public static MeleeWeapon basicSword = new MeleeWeapon("BasicSword",1);
	public static MeleeWeapon steelSword = new MeleeWeapon("Steel Sword", 6);
	
	
	//DEBUG Weapons
	public static MeleeWeapon maxSwordOfDebugging = new MeleeWeapon("Max Debug Sword",Integer.MAX_VALUE-Core.player.stats.getStrength());
	public static RangedWeapon maxBowOfDebugging = new RangedWeapon(" Max Debug Bow", Integer.MAX_VALUE-Core.player.stats.getStrength());
	public static Arrow maxArrowOfDebugging = new Arrow("Max Debug Arrow", Integer.MAX_VALUE-Core.player.stats.getStrength());
	
	public static MeleeWeapon minSwordOfDebugging = new MeleeWeapon("Min Debug Sword",0);
	public static RangedWeapon minBowOfDebugging = new RangedWeapon("Min Debug Bow", 0);
	public static Arrow minArrowOfDebugging = new Arrow("Min Debug Arrow", 0);
}
