/**
 * <p>A class that keeps track of the current state of a game of hangman.</p>
 * <p> The class is constructed with a secret word and some number of guesses.</p>
 * <p>Every time a letter is guessed, the state of the game is updated appropriately
 * integrating the guessed letter into the word, updating the number of guesses
 * remaining, etc.</p>
 * 
 * <p>This class can then be used by a user interface to administer a regular game of Hangman.</p>
 */
import java.util.*;
public class NormalHangMan extends Hangman
{
    /**
     * Constructor sets up the game to be played with a word and some number of
     * guesses.  The class should have private variables that keep track of:
     * <li>The original secret word
     * <li>The number of guesses remaining
     * <li>The number of letters that still need to be guessed
     * <li>The current state of word to be guessed (e.g. "L A B _ R A _ _ R Y")
     * @param secretWord the word that the player is trying to guess
     * @param numGuesses the number of guesses allowed
     */
    public NormalHangMan(String secretWord, int numGuesses, HashSet<Character> letterHistory){
    	this.secretWord = secretWord;
    	this.numGuessesRemaining = numGuesses;
    	this.numLettersRemaining = secretWord.length();
    	this.currentState = new StringBuilder();
        for(int i = 0; i < secretWord.length(); i++)
        {
            this.currentState.append("_ ");
            for(int j = i; j > 0; j--)
            {
                if(secretWord.charAt(i) == secretWord.charAt(j-1))
                {
                    numLettersRemaining--;//If the letter appears many times in the secret word, it will be counted just once.
                    break;
                }
            }
        }
        this.lettersGuessed = letterHistory;
    }
    
    public boolean makeGuess(char ch)
    {
    	if (Character.isLetter(ch) == false) return false;
        boolean tempB = updateState(ch);
        char guess = ch;
        if (!super.isRepeatInput(ch)) {
            lettersGuessed.add(guess);

            if (tempB) {
                numLettersRemaining--;
            } else {
                numGuessesRemaining--;
            }
            return tempB;
        }
        else return false;
    }
    
    // this should be private but then how do I test it??
    public boolean updateState(char ch) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == ch) { //if the user guess right, adjust the current state.
            	StringBuilder temp = new StringBuilder();
                for (int j = 0; j < secretWord.length(); j++) {
                    if (secretWord.charAt(j) == ch) {
                    	temp.append(ch);
                    	temp.append(' ');
                    } else {
                    	temp.append(currentState.charAt(2*j));
                    	temp.append(currentState.charAt(2*j + 1));
                    }
                }
                currentState = temp;
                return true;
            }
        }
        return false;
    }
}      