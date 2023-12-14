package Games;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

	public static int Lives = 0;
	public static int Damage = 0;
	public static int score = 0;
	
	public void tick() {
	
		score++;
	}
	
	public void render(Graphics g) {		
		Font myfont = new Font ("Courier New", 1,20);
		
		g.setColor(Color.WHITE);
		g.drawRect(18, 392, 215, 32);
		
		g.setFont(myfont);
		g.drawString("Suit Damage: " + Damage + "%", 25, 415);
		
		Font FPSfont = new Font ("Courier New", 1,20);
		g.setFont(FPSfont);
		g.drawString("FPS: " + SpaceJumper.frames, 520, 25);
		
		
		Font scorefont = new Font ("Courier New", 1,25);
		g.setFont(scorefont);
		g.drawString(("Score: "+score), 25, 30);
	}
	
	public void setScore(int score) {
		HUD.score = score;
	}
}
