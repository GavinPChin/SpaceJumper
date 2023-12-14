package Games;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;

import Games.SpaceJumper.PAGE;

public class Menu extends MouseAdapter {
		private Random rand = new Random();
		private SpaceJumper game;
		private HUD hud;
		private Handler handler;
		
		public Menu(SpaceJumper game, Handler handler, HUD hud) {
			this.game = game;
			this.hud = hud;
			this.handler = handler;
		}
	
	public void mousePressed(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();
		
		while (game.gamePage == PAGE.Menu) {
		//Play Button
		if (mouseOver(mX, mY, 215, 200, 180, 50)){
			Audio.getClick("click").play();
			game.gamePage = PAGE.Game;
			if(game.gamePage == PAGE.Game) {
				handler.addObject(new Player(SpaceJumper.WIDTH/2-64, SpaceJumper.HEIGHT/2-32,ID.Player, handler));
				for(int i = 0 ; i < 10 ; i++) {
					handler.addObject(new Enemy(640, 120, ID.Enemy));
							}
					}
		}
		//Help Button
		if (mouseOver(mX, mY, 215, 280, 180, 50)){
			Audio.getClick("click").play();
			game.gamePage = PAGE.Help;
		}
		//Exit Button
		if (mouseOver(mX, mY, 215, 360, 180, 50)){
			Audio.getClick("click").play();
			System.exit(1);
			}
		}
		
		while (game.gamePage == PAGE.Help) {
			//Back Button
			if(game.gamePage == PAGE.Help) {
				if(mouseOver(mX, mY, 210, 360, 180, 50)) 
					game.gamePage = PAGE.Menu;
					Audio.getClick("click").play();
					return;				
			}
		}
		while (game.gamePage == PAGE.Dead) {		
		//Back Button
		if(game.gamePage == PAGE.Dead) {
			if(mouseOver(mX, mY, 210, 350, 200, 64))
				game.gamePage = PAGE.Menu;
				Audio.getClick("click").play();
				return;
				}
			}
		}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mX, int mY, int x, int y, int width, int height) {
		if(mX > x && mX < x + width) {
			if(mY > y && mY < y + height) {
				return true;
			}else return false;
		}else return false;
		
	}
	
	public void tick() {
		}
		
	public void render(Graphics g) {
		if(game.gamePage == PAGE.Menu) {			//menu graphics
		hud.setScore(0);
		Font titlefont = new Font("Courier", 1, 50);
		Font menufont = new Font("Times_Roman", 1, 30);
		
		g.setFont(titlefont);
		g.setColor(Color.white);
		g.drawString("SPACE JUMPER", 130, 100);
		
		g.drawRect(215, 200, 180, 50);
		g.setFont(menufont);
		g.drawString("Play", 275, 236);
		
		g.drawRect(215, 280, 180, 50);
		g.drawString("Help", 275, 316);
		
		g.drawRect(215, 360, 180, 50);
		g.drawString("Exit", 275, 396);
		}else if(game.gamePage == PAGE.Help) {				//Help page graphics
			Font titlefont = new Font("Courier", 1, 50);
			Font menufont = new Font("Times_Roman", 1, 30);
			Font helpfont = new Font("Comic Sans MS", 1, 25);
			Font maxfont = new Font("Comic Sans MS", 1, 18);
			
			g.setColor(Color.WHITE);
			g.setFont(titlefont);
			g.drawString("How to Play", 140, 100);
			
			g.setFont(menufont);
			g.drawRect(210,  350, 200,  64);
			g.drawString("Back", 270, 390);

			g.setFont(helpfont);
			g.drawString("Press space to jump... thats it", 120, 230);

		}else if (game.gamePage == PAGE.Dead) {					//Death screen Graphics
			Font titlefont = new Font("Courier", 1, 50);
			Font menufont = new Font("Times_Roman", 1, 30);
			
			g.setColor(Color.WHITE);
			g.setFont(titlefont);
			g.drawString("Unlucky, Try Again?", 30, 150);
			
			g.setFont(menufont);
			g.drawRect(210,  350, 200,  64);
			g.drawString("Score : " + HUD.score, 222, 230);
			

			g.drawRect(210, 350, 200,  64);
			g.drawString("Back", 270, 390);
		}
	}
}
