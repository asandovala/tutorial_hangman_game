package hangman.visual;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public MainFrame(String name) {
		super(name);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
	}
}
