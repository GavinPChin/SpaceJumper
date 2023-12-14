package Games;
import java.awt.image.BufferedImage;

public class Texture {
		
		SpriteSheet ss;
		private BufferedImage Sprite_Sheet = null;
		public BufferedImage player = null;
		public BufferedImage playerfalling = null;
		public BufferedImage rock = null;
		
		public Texture() {
			BufferedImageLoader loader = new BufferedImageLoader();
			try {
				Sprite_Sheet = loader.LoadImage("/Sprite_Sheet.png");
			}catch(Exception e) {
				e.printStackTrace();
			}			
			ss = new SpriteSheet(Sprite_Sheet);
			getTextures();
	}
		private void getTextures() {
			player = ss.grabImage(1,  1, 32, 32);	//Player Image
			playerfalling = ss.grabImage(1, 2, 32, 32); 	//Player Falling Image
			rock = ss.grabImage(2,  1, 32, 32);	//Rock Image
		}
}
