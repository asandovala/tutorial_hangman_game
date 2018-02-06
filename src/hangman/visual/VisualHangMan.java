package hangman.visual;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class VisualHangMan extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Sprite head, body, larm, rarm, rleg, lleg;
	private Sprite bg;
	private ArrayList<Sprite> allBody;
	
	public VisualHangMan() {

		this.bg = new Sprite(0, 0, "res/img/bg.png");
		
		this.head = new Sprite(0, 0, "res/img/head.png");
		this.body = new Sprite(0, 0, "res/img/body.png");
		this.larm = new Sprite(0, 0, "res/img/larm.png");
		this.rarm = new Sprite(0, 0, "res/img/rarm.png");
		this.rleg = new Sprite(0, 0, "res/img/rleg.png");
		this.lleg = new Sprite(0, 0, "res/img/lleg.png");
		
		this.allBody = new ArrayList<Sprite>();
		this.allBody.add(this.head);
		this.allBody.add(this.body);
		this.allBody.add(this.larm);
		this.allBody.add(this.rarm);
		this.allBody.add(this.lleg);
		this.allBody.add(this.rleg);
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setVisible(true);
		this.repaint();
	}
	
	public void hiddeBodyPart(int index) {
		this.allBody.get(index).visible = false;
	}
	
	public ArrayList<Sprite> getBodyParts() {
		return this.allBody;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int i;
		int amountSprites = this.allBody.size();
		Sprite part;
		
		g.drawImage(this.bg.img, this.bg.x, this.bg.y, this);
		
		for (i = 0; i < amountSprites; i++) {
			part = this.allBody.get(i);
			
			if (part.visible) {
				g.drawImage(part.img, part.x, part.y, this);
			}
		}
	}

}
