package combatSystem;

import items.Item;
import items.Item.potionType;
import items.Potion;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import player.PlayerInv;
import player.PlayerQuiver;
import reference.Core;
import reference.Images;
import reference.Mobs;
import reference.Stages;
import stages.CombatStage;
import main.GameDisplay;
import mob.Mob;

public class CombatInterface {

	public static enum allStages {
		MAIN, ATTACK, MELEE, MAGIC, ITEM, NULL
	};

	private static Random rand = new Random();
	public static Mob opponent = Mobs.jerry;
	private static Input input;
	public static allStages stage = allStages.MAIN;
	public static int playerPreHealth;
	public static int playerPostHealth;
	public static int mobPreHealth;
	public static int mobPostHealth;

	public static boolean itemUsed() {
		return false;
	}

	public static void gotoMainMenu() throws SlickException {
		CombatStage.Menu = CombatStage.Main;
		stage = allStages.MAIN;
	}

	public static void gotoAttackMenu(){
		CombatStage.Menu = CombatStage.Attack;
		stage = allStages.ATTACK;
	}

	public static void gotoMeleeMenu(){
		CombatStage.Menu = CombatStage.Melee;
		stage = allStages.MELEE;
	}
	
	public static void mobImmune() {

	}
	
	public static void rangedAttack() {
	}

	public static void mobAttacks() {
		CombatSystem.mobAttacksPlayer(opponent);
	}

	public static boolean isMobDead() {
		if (opponent.getMobHealth() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isPlayerDead() {
		if (Core.player.stats.getHealth() == 0) {
			GameDisplay.mobDeath(opponent);
			return true;
		}
		return false;
	}
	
	public static boolean isPlayerFaster(){
		return !(opponent.getSpeed() > Core.player.stats.getSpeed());
	}
	
	public static boolean flee() {
		int i = rand.nextInt(9);
		if (!isPlayerFaster() || i == 0) {
			System.out.println("You failed to escape!");
			return false;
		}
		System.out.println("You succesfully escaped.");
		return true;
	}

	public static void initiateCombat(Mob mob, GameContainer gameCont, StateBasedGame sbg)
			throws SlickException {
		input = gameCont.getInput();
		opponent = mob;
		GameDisplay.encounter(opponent);
		CombatStage.setOpponent(mob);
		sbg.enterState(Stages.COMBAT);
	}
}
