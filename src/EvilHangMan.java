import java.util.*;
import java.io.*;


public class EvilHangMan extends Hangman {
	private ArrayList<String> wordlist = new ArrayList<String>();
	private int secretStringLength;
	
	public EvilHangMan(int StringLength, int numGuesses) {
		this.numGuessesRemaining = numGuesses;
		this.currentState = new StringBuilder();
		this.lettersGuessed = new HashSet<Character>();
		this.secretStringLength = StringLength;
		this.secretWord = "";
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("dictionary.txt"));// read the dictionary
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		while (scanner.hasNext()) {
			String temp = scanner.nextLine().toUpperCase();
			if (temp.length() == StringLength) {
				wordlist.add(temp);
			}
		}

		for (int j = 0; j < StringLength; j++) {
			this.currentState.append("_ ");
		}
		scanner.close();
	}
	
	@Override
	public boolean gameOver() {
		return numGuessesRemaining == 0;
	}

	@Override
	public int numLettersRemaining() {
		return 26; // because they never get one right!
	}

	@Override
	public boolean isWin() {
		return false;
	}

	public boolean makeGuess(char ch) {
		int numWords = wordlist.size();
		System.out.println("makeGuess: " + ch + "; numWords=" + numWords);
		boolean guessResult = false;
		char letterGuess = ch;
		if (Character.isLetter(ch) && !isRepeatInput(ch)) {
			// we choose the words that don't contain the letter the user
			// guessed, and they will be the new possible secret words.
			ArrayList<String> temp = new ArrayList<String>();
			for (String i : wordlist) {
				for (int j = 0; j < secretStringLength; j++) {
					if (i.charAt(j) == ch) {
						break;
					} else {
						if (j == secretStringLength - 1) {
							if (i.charAt(j) != ch) {
								temp.add(i);
							}
						}
					}
				}
			}
			if (temp.size() == 0) {
				System.out.println("tempWordNum is zero!");

				secretWord = wordlist.get(0);
				guessResult = true;
			} else {
				secretWord = temp.get(0);
				numWords = temp.size();
				wordlist = temp;
				numGuessesRemaining--;
				guessResult = false;
			}
			if (!guessResult) {
				this.lettersGuessed.add(letterGuess);
			}

		} else return false;
		
		return guessResult;
	}
}