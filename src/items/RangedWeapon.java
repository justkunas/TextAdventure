package items;

import items.Item.weapon;
import player.PlayerQuiver;

public class RangedWeapon extends Item {
	private int rangeBoost;
	private Arrow ammoType;
	
	public RangedWeapon(String name, int attackBoost) {
		super(name, attackBoost, Item.weapon.RANGED);
		rangeBoost = attackBoost;
	}

	public RangedWeapon(String name, int attackBoost, boolean qItem) {
		super(name, attackBoost, qItem, Item.weapon.RANGED);
		rangeBoost = attackBoost;
	}
	
	public weapon getWeaponType(){
		return Item.weapon.RANGED;
	}

	@Override
	public int boostMeleeAttack(int int1) {
		return 0;
	}

	@Override
	public int boostRangedAttack(int int1) {
		return rangeBoost;
	}
	
	public Arrow getAmmoType(){
		return ammoType;
	}
	
	public void setAmmoType(Arrow item){
		ammoType = item;
	}
	
	public int getRangedBoost(){
		return rangeBoost;
	}
	
	public int getAmmountOfAmmo(){
		int quantity = 0;
		for(int i = 0; i < PlayerQuiver.getQuiverSize(); i++){
			if(PlayerQuiver.getItemAt(i) == ammoType){
				quantity++;
			}
		}
		return quantity;
	}

	@Override
	public boolean playerUsesItem() {
		return false;
	}
}
