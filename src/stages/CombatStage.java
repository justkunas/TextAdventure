package stages;

import java.awt.Font;

import mob.Mob;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import player.PlayerInv;
import combatSystem.CombatInterface;
import combatSystem.CombatInterface.allStages;
import combatSystem.CombatSystem;
import reference.Core;
import reference.Images;
import reference.Mobs;
import reference.Stages;

public class CombatStage extends BasicGameState{
	
	Font newFont;
	TrueTypeFont font;
	
	public static Animation Melee,Attack,Main,Menu,WeaponAni,Void,Weapon;
	
	private String mouse = "OutofBounds";
	private static String playerHealth;
	private static String mobHealth;
	
	private static int xpos;	
	private static int ypos;
	private static int sleep;
	private static int sleepIt;
	
	private static float playerX = 100;
	private static float playerY = 350;
	private static float mobX = 1150;
	private static float mobY = 350;
	private static float deltaMobHealth = 0;
	private static float deltaPlayerHealth = 0;
	private static float showDelta = 0;
	private static float weaponRot = 0;
	
	private static Image opponent;
	
	private static allStages menuStage = allStages.MAIN;
	
	private static boolean playerAnimateP1 = false;
	private static boolean playerAnimateP2 = false;
	private static boolean playerAnimateP3 = false;
	
	private static boolean canEntitiesAttack = false;
	
	private static boolean mobAnimateP1 = false;
	private static boolean mobAnimateP2 = false;
	private static boolean mobAnimateP3 = false;
	
	
	public CombatStage(int stage){
		
	}
	
	private static void updatePlyrHealth(){
		playerHealth = Core.player.stats.getHealth()+"/"+Core.player.stats.getMaxHealth();
	}
	
	private static void updateMobHealth(){
		mobHealth = CombatInterface.opponent.getMobHealth()+"/"+CombatInterface.opponent.getMaxHealth();
	}
	
	private static void playerAnimation(int delta, StateBasedGame sbg){
		if(playerAnimateP1){
			canEntitiesAttack = false;
			if(playerX<1075){
				showDelta = delta;
				sleep += delta;
				if(sleep >= 0.1){
					playerX += 3;
					sleep = 0;
					sleepIt++;
				}
			}else{
				playerAnimateP1 = false;
				playerAnimateP2 = true;
			}
		}
		
		
		if(playerAnimateP2){
			sleep = 0;
			WeaponAni = Weapon;
			if(weaponRot<180){	
				WeaponAni.getCurrentFrame().setCenterOfRotation(0, 32);
				sleep += delta;
				if(sleep>=0.1){
					WeaponAni.getCurrentFrame().setRotation(weaponRot);
					weaponRot+=3;
					sleep = 0;
				}
			}else{
				deltaMobHealth = CombatInterface.opponent.getMobHealth();
				CombatSystem.playerHeavyMeleeMob(CombatInterface.opponent);
				deltaMobHealth = CombatInterface.opponent.getMobHealth() - deltaMobHealth;
				updateMobHealth();
				
				WeaponAni=Void;
				weaponRot=0;
				
				playerAnimateP2 = false;
				playerAnimateP3 = true;
			}
		}
		
		if(playerAnimateP3){
			if(playerX>100){
				showDelta = delta;
				sleep += delta;
				if(sleep >= 0.1){
					playerX -= 3;
					sleep = 0;
					sleepIt++;
				}
			}else{
				playerAnimateP3 = false;
				canEntitiesAttack = true;
			}
		}
		
		if(CombatInterface.isMobDead()){
			sbg.enterState(Stages.PLAY);
		}else if(CombatInterface.isPlayerDead()){
			sbg.enterState(Stages.MAIN_MENU);
		}else if(!canEntitiesAttack){
		}else{
			if(CombatInterface.isPlayerFaster()){
				mobAnimateP1 = true;
			}else{
				canEntitiesAttack = false;
			}
		}
	}

	private static void mobAnimation (int delta, StateBasedGame sbg){
		if(mobAnimateP1){
			canEntitiesAttack = false;
			if(mobX>100){
				showDelta = delta;
				sleep += delta;
				if(sleep >= 0.1){
					mobX -= 3;
					sleep = 0;
					sleepIt++;
				}
			}else{
				mobAnimateP1 = false;
				mobAnimateP2 = true;
				sleep = 0;
			}
		}
		
		
		if(mobAnimateP2){
			sleep += delta;
			if(sleep>=500){
				sleep = 0;
				
				deltaPlayerHealth = Core.player.stats.getHealth();
				CombatSystem.mobAttacksPlayer(CombatInterface.opponent);
				deltaPlayerHealth = Core.player.stats.getHealth() - deltaPlayerHealth;
				updatePlyrHealth();
				
				mobAnimateP2 = false;
				mobAnimateP3 = true;

				sleep = 0;
			}
		}
		
		if(mobAnimateP3){
			if(mobX<1150){
				showDelta = delta;
				sleep += delta;
				if(sleep >= 0.1){
					mobX += 3;
					sleep = 0;
					sleepIt++;
				}
			}else{
				mobAnimateP3 = false;
				canEntitiesAttack = true;
			}
		}

		if(CombatInterface.isMobDead()){
			sbg.enterState(Stages.PLAY);
		}else if(CombatInterface.isPlayerDead()){
			sbg.enterState(Stages.MAIN_MENU);
		}else if(!canEntitiesAttack){
		}else{
			if(CombatInterface.isPlayerFaster()){
				canEntitiesAttack = false;
			}else{
				playerAnimateP1 = true;
			}
		}
	}
	
