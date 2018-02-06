package hangman.entities;

public class HangingMan {
	
	private int lives;
	
	public HangingMan() {
		this.lives = 6;
	}
	
	public int getLivesRemaining() {
		return this.lives;
	}
	
	public void punishWrongLetter() {
		if (this.lives <= 0) {
			return;
		}
		this.lives--;
	}
}
