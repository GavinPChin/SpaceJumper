package Games;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject{
	private Handler handler;
	private SpaceJumper game;
	Random rand = new Random();
	Texture texture = SpaceJumper.getInstance();
	public Enemy(int x, int y, ID id) {			
		super(x, y, id);	
		speedX = 0-8;		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);		//Gets boundaries for the enemies
	}	
	
	public void tick() {								
			x += speedX;		
			if(x < 0) {							//Spawning system for enemies 
				y = rand.nextInt(470) + 25;
				x = 680;
				speedX = 0-(rand.nextInt(3)+1);		
				if (HUD.score > 3000)			
				speedX = 0-(rand.nextInt(6)+3);
			}
	}
	
	public void render(Graphics g) {
		g.drawImage(texture.rock, x, y, 32, 32, null);
	}
}