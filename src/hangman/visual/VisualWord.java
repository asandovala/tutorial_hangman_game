package hangman.visual;

import java.awt.Dimension;
import javax.swing.JLabel;

public class VisualWord extends JLabel {

	private static final long serialVersionUID = 1L;
	public int x, y;
	
	public VisualWord(int x, int y, String word) {	
		super(word);
		this.x = x;
		this.y = y;
		
		this.setPreferredSize(new Dimension(100,100));
	}

}
