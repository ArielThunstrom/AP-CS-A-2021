//my plus one is I imported the en.txt file and then I added different diffuculties based on the length of the word.
//en.txt is a text file filled with common english words 
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;
Public class Main {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner (System.in);
    System.out.println("Select a game mode: easy, medium, hard ");
    String choice = keyboard.nextLine();
    difficult(choice);
    
  }

   public static ArrayList<String> importFile(String fileName){
    ArrayList<String> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        Int data = myReader.nextLine();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return words;
  }

  public static String Random (ArrayList <String> wordList) {
    int random = (int)(Math.random() * 274926 + 1);
    String word = wordList.get(random);
    return word;
  }

  public static void difficult (String s) {
    ArrayList <String> wordList = importFile("en.txt");
    if (s.equals("easy")) {
      String random = Random(wordList);
      while (!(random.length() <= 6)) {
        random = Random(wordList);
      }
      Hangman easyGame = new Hangman (random, 26);
      easyGame.play();
    }
    if (s.equals("medium")) {
      String random = Random(wordList);
      while (!(random.length() <= 12)) {
        random = Random(wordList);
      }
      int tries = random.length() * 2;
      Hangman mediumGame = new Hangman (random, tries);
      mediumGame.play();
    }
    if (s.equals("hard")) {
      String random = Random(wordList);
      while (!(random.length() <= 20)) {
        random = Random(wordList);
      }
      Hangman hardGame = new Hangman (random, random.length());
      hardGame.play();
    }
  }


}




//the Hangman class is bellow, this is called in the main 

import java.util.*;

public class Hangman
{
  // the secret word
  private String word;
  
  // a string that shows which letters in word have and have not been guessed yet
  private String hint;
  
  // how many guesses the player has left
  private int numGuessesLeft;
  
  public Hangman(String secret, int numGuesses)
  {
    word = secret;
    numGuessesLeft = numGuesses;
    
    initHint();
  }
  
  /** Initialize the hint instance variable so that it contains
   *  a ? for each letter in word. If word is "hello" then hint should be "?????"
   */
  public void initHint()
  {
    hint = "";
    for (int i = 0; i < word.length(); i++) {
      hint += "?";
    }
  }
  
  /** Checks if word contains letter. If it does, return true; 
   *  otherwise, decrement numGuessesLeft by 1 and return false.
   *  Precondition: letter contains exactly 1 character
   */
  public boolean checkGuess(String letter)
  {
    if (word.indexOf(letter) > -1) {
      return true;
    }
    else {
      numGuessesLeft --;
      return false;
    }
  }
  
  /** Replace the character in hint at the specified index with letter.
   *  Precondition: letter contains exactly 1 character and 0 <= index < word.length()
   */
  public void replaceHintLetter(int index, String letter)
  {
    String start = hint.substring(0, index);
    String rest = hint.substring(index + 1);
    hint = start + letter + rest;
  }
  
  /** Replace each ? in hint with letter at each index that letter exists in word.
   *  For example, if word is "tomato" then updateHint("o") would change hint to
   *  be "?o???o"
   *  Precondition: letter contains exactly 1 character.
   */
  public void updateHint(String letter)
  {
    if (word.indexOf(letter) > -1) {
      replaceHintLetter(word.indexOf(letter), letter);
    }
    
      for (int i = 0; i < word.length(); i++) {
        if (word.substring(i, i+1).equals(letter)) {
          replaceHintLetter(i, letter);
        }
      }
    
  }
  
  /** Return true if all the letters of word have been guessed correctly or
   *  if there are no more guesses left; otherwise, return false.
   */
  public boolean isGameOver()
  {
    if (hint.equals(word)) {
      return true;
    }
    else if (numGuessesLeft == 0) {
      return true;
    }
    return false;
  }
  
  /** Ask the user to guess a letter until the game ends.
   *  After the game ends, tell the user if they won or lost.
   */
  public void play()
  {
    Scanner in = new Scanner(System.in);
    while(!isGameOver())
    {
      System.out.println("Guesses Left: " + numGuessesLeft);
      System.out.println("Hint: " + hint);
      String guess = in.next(); // read input from user
      //make sure guess has at least 1 character
      if(guess.length() > 0)
      {
        guess = guess.substring(0, 1); // make sure guess contains exactly 1 character
        if(checkGuess(guess))
        {
          updateHint(guess);
        }
      }
    }
    
    if(numGuessesLeft <= 0)
    {
      System.out.println("Guesses Left: " + numGuessesLeft);
      System.out.println("You lose...");
    }
    else
    {
      System.out.println(hint);
      System.out.println("You win!");
    }
  }
}
