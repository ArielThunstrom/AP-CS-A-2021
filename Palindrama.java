
// tests are created assuming you name the method palindrama, and it returns a String

Public class Main {
  public static void main(String[] args) {

    System.out.print(palindrama("bahuibyasfhbhuahsfbuhuashfbuabcdedcbakasjfkjasjaskjajhuye"));
    
  }

public static boolean isPalindrome(String str)
    {
        int start = 0; 
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

  public static String palindrama(String s) {
    String longest = "";
    String temp = "";
    
    for(int i = 0; i < s.length(); i++){
      for(int a = s.length()-1; a != i ; a--){
      if(s.charAt(a) == s.charAt(i) ){
        if(isPalindrome(s.substring(i,a + 1))){
        temp = s.substring(i, a + 1);
        }      
          if(temp.length() > longest.length()){
            longest = temp;
    }
    }

     
  }
  
}return longest;
  }
}

