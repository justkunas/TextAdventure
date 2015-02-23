package stages;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import reference.Core;
import reference.Images;
import reference.OmniStage;
import reference.Stages;

import java.awt.Font;


public class StartZone extends BasicGameState{
	
	float originX,originY = 0;

	Font newFont;
	TrueTypeFont font;
	
	public StartZone(int state){
	}
	
	public static boolean isNoGoZone(){
		if(OmniStage.playerX > 500 && OmniStage.playerY <-5 && OmniStage.playerY>-190){
			return true;
		}
		
		if(OmniStage.playerX <570 && OmniStage.playerX>-525 && OmniStage.playerY < -355 && OmniStage.playerY > -425){
			return true;
		}
		
		if(OmniStage.playerX <410 && OmniStage.playerX>335 && OmniStage.playerY<-5 && OmniStage.playerY > -190){
			return true;
		}
		
		if(OmniStage.playerX <475 && OmniStage.playerX>262 &&  OmniStage.playerY<-5 && OmniStage.playerY > -190){
			return true;
		}
		
		if(OmniStage.playerX <240 && OmniStage.playerX>30 && OmniStage.playerY<-5 && OmniStage.playerY > -190){
			return true;
		}
		
		if(OmniStage.playerX <5 && OmniStage.playerX>-200 && OmniStage.playerY<-5 && OmniStage.playerY > -190){
			return true;
		}
		
		if(OmniStage.playerX <-230 && OmniStage.playerX>-435 && OmniStage.playerY<-5 && OmniStage.playerY > -190){
			return true;
		}
		
		if(OmniStage.playerX <410	&& OmniStage.playerX>335 && OmniStage.playerY < -190 && OmniStage.playerY > -355){
			return true;
		}
		
		if(OmniStage.playerX <175 && OmniStage.playerX>100 && OmniStage.playerY < -190 && OmniStage.playerY > -355){
			return true;
		}
		
		if(OmniStage.playerX <-60 && OmniStage.playerX>-135 && OmniStage.playerY < -190 && OmniStage.playerY > -355){
			return true;
		}
		
		if(OmniStage.playerX <-295 && OmniStage.playerX>-370 && OmniStage.playerY < -190 && OmniStage.playerY > -355){
			return true;
		}
		
		if(OmniStage.playerX <-530 && OmniStage.playerX>-605 &&  OmniStage.playerY < -190 && OmniStage.playerY > -355){
			return true;
		}
		/*
		//-----------------------------------------------------------------------
		
		if(OmniStage.playerX <-530 && OmniStage.playerX>-590 && OmniStage.playerY < 315){
			return true;
		}
		
		if(OmniStage.playerX <-450 && OmniStage.playerX>-660 && OmniStage.playerY < 315 && OmniStage.playerY > 125){
			return true;
		}
		
		if(OmniStage.playerX <-300 && OmniStage.playerX>-360 && OmniStage.playerY < 315){
			return true;
		}
		
		if(OmniStage.playerX <-220 && OmniStage.playerX>-430 && OmniStage.playerY < 315 && OmniStage.playerY > 125){
			return true;
		}
		
		if(OmniStage.playerX <-70 && OmniStage.playerX>-130 && OmniStage.playerY < 315){
			return true;
		}
		
		if(OmniStage.playerX <10 && OmniStage.playerX>-200 && OmniStage.playerY < 315 && OmniStage.playerY > 125){
			return true;
		}
		
		if(OmniStage.playerX <160 && OmniStage.playerX>100 && OmniStage.playerY < 315){
			return true;
		}
		
		if(OmniStage.playerX <240 && OmniStage.playerX>30 && OmniStage.playerY < 315 && OmniStage.playerY > 125){
			return true;
		}
		
		if(OmniStage.playerX <390 && OmniStage.playerX>330 && OmniStage.playerY < 315){
			return true;
		}
		
		if(OmniStage.playerX <470 && OmniStage.playerX>260 && OmniStage.playerY < 315 && OmniStage.playerY > 125){
			return true;
		}
		
		if(OmniStage.playerX <620 && OmniStage.playerX>550 && OmniStage.playerY < 315){
			return true;
		}
		
		if(OmniStage.playerX <700 && OmniStage.playerX>490 && OmniStage.playerY < 315 && OmniStage.playerY > 125){
			return true;
		}
		*/
		return false;
	}
	
	public void init(GameContainer gameCont, StateBasedGame sbg) throws SlickException {
		OmniStage.newNumber();
		OmniStage.initPlayer();
		
		OmniStage.player = OmniStage.walkUpN;
		newFont  = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(newFont, true);
	}
	
	public void render(GameContainer gameCont, StateBasedGame sbg, Graphics g) throws SlickException {
		Images.startZoneBG.draw(OmniStage.playerX, OmniStage.playerY);
		g.setBackground(Color.darkGray);
		g.setColor(Color.yellow);
		
		OmniStage.omniRender(gameCont, sbg, g);
		
		Images.door.draw(originX+730, originY+250);
		
	}
	
	public void checkForDoor() throws SlickException{
		if(OmniStage.playerX > 5 && OmniStage.playerX < 30 && OmniStage.playerY > -125){
			Images.door.setCenterOfRotation(0, 0);
			Images.door.setRotation(270);
		}
	}
		
	public void update(GameContainer gameCont, StateBasedGame sbg, int delta) throws SlickException {		
		Input in = gameCont.getInput();
		
		OmniStage.omniUpdate(gameCont, sbg, delta);
		
		
		if(in.isKeyDown(Input.KEY_UP)){
			OmniStage.str = "" + Core.player.stats.karmaChange(1);
		}

		if(in.isKeyDown(Input.KEY_DOWN)){
			OmniStage.str = "" + Core.player.stats.karmaChange(-1);
		}
		
		originX = OmniStage.playerX;
		originY = OmniStage.playerY+250;
		
		checkForDoor();
	}

	public int getID() {
		return Stages.PLAY;
	}
}
