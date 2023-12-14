package Games;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import Games.SpaceJumper.PAGE;

public class SpaceJumper extends Canvas implements Runnable{
	private static final long serialVersionUID = 8245488580576912886L;
	
	public static final int WIDTH=640, HEIGHT = WIDTH/12*9;  		//Game Window, basic aspect ratio
	
	private Thread thread;						//Creates a thread for the game
	private boolean running = false;
	
	public static boolean paused = false;
	
	private Random rand;
	private Handler handler;
	private HUD hud;
	private Menu menu;
	
	public BufferedImage Background = null;
	static Texture texture;
	
	public enum PAGE {
		 Menu,
		 Game,
		 Help,
		 Dead,
	};
	
	public static PAGE gamePage = PAGE.Menu;
	
	
	public SpaceJumper() {	
		new SpaceJumperWindow(WIDTH, HEIGHT, "SPACEJUMPER", this);
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new Inputs(handler, this));					//inputs from the player
		this.addMouseListener(menu);				//Mouse inputs for menu
		BufferedImageLoader loader = new BufferedImageLoader();
		Background = loader.LoadImage("/SpaceJumperBackground.png");		//Loading Background
		texture = new Texture();
		Audio.load();								//Loads the music
		Audio.getMusic("music").loop();
		
		rand = new Random();
		if(gamePage == PAGE.Game) {
			}
		}
	
	public static Texture getInstance() {
		return texture;
	}
	
	public synchronized void start() {		//Runs the game
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {		//Runs error bugs if game fails to start
		try {
			thread.join();
			running = false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int frames;
	
	public void run() {								//Game Loop to process user input, updates and renders the game. (stolen from minecraft)
	      this.requestFocus();
		  long lastTime = System.nanoTime();
	      double amountOfTicks = 60.0;
	      double ns = 1000000000 / amountOfTicks;
	      double delta = 0;
	      long timer = System.currentTimeMillis();
	      frames = 0;
	      while(running) {
	       long now = System.nanoTime();
	       delta += (now - lastTime) / ns;
	       lastTime = now;
	       while(delta >= 1) {
	    	   tick();
	    	   delta--;
	       }
	       if(running) {
	    	   render();
	       frames++;
	       }

	       if(System.currentTimeMillis() - timer > 1000) {
	        timer += 1000;
	        frames = 0;
	       		}
	      }
	      stop();
	}
	
	private void tick(){
		if(gamePage == PAGE.Game) {
			if(!paused) {
				handler.tick();
				hud.tick();
				
				if(HUD.Damage == 101) {
					HUD.Damage = 0;
					gamePage = PAGE.Dead;
					handler.clearEnemy();
				}
			}else if (gamePage == PAGE.Menu || gamePage == PAGE.Dead) {
				handler.tick();
				menu.tick();
				}
			}
		}
		
	private void render(){							
		BufferStrategy bs = this.getBufferStrategy();			//Buffering method
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(Background, 0, 0, this);
		
		handler.render(g);
		
		if(paused) {
			Font pausefont = new Font("Courier", 1, 50);
			g.setFont(pausefont);
			g.setColor(Color.white);
			g.drawString("Paused", 220, 220);
		}
		
		if(gamePage == PAGE.Game) {
			hud.render(g);
		}else if (gamePage == PAGE.Menu || gamePage == PAGE.Help || gamePage == PAGE.Dead){
			menu.render(g);
		}		
		g.dispose();
		bs.show();	
	}
	
	public static int clamp(int var, int min, int max) {		//clamp method to keep the player within the Jframe
		if(var>= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else 
			return var;
	}
	
	public static void main(String[] args) {
			new SpaceJumper();
		}
}
