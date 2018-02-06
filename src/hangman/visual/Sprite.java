package hangman.visual;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite  {
	
	public BufferedImage img;
	public int x;
	public int y;
	public boolean visible;
	
	public Sprite(int x, int y, String path) {
		this.img = null;
		this.visible = true;
		this.x = x;
		this.y = y;
		
		try {
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Error on load img " + path + " error " + e);
		}
		
	}
	
}
