package reference;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import player.PlayerInv;

public class Images {
	
	public static Image test,startZoneBG,mainMenuN,mainMenuG,mainMenuE,door,combatBG1,title,startGame,quit,Null;
	public static Image playerCombatG,playerCombatNG,playerCombatN,playerCombatNE,playerCombatE;
	public static Image main, attack, melee;
	public static Image weapon;
	public static Image Slime,Void;
	
	public static void initMobImages() throws SlickException{
		Slime = new Image("res/Mobs/Slime.png");
		Void = new Image("res/Mobs/Void.png");
	}
	
	public static void initImages() throws SlickException{
		test = new Image("res/Hammer.png");
		startZoneBG = new Image("res/Background/Stages/AlternateStartArea.png");
		door = new Image("res/Objects/Door.png");
		mainMenuN = new Image("res/Background/NeutralLarge.png");
		title = new Image("res/Buttons/Title.png");
		startGame = new Image("res/Buttons/StartGame.png");
		quit = new Image("res/Buttons/Quit.png");
		combatBG1 = new Image("res/Background/BaseLayers/DarkStonebricks.png");
		Null = new Image("res/Null.png");
		//startZoneBG = new Image("res/Background/Stages/StartingAreaExpanded.png");
		if(PlayerInv.getEquippedMelee() == null){
			weapon = new Image("res/Weapons/Fist.png");
		}else{
			weapon = new Image("res/Weapons/"+PlayerInv.getEquippedMelee().getName()+".png");
		}
	}
	
	public static void initPlayerCombatImages() throws SlickException{
		playerCombatG = new Image("res/Player/Good/PlayerRightG.png");
		playerCombatNG = new Image("res/Player/NeutralGood/PlayerRightNG.png");
		playerCombatN = new Image("res/Player/Neutral/PlayerRightN.png");
		playerCombatNE = new Image("res/Player/NeutralEvil/PlayerRightNE.png");
		playerCombatE = new Image("res/Player/Evil/PlayerRightE.png");
	}
	
	
	public static void initCombatButtons() throws SlickException{
		main = new Image("res/Buttons/Combat/Main.png");
		attack = new Image("res/Buttons/Combat/Attack.png");
		melee = new Image("res/Buttons/Combat/Melee.png");
		
		main.setName("Main Menu");
		attack.setName("Attack Menu");
		melee.setName("Melee Menu");
	}
	
}
