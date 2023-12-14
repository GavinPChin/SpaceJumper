package Games;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	private BufferedImage Images;
	
	public BufferedImage LoadImage(String path) {
		
		try {
			Images = ImageIO.read(getClass().getResource(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return Images;
	}
}
