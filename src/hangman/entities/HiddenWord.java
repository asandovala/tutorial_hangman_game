package hangman.entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class HiddenWord {
	int lettersRemaining;
	List<String> words;
	List<Character> currentWord;
	List<Character> lettersToFind;
	List<Character> hiddenWord;

	public HiddenWord() {
		this.words = new ArrayList<String>();
		
		try {
			FileReader in = new FileReader("res/words/words.txt");
			BufferedReader br = new BufferedReader(in);
			String line;
			while ((line = br.readLine()) != null) {
				this.words.add(line);
			}
			in.close();
			
		} catch (IOException e) {
			System.out.println("Error on read text");
		}
		
		
		/*
		this.words = new String[] {
				"CAT",
				"DOG",
				"MOUSE",
				"HORSE",
				"COW",
				"CHICKEN",
				"ELEPHANT"
		};*/
		
		this.currentWord = new ArrayList<>();
		this.lettersToFind = new ArrayList<>();
		this.hiddenWord = new ArrayList<>();
	}
	
	public void setWord() {
		Random rand = new Random();
		int totalWords = this.words.size();
		int index = rand.nextInt(totalWords - 1);
		int i;
		String wordPicked = this.words.get(index);
		
		for (i = 0; i < wordPicked.length(); i++) {
			this.currentWord.add(wordPicked.charAt(i));
			this.hiddenWord.add('_');
		}
		
		this.getLettersToFind();
	}
	
	public int getLettersRemaining() {
		return this.lettersRemaining;
	}
	
	public boolean checkInputInWord(char letter) {
		return this.lettersToFind.contains(letter);
	}
	
	public boolean checkLetterAlreadyPicked(char letter) {
		return this.hiddenWord.contains(letter);
	}
	
	public void addLetter(char letter) {
		int i;
		
		for (i = 0; i < this.currentWord.size(); i++) {
			if (this.currentWord.get(i) == letter) {
				this.hiddenWord.set(i, letter);
				this.lettersRemaining--;
			}
		}
	}
	
	public String getPrintableHiddenWord() {
		int i;
		int lenWord = this.hiddenWord.size();
		String wordToPrint = "";
		String letter;
		
		for (i = 0; i < lenWord; i++) {
			letter = this.hiddenWord.get(i).toString();
			wordToPrint += letter + " ";
		}
		
		return wordToPrint;
	}
	
	private void getLettersToFind() {
		char letter;
		this.lettersRemaining = 0;
		
		for (int i = 0; i < this.currentWord.size(); i++) {
			letter = this.currentWord.get(i);
			
			if (!this.lettersToFind.contains(letter)) {
				this.lettersToFind.add(letter);
				this.lettersRemaining++;//plus one to the amount of letters to find
			}
		}
	}
	
}


