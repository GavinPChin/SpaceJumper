package Games;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import Games.SpaceJumper.PAGE;

public class Player extends GameObject{
	private SpaceJumper game;
	Random rand = new Random();
	Handler handler;
	
	Menu menu;
	
	Texture texture = SpaceJumper.getInstance();
	private float gravity = 0.25f;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		speedX = 0;
		speedY = 0;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
			if(falling || boost) {							//creates gravity so player is always falling
				speedY += gravity;
			}
			
			x += speedX;
			y += speedY;
			
			 y = SpaceJumper.clamp(y, 25, SpaceJumper.HEIGHT - 40);		//Prevents the player from leaving the Jframe
		collision();
		
		if(y == SpaceJumper.HEIGHT - 40) {
			HUD.Damage = 0;
			game.gamePage = PAGE.Dead;
			handler.clearEnemy();
			}
		}
		
	int lifecounter = 0;
	
	private void collision() {
		for(int i = 0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Enemy) {
				if(getBounds().intersects(tempObject.getBounds())) {		//Detects collision between objects and the player	
					HUD.Lives += 1;
					if (HUD.Lives == 2){
						HUD.Damage += 1 ;
						HUD.Lives = 0;
					}
					}
				}
			}
		}
	

	public void render(Graphics g) {
		if (speedY < 0) {
			g.drawImage(texture.player, x, y, 32, 32, null);
		} else {
			g.drawImage(texture.playerfalling, x, y, 32, 32, null);
		}
	}
}
