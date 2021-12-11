
import java.util.ArrayList;
import java.util.Scanner;

Public class Main {
  
  
  public static void main(String[] args) {
	    repeat();
	   
	}
	    public static void repeat () {
	  		Scanner keyboard = new Scanner(System.in);
	  		System.out.print("Enter a hawaiian word to pronounce: ");
	  	    String word = keyboard.nextLine();
	  	    isHawaiian(word);
	  	    System.out.print("Do you want to enter another word? Y/YES/N/NO ");
	  	    String response = keyboard.nextLine();
	  	    if (response.equals("Y") || response.equals("Yes")) {
	  	    	repeat();
	  	    }
	  	}
	  	

	  	  public static void isHawaiian (String s) {
	  		  String word = "";
	  		  String no = "";
	  		  ArrayList <String> valid = new ArrayList <> ();
	  		  valid.add("a");
	  		  valid.add("e");
	  		  valid.add("i");
	  		  valid.add("o");
	  		  valid.add("u");
	  		  valid.add("p");
	  		  valid.add("k");
	  		  valid.add("h");
	  		  valid.add("l");
	  		  valid.add("m");
	  		  valid.add("n");
	  		  valid.add("w");
	  		  valid.add("'");
	  		  valid.add(" ");
	  		  s = s.toLowerCase();
	  		  String upper = s.toUpperCase();
	  		  for (int i = 0; i < s.length(); i++) { 
	  			  String letter = s.substring(i, i+1).toLowerCase();
	  			  if (valid.indexOf(letter) > -1)
	  					  word += s.charAt(i);
	  			  else 
	  				  no += s.charAt(i) + ", ";
	  		  }
	  		  if (word.equals(s)) {
	  			 
	          System.out.println(makeWord(s));
	  		  }
	  		  else {
	          System.out.print(makeWord(s));
	  		  }
	  	  }
	  	
	  	  
	  	  
	  	  public static ArrayList <String> wordArray (String s) {
	  		  ArrayList <String> word = new ArrayList <> ();
	  		  s = s.toLowerCase();
	  		  for (int i = 0; i < s.length(); i++) {
	  			  word.add(s.substring(i, i+1));
	  		  }
	  		  
	  		  return word;
	  	  }
	  	  
 public static String printing (ArrayList <String> word) {
	  		  String full = "";
	  		  ArrayList vowel = new ArrayList <> ();
	  		  vowel.add("a");
	  		  vowel.add("e");
	  		  vowel.add("i");
	  		  vowel.add("o");
	  		  vowel.add("u");
	  		  vowel.add("eye");
	  		  vowel.add("ow");
	  		  vowel.add("ay");
	  		  vowel.add("eh-oo");
	  		  vowel.add("ew");
	  		  vowel.add("oy");
	  		  vowel.add("ooey");
	  		  vowel.add("ah");
	  		  vowel.add("eh");
	  		  vowel.add("ee");
	  		  vowel.add("oh");
	  		  vowel.add("oo");
	  		  for (int i = 0; i < word.size(); i++) {
	  			  if (vowel.indexOf(word.get(i)) == -1 && vowel.indexOf(word.get(i+1)) > -1) {
	  				  
	  				  if (word.indexOf("'") == i+2) {
	  					  full += word.get(i) + word.get(i + 1); 
	  					  i++;
	  				  }
	  				  else if (i + 1 < word.size()-1 && word.get(i+ 2).equals(" ")) {
	  				
	            	
	  					full += word.get(i) + word.get(i+ 1) + " ";
	              
	  					i+=2;
	  				  }
	  				  else {
	            	
	  					  full += word.get(i) + word.get(i+1) + "-" ;
	  					  i++;
	  				  }
	            	
	            
	  			  } 
	  			else {
	  				  
	  				if (word.indexOf("'") == i+1) {
	  					full += word.get(i);
	  				} 
	  				else if (word.indexOf(" ") == i + 1) {
	  					full += word.get(i) + " ";
	              //i++;
	  				}
	  				else if (word.get(i).equals(" ")) {
	            	
	  				}
	          
	  				else { 
	  					full += word.get(i) + "-";  
	  				}
	  			}
	  		  }
	  		  if (full.charAt(full.length()-1) == '-') {
	  			  full = full.substring(0, full.length() -1);
	  		  }
	  		  full = full.toLowerCase();
	  		  String capital = full.substring(0, 1).toUpperCase();
	  		  String rest = full.substring(1, full.length());
	  		  full = capital + rest;
	  		  return full; 
	  		  
	  	  }
	  	  
	  	  
	  	  
	  	  public static String makeWord (String s) {
	  		  String str = "";
	        ArrayList word = wordArray(s);
	  		  ArrayList vowels = new ArrayList <> ();
	  		  vowels.add("a");
	  		  vowels.add("e");
	  		  vowels.add("i");
	  		  vowels.add("o");
	  		  vowels.add("u");
	        if (s.equals("invalid")) {
	          return "invalid";
	        }
	  		  for (int i = 0; i < word.size()-1; i++) {
	  			  if (vowels.indexOf(word.get(i)) > -1 && vowels.indexOf(word.get(i)) > -1); {
	  			  	vowelGroups(word, i);
	  			  } if  (word.get(i).equals("w") && word.get(i + 1).equals("i")) {
	  				  word.set(i, "v"); 
	  		  } if  (word.get(i).equals("w") && word.get(i + 1).equals("e")) {
	  			  word.set(i, "v"); 
	  		  }   else if (word.get(i).equals("a")) {
	  			  word.set(i, "ah");
	  		  }  if (word.get(i).equals("e")) {
	  			  word.set(i, "eh");
	  		  } if (word.get(i).equals("i")) {
	  			  word.set(i, "ee");
	  		  } if (word.get(i).equals("o")) {
	  			  word.set(i, "oh");
	  		  } if (word.get(i).equals("u")) {
	  			  word.set(i, "oo");
	  	  } 
	  		  }  
	  		  
	  		  int x = word.size() -1;
	  		   
	  			if (word.get(x).equals("a")) {
	  				  word.set(x, "ah");
	  			  }  if (word.get(x).equals("e")) {
	  				  word.set(x, "eh");
	  			  } if (word.get(x).equals("i")) {
	  				  word.set(x, "ee");
	  			  } if (word.get(x).equals("o")) {
	  				  word.set(x, "oh");
	  			  } if (word.get(x).equals("u")) {
	  				  word.set(x, "oo");
	  	  } 
	  	  
	  		  str = printing(word);
	  		
	  		   return s.toUpperCase() + " is pronounced " + str;
	  	  }
	  	  
	  	  
	  	  public static void vowelGroups (ArrayList <String> word, int i) {
	  		  if (word.get(i).equals("a") && word.get(i + 1).equals("i")) {
	  			  word.set(i, "eye");
	  			  word.remove(i + 1);
	  	    } if (word.get(i).equals("a") && word.get(i + 1).equals("e")) {
	  		  	word.set(i, "eye");
	  		  	word.remove(i + 1);
	  	   } if (word.get(i).equals("a") && word.get(i + 1).equals("o")) {
	  		  	word.set(i, "ow");
	  		  	word.remove(i + 1);
	  	   } if (word.get(i).equals("a") && word.get(i + 1).equals("u")) {
	  				  word.set(i, "ow");
	  				  word.remove(i + 1);
	  	   } if (word.get(i).equals("e") && word.get(i + 1).equals("i")) {
	  		  			word.set(i, "ay");
	  		  			word.remove(i + 1);	  			
	  	}		if (word.get(i).equals("e") && word.get(i + 1).equals("u")) {
	  					word.set(i, "eh-oo");
	  					word.remove(i + 1);
	  			} if (word.get(i).equals("i") && word.get(i + 1).equals("u")) {
	  				word.set(i, "ew");
	  				word.remove(i + 1);
	  			}if (word.get(i).equals("o") && word.get(i + 1).equals("i")) {
	  				word.set(i, "oy");
	  				word.remove(i + 1);
	  			}if (word.get(i).equals("o") && word.get(i + 1).equals("u")) {
	  				word.set(i, "ow");
	  				word.remove(i + 1);
	  			}if (word.get(i).equals("u") && word.get(i + 1).equals("i")) {
	  				word.set(i, "ooey");
	  				word.remove(i + 1);
	  }

	  	  }
}
