package items;

import items.Item.weapon;

public class Arrow extends Item {
	private int rangeBoost;
	private String name;
	
	public Arrow(String name, int attackBoost) {
		super(name, attackBoost, Item.weapon.ARROW);
		rangeBoost = attackBoost;
		this.name = name;
	}

	public Arrow(String name, int attackBoost, boolean qItem) {
		super(name, attackBoost, qItem, Item.weapon.ARROW);
		rangeBoost = attackBoost;
		this.name = name;
	}
	
	public int getRangedBoost(){
		return rangeBoost;
	}

	@Override
	public int boostMeleeAttack(int int1) {
		return 0;
	}

	@Override
	public int boostRangedAttack(int int1) {
		return int1;
	}

	@Override
	public boolean playerUsesItem() {
		return false;
	}

}
