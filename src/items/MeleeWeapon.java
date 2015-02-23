package items;

import combatSystem.CombatInterface;

import player.PlayerInv;

public class MeleeWeapon extends Item{
	private int meleeBooster;

	public MeleeWeapon(String name,int attackBoost) {
		super(name,attackBoost, Item.weapon.MELEE);
		meleeBooster = attackBoost;
	}
	
	public MeleeWeapon(String name,int attackBoost, boolean qItem) {
		super(name,attackBoost, qItem, Item.weapon.MELEE);
		meleeBooster = attackBoost;
	}

	@Override
	public int boostMeleeAttack(int int1) {
		return int1;
	}
	
	public int getMeleeBoost(){
		return meleeBooster;
	}

	@Override
	public int boostRangedAttack(int int1) {
		return 0;
	}

	@Override
	public boolean playerUsesItem() {
		if(PlayerInv.equipMeleeItem(this)){
			return true;
		}else{
			return false;
		}
	}

}
