package combatSystem;

import reference.Core;
import mob.Mob;

import java.util.Random;

import player.PlayerInv;
import player.PlayerQuiver;

public class CombatSystem{

	private static Random rand = new Random();
	
	public static int getPlayerVsMobMeleeDamage(Mob mob){
		return mob.getDefence() - Core.player.stats.getMeleeAttackDamage();
	}
	
	public static int getPlayerVsMobRangedDamage(Mob mob){
		return mob.getDefence() - Core.player.stats.getRangedAttackDamage();
	}
	
	public static void playerHeavyMeleeMob(Mob mob){
		mob.changeMobHealth(getPlayerVsMobMeleeDamage(mob));
	}
	
	public static void playerLightMeleeMob(Mob mob){
		mob.changeMobHealth(getPlayerVsMobMeleeDamage(mob)/2);
	}
	
	public static void playerRangesMob(Mob mob){
		mob.changeMobHealth(getPlayerVsMobRangedDamage(mob));
		for(int i = PlayerQuiver.getQuiverSize()-1; i >= 0; i--){
			if(PlayerQuiver.getItemAt(i) == PlayerInv.getEquippedRanged().getAmmoType()){
				PlayerQuiver.setItemNull(i);
				break;
			}
		}
	}
	
	public static int mobAttacksPlayer(Mob mob){
		int damage = 0;
		if(((mob.getStrength() + rand.nextInt(2))-PlayerInv.getTotalDefence()) > 0){
			damage = -((mob.getStrength() + rand.nextInt(2))-PlayerInv.getTotalDefence());
		}
		Core.player.stats.healthChange(damage);
		return damage;
	}

}
