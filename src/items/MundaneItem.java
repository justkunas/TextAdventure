package items;

public class MundaneItem extends Item{

	public MundaneItem(String name) {
		super(name);
	}
	
	public MundaneItem(String name, boolean qItem) {
		super(name, qItem);
	}

	@Override
	public int boostMeleeAttack(int int1) {
		return 0;
	}

	@Override
	public int boostRangedAttack(int int1) {
		return 0;
	}

	@Override
	public boolean playerUsesItem() {
		return false;
	}

}
