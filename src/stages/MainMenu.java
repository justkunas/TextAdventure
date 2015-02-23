package stages;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

import reference.Images;
import reference.Stages;

public class MainMenu extends BasicGameState {

	public String mouse = "OutofBounds";
	float hamX = 100;
	float hamY = 100;

	public MainMenu(int state) {

	}

	public void init(GameContainer gameCont, StateBasedGame sbg) throws SlickException {
		Images.initImages();
	}

	public void render(GameContainer gameCont, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.darkGray);
		g.setColor(Color.red);
		// g.drawString("Welcome to " + Stages.NAME, 50, 50);

		g.fillOval(75, 100, 50, 50);
		Images.mainMenuN.draw(0, 0);
		Images.title.draw(575, 75);
		Images.startGame.draw(650, 160);
		Images.quit.draw(650, 194);
		g.drawString(mouse, 50, 100);

		// 650,640 700,605

		// g.drawImage(hammer, hamX, hamY);
	}

	public void update(GameContainer gameCont, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gameCont.getInput();
		int i = 0;
		/*
		 * if(in.isKeyDown(Input.KEY_UP)){ hamY-=0.35; }else
		 * if(in.isKeyDown(Input.KEY_DOWN)){ hamY+=0.35;
		 * }if(in.isKeyDown(Input.KEY_RIGHT)){ hamX+=0.35;
		 * }if(in.isKeyDown(Input.KEY_LEFT)){ hamX-=0.35; }
		 */

		int xpos = Mouse.getX();
		int ypos = Mouse.getY();

		if ((xpos > 650 && xpos < 700) && (ypos > 605 && ypos < 640)) {
			if (in.isMouseButtonDown(0)) {
				sbg.enterState(Stages.PLAY);
			}
		}

		if ((xpos > 650 && xpos < 700) && (ypos > 585 && ypos < 605)) {
			if (in.isMouseButtonDown(0)) {
				System.exit(0);
			}
		}

		mouse = (" Mouse Positon x: " + xpos + ", y: " + ypos);
	}

	public int getID() {
		return Stages.MAIN_MENU;
	}
}
