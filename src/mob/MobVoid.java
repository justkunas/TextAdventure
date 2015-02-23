package mob;

import java.util.Random;

import combatSystem.AttackTypes;

public class MobVoid extends Mob {

	//private static int 1 = player.PlayerStats.getLevel();
	private static Random rand = new Random();
	private static AttackTypes[] immunities = {AttackTypes.WATER_MAGIC, AttackTypes.RANGE, AttackTypes.LIGHT_MEELEE};
	public static final String MOB_TYPE = "Void";
	
	public MobVoid(){
		super((80 + (1 * rand.nextInt(6))), 0, (40 + rand.nextInt(11)), (40 + rand.nextInt(6)), (1 + rand.nextInt(6)), MOB_TYPE);
	}

	@Override
	public AttackTypes[] getMobImmunities() {
		return immunities;
	}
	
	public AttackTypes getMobImmunity(int i){
		return immunities[i];
	}

	@Override
	public boolean isMobImmune(AttackTypes attack) {
		for(int i = 0; i < immunities.length; i++){
			if (attack == immunities[i]){
				return true;
			}else if(i == immunities.length){
				return false;
			}
		}
		return false;
	}

	@Override
	public AttackTypes[] getMobAttackTypes() {
		AttackTypes[] mobAttackTypes = {AttackTypes.LIGHT_MEELEE,AttackTypes.HEAVY_MEELEE};
		return mobAttackTypes;
	}
}