	public static void setOpponent(Mob mob) throws SlickException{
		opponent = new Image("res/Mobs/"+mob.getType()+".png");
	}
	
	@Override
	public void init(GameContainer gameCont, StateBasedGame sbg) throws SlickException {
		Images.initPlayerCombatImages();
		
		Images.initCombatButtons();
		
		System.out.println("Combat stage says opponent = "+CombatInterface.opponent.getType());
		
		Image[] melee = {Images.melee,Images.melee};
		Image[] attack = {Images.attack, Images.attack};
		Image[] main = {Images.main,Images.main};
		Image[] weapon = {Images.weapon,Images.weapon};
		Image[] Null = {Images.Null,Images.Null};
		
		int[] duration = {200,200};
		Melee = new Animation(melee,duration,false);
		Attack = new Animation(attack,duration,false);
		Main = new Animation(main,duration,false);
		
		//Weapon changing
		Weapon = new Animation(weapon,duration,false);
		Void = new Animation(Null,duration,false);
		
		updatePlyrHealth();
		updateMobHealth();
		
		Menu = Main;
		WeaponAni = Void;
		
		newFont  = new Font("Calibri", Font.BOLD, 24);
		font = new TrueTypeFont(newFont, true);
		
	}
	
	@Override
	public void render(GameContainer gameCont, StateBasedGame sbg, Graphics g) throws SlickException {
		Images.combatBG1.draw(0, 50);
		g.setBackground(Color.darkGray);
		g.setColor(Color.yellow);
		
		g.drawString("Mouse Location" + mouse, 50,100);
		font.drawString(50, 100, "Player: " + playerHealth + " " +deltaPlayerHealth, Color.red);
		font.drawString(1150, 75, "Enemy: " + mobHealth + " " +deltaMobHealth, Color.red);
		g.drawString("X: "+playerX+", Y: "+playerY , 50, 125);
		g.drawString("Sleep: "+sleep+", Sleep Iteration: "+sleepIt+", Delta: "+showDelta+", playerAnimateP1: "+playerAnimateP1, 50, 150);
		
		Images.playerCombatN.draw(playerX,playerY);
		g.drawImage(opponent, mobX, mobY);
		
		//opponent.draw(1200, 375);	
		WeaponAni.draw(1134,350);
		Menu.draw(100,500);
	}

	@Override
	public void update(GameContainer gameCont, StateBasedGame sbg, int delta) throws SlickException  {
		Input input = gameCont.getInput();
		
		playerAnimation(delta, sbg);
		mobAnimation(delta, sbg);
		
		if((xpos > -2900 && xpos < -2850)&&(ypos < 1100 && ypos > 1050)&&input.isMousePressed(0)){
			//Top left of menu
			switch(menuStage){
			case MAIN:
				CombatInterface.gotoAttackMenu();
				menuStage = allStages.ATTACK;
				break;
			case ATTACK:
				CombatInterface.gotoMeleeMenu();
				menuStage = allStages.MELEE;
				break;
			case MELEE:
				if(CombatInterface.isPlayerFaster()){
					canEntitiesAttack = true;
					playerAnimateP1 = true;
				}else{
					canEntitiesAttack = true;
					mobAnimateP1=true;
				}
				CombatInterface.gotoMainMenu();
				menuStage = allStages.MAIN;
				break;
			default:
				break;
			}
		}else if((xpos > -2900 && xpos < -2850)&&(ypos < 1050 && ypos > 1000)&&input.isMousePressed(0)){
			//Bottom left of menu
		}else if((xpos > -2850 && xpos < -2800)&&(ypos < 1100 && ypos > 1050)&&input.isMousePressed(0)){
			//Top right of menu
		}else if((xpos > -2850 && xpos < -2800)&&(ypos < 1050 && ypos > 1000)&&input.isMousePressed(0)){
			//Bottom right of menu
			switch(menuStage){
			case MAIN:
				CombatInterface.flee();
			case ATTACK:
				CombatInterface.gotoMainMenu();
			case MELEE:
				CombatInterface.gotoAttackMenu();
			default:
				break;
			}
		}
		
		if(input.isKeyPressed(Input.KEY_DOWN)){
			Core.player.stats.healthChange(-5);
		}
		
		if(input.isKeyPressed(Input.KEY_UP)){
			Core.player.stats.healthChange(5);
		}
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			sbg.enterState(Stages.PLAY);
		}
		
		xpos = Mouse.getX()-3000;
		ypos = Mouse.getY()+800;
		mouse = ("Mouse Positon x: " +xpos + ", y: " + ypos);	
		
	}

	@Override
	public int getID() {
		return Stages.COMBAT;
	}

}
