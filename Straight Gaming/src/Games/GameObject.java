package Games;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x, y; 			//protected variables are extended into other classes 
	protected ID id;
	protected double speedX, speedY;
	protected boolean falling = true;
	protected boolean boost = false;
	
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract Rectangle getBounds();
	
	public void setX(int x) {
		this.x = x;					
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	public double getSpeedX() {
		return speedX;
	}
	public double getSpeedY() {
		return speedY;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isBoost() {
		return boost;
	}

	public void setBoost(boolean boost) {
		this.boost = boost;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
}
