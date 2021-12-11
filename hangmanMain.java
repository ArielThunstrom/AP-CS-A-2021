//my plus one is I imported the en.txt file and then I added different diffuculties based on the length of the word.
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
    //int random = (int)(Math.random() * 274926 + 1);
    //String word = wordList.get(random);
    //Hangman game = new Hangman("mississippi", 5);
    //Hangman game = new Hangman (word, 26);
    //game.play();
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
