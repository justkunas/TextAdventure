package main;

import player.*;
import reference.*;
import stages.CombatStage;
import stages.Inventory;
import stages.MainMenu;
import stages.StartZone;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class TextAdventure extends StateBasedGame{
	
	public TextAdventure(String name) {
		super(Core.NAME);
		this.addState(new MainMenu(Stages.MAIN_MENU));
		this.addState(new StartZone(Stages.PLAY));
		this.addState(new Inventory(Stages.INV));
		this.addState(new CombatStage(Stages.COMBAT));
	}

	public static void main(String[] args) {
		PlayerInv.playerGathersItem(Items.stick);
		PlayerInv.playerGathersItem(Items.fertilizer);
		PlayerInv.playerGathersItem(Items.slimechunk);
		PlayerInv.playerGathersItem(ArmourObjects.debugChest);
		PlayerInv.playerGathersItem(Potions.healthPotion);
		PlayerInv.playerGathersItem(Weapons.basicSword);
		PlayerInv.equipMeleeItem(Weapons.basicSword);
		PlayerInv.playerGathersItem(Weapons.largeClever);
		PlayerInv.playerGathersItem(Weapons.steelSword);
		
		AppGameContainer agc;
		try{
			agc = new AppGameContainer(new TextAdventure(Core.NAME));
			agc.setDisplayMode(1500, 800, false); //750,400
			//agc.setDisplayMode(750, 400, false);
			agc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

	public void initStatesList(GameContainer gameCont) throws SlickException {
		
		this.getState(Stages.MAIN_MENU).init(gameCont, this);
		this.getState(Stages.PLAY).init(gameCont, this);
		this.getState(Stages.INV).init(gameCont, this);
		this.getState(Stages.COMBAT).init(gameCont, this);
		
		this.enterState(Stages.MAIN_MENU);
		
	}

}
