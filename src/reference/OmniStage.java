package reference;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import combatSystem.CombatInterface;

import stages.StartZone;

public class OmniStage {

	static Random random = new Random();

	public static int currCombat = 0;
	public static int targetCombat;

	public static boolean quit = false;

	public static Animation walkUpG, walkDownG, walkRightG, walkLeftG;
	public static Animation walkUpNG, walkDownNG, walkRightNG, walkLeftNG;
	public static Animation player, walkUpN, walkDownN, walkRightN, walkLeftN;
	public static Animation walkUpNE, walkDownNE, walkRightNE, walkLeftNE;
	public static Animation walkUpE, walkDownE, walkRightE, walkLeftE;
	static int[] duration = { 200, 200 };

	public static String str = "" + Core.player.stats.getKarma();

	public static float playerX = 0;
	public static float playerY = -250;
	
	public static float shiftX = playerX+750;
	public static float shiftY = playerY+650;

	public static String debug1 = "";
	public static String debug2 = "";
	public static String debug3 = "";
	
	public static String mouse = "OutofBounds";
	
	public static void omniRender(GameContainer gameCont, StateBasedGame sbg, Graphics g)throws SlickException{
		g.drawString(str, 50, 70);
		g.drawString("Player Location ", 50, 115);
		g.drawString("x: " + OmniStage.playerX + ", y: " + OmniStage.playerY, 50, 130);
		g.drawString(mouse, 50, 100);
		g.drawString(debug1, 50, 145);
		g.drawString(debug2, 50, 160);
		g.drawString(debug3, 50, 175);
		player.draw(shiftX, shiftY);

		if(quit == true){
			g.drawString("Resume (R)", 650, 370);
			g.drawString("Main Menu (M)", 650, 390);
			g.drawString("Quit (Q)", 650, 410);
			if(quit == false){
				g.clear();
			}
		}
		
	}
	
	public static void newNumber() {
		targetCombat = 2000 + random.nextInt(2001);
	}

	public static void initPlayer() throws SlickException {

		// Evil
		Image[] goUpE = { new Image("res/Player/Evil/PlayerUpE.png"),
				new Image("res/Player/Evil/PlayerUpE.png") };
		Image[] goDownE = { new Image("res/Player/Evil/PlayerDownE.png"),
				new Image("res/Player/Evil/PlayerDownE.png") };
		Image[] goLeftE = { new Image("res/Player/Evil/PlayerLeftE.png"),
				new Image("res/Player/Evil/PlayerLeftE.png") };
		Image[] goRightE = { new Image("res/Player/Evil/PlayerRightE.png"),
				new Image("res/Player/Evil/PlayerRightE.png") };

		walkUpE = new Animation(goUpE, duration, false);
		walkLeftE = new Animation(goLeftE, duration, false);
		walkRightE = new Animation(goRightE, duration, false);
		walkDownE = new Animation(goDownE, duration, false);

		// NeutralEvil
		Image[] goUpNE = { new Image("res/Player/NeutralEvil/PlayerUpNE.png"),
				new Image("res/Player/NeutralEvil/PlayerUpNE.png") };
		Image[] goDownNE = {
				new Image("res/Player/NeutralEvil/PlayerDownNE.png"),
				new Image("res/Player/NeutralEvil/PlayerDownNE.png") };
		Image[] goLeftNE = {
				new Image("res/Player/NeutralEvil/PlayerLeftNE.png"),
				new Image("res/Player/NeutralEvil/PlayerLeftNE.png") };
		Image[] goRightNE = {
				new Image("res/Player/NeutralEvil/PlayerRightNE.png"),
				new Image("res/Player/NeutralEvil/PlayerRightNE.png") };

		walkUpNE = new Animation(goUpNE, duration, false);
		walkLeftNE = new Animation(goLeftNE, duration, false);
		walkRightNE = new Animation(goRightNE, duration, false);
		walkDownNE = new Animation(goDownNE, duration, false);

		// Neutral
		Image[] goUpN = { new Image("res/Player/Neutral/PlayerUpN.png"),
				new Image("res/Player/Neutral/PlayerUpN.png") };
		Image[] goDownN = { new Image("res/Player/Neutral/PlayerDownN.png"),
				new Image("res/Player/Neutral/PlayerDownN.png") };
		Image[] goLeftN = { new Image("res/Player/Neutral/PlayerLeftN.png"),
				new Image("res/Player/Neutral/PlayerLeftN.png") };
		Image[] goRightN = { new Image("res/Player/Neutral/PlayerRightN.png"),
				new Image("res/Player/Neutral/PlayerRightN.png") };

		walkUpN = new Animation(goUpN, duration, false);
		walkLeftN = new Animation(goLeftN, duration, false);
		walkRightN = new Animation(goRightN, duration, false);
		walkDownN = new Animation(goDownN, duration, false);

		// NeutralGood
		Image[] goUpNG = { new Image("res/Player/NeutralGood/PlayerUpNG.png"),
				new Image("res/Player/NeutralGood/PlayerUpNG.png") };
		Image[] goDownNG = {
				new Image("res/Player/NeutralGood/PlayerDownNG.png"),
				new Image("res/Player/NeutralGood/PlayerDownNG.png") };
		Image[] goLeftNG = {
				new Image("res/Player/NeutralGood/PlayerLeftNG.png"),
				new Image("res/Player/NeutralGood/PlayerLeftNG.png") };
		Image[] goRightNG = {
				new Image("res/Player/NeutralGood/PlayerRightNG.png"),
				new Image("res/Player/NeutralGood/PlayerRightNG.png") };

		walkUpNG = new Animation(goUpNG, duration, false);
		walkLeftNG = new Animation(goLeftNG, duration, false);
		walkRightNG = new Animation(goRightNG, duration, false);
		walkDownNG = new Animation(goDownNG, duration, false);

		// Good
		Image[] goUpG = { new Image("res/Player/Good/PlayerUpG.png"),
				new Image("res/Player/Good/PlayerUpG.png") };
		Image[] goDownG = { new Image("res/Player/Good/PlayerDownG.png"),
				new Image("res/Player/Good/PlayerDownG.png") };
		Image[] goLeftG = { new Image("res/Player/Good/PlayerLeftG.png"),
				new Image("res/Player/Good/PlayerLeftG.png") };
		Image[] goRightG = { new Image("res/Player/Good/PlayerRightG.png"),
				new Image("res/Player/Good/PlayerRightG.png") };

		walkUpG = new Animation(goUpG, duration, false);
		walkLeftG = new Animation(goLeftG, duration, false);
		walkRightG = new Animation(goRightG, duration, false);
		walkDownG = new Animation(goDownG, duration, false);

	}

