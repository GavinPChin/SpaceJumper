package Games;
import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage images;
	
	public SpriteSheet(BufferedImage image) {
		this.images = image;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = images.getSubimage((col*width) - width, (row*height)- height, width, height);
		return img;
	}
}
