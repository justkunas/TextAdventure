package items;

import reference.Core;

public class Potion extends Item {
	
	private static potionType type;
	private int incrementalFactor;
	
	public Potion(String name, potionType type, int incrementalFactor) {
		super(name,type,incrementalFactor);
		this.type = type;
		this.incrementalFactor = incrementalFactor;
	}
	
	public Potion(String name, potionType type, int incrementalFactor, boolean qItem) {
		super(name,type,incrementalFactor, qItem);
		this.type = type;
		this.incrementalFactor = incrementalFactor;
	}
	
	public void setPotionInfo(potionType type, int incrementalFactor){
		this.type = type;
		this.incrementalFactor = incrementalFactor;
	}
	
	public boolean playerUsesItem(){
		//System.out.println("Stage 1");
		//System.out.println(type);
		if(type == potionType.HEALTH){
			//System.out.println("Stage 2");
			if(Core.player.stats.getHealth() == Core.player.stats.getMaxHealth()){
				//System.out.println("Stage 3");
				return false;
			}else{
				//System.out.println("Stage 4");
				int i = Core.player.stats.getHealth();
				System.out.println(i);
				Core.player.stats.healthChange(incrementalFactor);
				System.out.println("Player health increased by: " + (Core.player.stats.getHealth() - i));
				System.out.println("Player health: " + Core.player.stats.getHealth() + "/" + Core.player.stats.getMaxHealth());
				return true;
			}
		}else if(type == potionType.MANA){
			if(Core.player.stats.magic.getMana() == Core.player.stats.magic.getMaxMana()){
				return false;
			}else{
				Core.player.stats.magic.manaChange(incrementalFactor);
				return true;
			}
		}
		return false;
	}

	@Override
	public int boostMeleeAttack(int int1) {
		return 0;
	}

	@Override
	public int boostRangedAttack(int int1) {
		return 0;
	}

}