	public static void omniUpdate(GameContainer gameCont, StateBasedGame sbg,
			int delta) throws SlickException {
		Input in = gameCont.getInput();

		if (in.isKeyDown(Input.KEY_W) && !quit) {
			currCombat++;

			if (Core.player.stats.getKarma() > 60) {

				OmniStage.player = OmniStage.walkUpG;

			} else if (Core.player.stats.getKarma() < 60
					&& Core.player.stats.getKarma() > 20) {

				OmniStage.player = OmniStage.walkUpNG;

			} else if (Core.player.stats.getKarma() < 20
					&& Core.player.stats.getKarma() > -20) {

				OmniStage.player = OmniStage.walkUpN;

			} else if (Core.player.stats.getKarma() > -60
					&& Core.player.stats.getKarma() < -20) {

				OmniStage.player = OmniStage.walkUpNE;

			} else if (Core.player.stats.getKarma() < -60) {

				OmniStage.player = OmniStage.walkUpE;

			}
			if (in.isKeyDown(Input.KEY_LCONTROL)) {
				currCombat++;
				playerY += delta * 0.2f;
			} else if (in.isKeyDown(Input.KEY_LSHIFT)) {
				playerY += delta * 0.5f;
			} else {
				playerY += delta * 0.1f;
			}
			if (playerY > 405 || StartZone.isNoGoZone()) {
				playerY -= delta * 0.2f;
			}
		}

		if (in.isKeyDown(Input.KEY_S) && !quit) {

			currCombat++;

			if (Core.player.stats.getKarma() > 60) {

				OmniStage.player = OmniStage.walkDownG;

			} else if (Core.player.stats.getKarma() < 60
					&& Core.player.stats.getKarma() > 20) {

				OmniStage.player = OmniStage.walkDownNG;

			} else if (Core.player.stats.getKarma() < 20
					&& Core.player.stats.getKarma() > -20) {

				OmniStage.player = OmniStage.walkDownN;

			} else if (Core.player.stats.getKarma() > -60
					&& Core.player.stats.getKarma() < -20) {

				OmniStage.player = OmniStage.walkDownNE;

			} else if (Core.player.stats.getKarma() < -60) {

				OmniStage.player = OmniStage.walkDownE;

			}

			if (in.isKeyDown(Input.KEY_LCONTROL)) {
				currCombat++;
				playerY -= delta * 0.2f;
			} else if (in.isKeyDown(Input.KEY_LSHIFT)) {
				playerY -= delta * 0.5f;
			} else {
				playerY -= delta * 0.1f;
			}
			if (playerY < -2755 || StartZone.isNoGoZone()) {
				playerY += delta * 0.2f;
			}
		}

		if (in.isKeyDown(Input.KEY_A) && !quit) {

			currCombat++;

			if (Core.player.stats.getKarma() > 60) {

				OmniStage.player = OmniStage.walkLeftG;

			} else if (Core.player.stats.getKarma() < 60
					&& Core.player.stats.getKarma() > 20) {

				OmniStage.player = OmniStage.walkLeftNG;

			} else if (Core.player.stats.getKarma() < 20
					&& Core.player.stats.getKarma() > -20) {

				OmniStage.player = OmniStage.walkLeftN;

			} else if (Core.player.stats.getKarma() > -60
					&& Core.player.stats.getKarma() < -20) {

				OmniStage.player = OmniStage.walkLeftNE;

			} else if (Core.player.stats.getKarma() < -60) {

				OmniStage.player = OmniStage.walkLeftE;

			}

			if (in.isKeyDown(Input.KEY_LCONTROL)) {
				currCombat++;
				playerX += delta * 0.2f;
			} else if (in.isKeyDown(Input.KEY_LSHIFT)) {
				playerX += delta * 0.5f;
			} else {
				playerX += delta * 0.1f;
			}
			if (playerX > 570 || StartZone.isNoGoZone()) {
				playerX -= delta * 0.2f;
			}
		}
		if (in.isKeyDown(Input.KEY_D) && !quit) {

			currCombat++;

			if (Core.player.stats.getKarma() > 60) {

				OmniStage.player = OmniStage.walkRightG;

			} else if (Core.player.stats.getKarma() < 60
					&& Core.player.stats.getKarma() > 20) {

				OmniStage.player = OmniStage.walkRightNG;

			} else if (Core.player.stats.getKarma() < 20
					&& Core.player.stats.getKarma() > -20) {

				OmniStage.player = OmniStage.walkRightN;

			} else if (Core.player.stats.getKarma() > -60
					&& Core.player.stats.getKarma() < -20) {

				OmniStage.player = OmniStage.walkRightNE;

			} else if (Core.player.stats.getKarma() < -60) {

				OmniStage.player = OmniStage.walkRightE;

			}

			if (in.isKeyDown(Input.KEY_LCONTROL)) {
				currCombat++;
				playerX -= delta * 0.2f;
			} else if (in.isKeyDown(Input.KEY_LSHIFT)) {
				playerX -= delta * 0.5f;
			} else {
				playerX -= delta * 0.1f;
			}
			if (playerX < -5205 || StartZone.isNoGoZone()) {
				playerX += delta * 0.2f;
			}
		}
		
		if(in.isKeyPressed(Input.KEY_ESCAPE)){
			if(!quit){
				quit = true;
			}else if(quit){
				quit = false;
			}
		}
		
		if(in.isKeyPressed(Input.KEY_E)&&!quit){
			
			sbg.enterState(Stages.INV);
		}
		
		if(in.isKeyDown(Input.KEY_R) && quit){
			quit = false;
		}
		
		if(in.isKeyDown(Input.KEY_M) && quit){
			quit = false;
			sbg.enterState(Stages.MAIN_MENU);
		}
		
		if(in.isKeyDown(Input.KEY_Q) && quit){
			System.exit(0);
			quit = false;
		}
		
		if(in.isKeyDown(Input.KEY_C)){
			CombatInterface.initiateCombat(Mobs.jerry, gameCont, sbg);
		}
		
		if(currCombat >= targetCombat){
			debug3 = "Combat Initilised";
			currCombat = 0;
			newNumber();
		}

		int xpos = Mouse.getX()-3000;
		int ypos = Mouse.getY()+800;
		mouse = ("Mouse Positon x: " +xpos + ", y: " + ypos);
		
		debug1 = ""+OmniStage.currCombat;
		
		debug2 = ""+OmniStage.targetCombat;
		

	}
}
