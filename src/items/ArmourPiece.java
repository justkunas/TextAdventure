package items;

import items.Armour.ArmourSection;

public class ArmourPiece extends Item {
	
	public ArmourSection armourSection = ArmourSection.NULL;
	private ArmourSets armourSet  = null;
		
	public ArmourPiece(String name, ArmourSection section, ArmourSets set) {
		super(name, section, set);
		armourSection = section;
		armourSet = set;
	}
	
	public ArmourPiece(String name, ArmourSection section, ArmourSets set, boolean qItem) {
		super(name, section, set, qItem);
		armourSection = section;
		armourSet = set;
	}

	public ArmourSection getSection(){
		return armourSection;
	}
	
	public int getPieceProtection(){
		return (this.getSet().getProtection()/10)*this.getSection().getProtectionFactor();
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
	
	public ArmourSets getSet(){
		return armourSet;
	}
	
	public void setSection(ArmourSection section){
		armourSection = section;
	}
	
}
