package hangman;

import hangman.entities.*;
import hangman.visual.MainFrame;
import hangman.visual.VisualHangMan;
import hangman.visual.VisualWord;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
	private Scanner userInput;
	private HiddenWord logicWord;
	private HangingMan logicHangingMan;
	private VisualHangMan hangman;
	private MainFrame mFrame;
	private VisualWord visualWord;
	
	//Constructor, initialize the game setting the word
	// and reset the live
	public Game() {
		this.userInput = new Scanner(System.in);
		
		this.logicWord = new HiddenWord(); //logic of word
		this.logicHangingMan = new HangingMan();//logic hangman
		
		this.hangman = new VisualHangMan(); //group of sprite
		this.visualWord = new VisualWord(0,0,"Default");
		
		this.mFrame = new MainFrame("HangingMan Game");
		this.mFrame.add(this.visualWord);
		this.mFrame.add(this.hangman);
		
		this.mFrame.repaint();
		
	}
	
	public void startGame() {
		this.logicWord.setWord();
		this.visualWord.setText(this.logicWord.getPrintableHiddenWord());
		this.loopGame();
	}
	
	private void loopGame() {
		char letter;
		boolean validLetter;
		boolean letterAlreadyPicked;
		boolean endOfGame;
		int livesRemaining;
		String hiddenWord;
			
		hiddenWord = this.logicWord.getPrintableHiddenWord();
		System.out.println("Hidden word is: " + hiddenWord);
		
		do {
			letter = this.waitInput();
			validLetter = this.logicWord.checkInputInWord(letter);
			letterAlreadyPicked = this.logicWord.checkLetterAlreadyPicked(letter);
			
			if (!validLetter) {
				this.logicHangingMan.punishWrongLetter();
				
				livesRemaining = this.logicHangingMan.getLivesRemaining();
				this.hangman.hiddeBodyPart(livesRemaining);
				this.mFrame.repaint();
				System.out.println("Bad word, you have " + Integer.toString(livesRemaining) + " remaining");
				
			} else if (letterAlreadyPicked) {
				System.out.println("You already pick " + letter);
			} else {
				this.logicWord.addLetter(letter);
				hiddenWord = this.logicWord.getPrintableHiddenWord();
				this.visualWord.setText(this.logicWord.getPrintableHiddenWord());
				System.out.println("Hidden word is: " + hiddenWord);
			}
			
			endOfGame = this.checkGameEnd();
		} while (!endOfGame);
		
		System.out.println("END OF GAME");
	}
	
	/*
	 * This function get the letters to find and save his positions in the String.
	 * Furthermore, we count the total words who need to be found.
	 */
	private char waitInput() {
		String input = ""; //HANDLE A CHARACTER ??
		char letter;
		Pattern letters = Pattern.compile("[a-zA-Z]");
		
		System.out.println("Write a letter");
		
		while (input.length() != 1 || !letters.matcher(input).find()) {
			input = this.userInput.nextLine();
		}
		
		input = input.toUpperCase();
		System.out.println("You choose: " + input);
		letter = input.charAt(0);
		
		return letter;
	}
	
	private boolean checkGameEnd() {
		if (this.logicHangingMan.getLivesRemaining() == 0) {
			System.out.println("You loose the game");
			return true;
		} else if (this.logicWord.getLettersRemaining() == 0) {
			System.out.println("You win the game");
			String hiddenWord = this.logicWord.getPrintableHiddenWord();
			System.out.println("Word is: " + hiddenWord);
			return true;
		}	
		
		return false;
	}
	
}
