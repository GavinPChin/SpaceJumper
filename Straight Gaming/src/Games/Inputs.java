package Games;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Games.SpaceJumper.PAGE;

public class Inputs extends KeyAdapter{
	
	private Handler handler;
	
	SpaceJumper game;
	
	public Inputs(Handler handler, SpaceJumper game) {
		this.handler = handler;
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
		
			if (tempObject.getId() == ID.Player) {
				//Key events for the Player
				if(key == KeyEvent.VK_SPACE) tempObject.setSpeedY(-5);
				//Jump sound for player
				Audio.getSound("jump").play();
			}
			
			if(key == KeyEvent.VK_P) {
				if (game.gamePage == PAGE.Game) {
					Audio.getPause("pause").play();
					if(SpaceJumper.paused) SpaceJumper.paused = false;
					else SpaceJumper.paused = true;
				}
			}
			if(key == KeyEvent.VK_ESCAPE) {System.exit(1);}
			
		}
	}
}
