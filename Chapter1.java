import java.util.*;

public class Chapter1{

     /** Question 1
     * Implement an algorithm to determine if a string has all unique characters
     **/
     public static boolean isUnique(String s)
     {
          Set<Character> set = new HashSet<>();

          for(int i = 0; i < s.length(); i++)
          {
               if(set.contains(s.charAt(i)))
               {
                    return false;
               }

               set.add(s.charAt(i));
          }

          return true;
     }

     //No data structure
     public static boolean isUniqueNoDS(String str)
     {
          if (str.length() > 26) { // Only 26 characters
			return false;
		}

		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';

               //shift 1 left according to ascii of current char - 'a'. If there is already a 1 there, character is not unique.
			if ((checker & (1 << val)) > 0) return false;

               //otherwise add a 1 to the checker at current char - 'a'
			checker |= (1 << val);
		}
		return true;
     }

     public static void testOne(){
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			boolean wordA =  Chapter1.isUnique(word);
			boolean wordB =  Chapter1.isUniqueNoDS(word);
			if (wordA == wordB) {
				System.out.println(word + ": " + wordA);
			} else {
				System.out.println(word + ": " + wordA + " vs " + wordB);
			}
		}
     }

     public static void main(String[] args)
     {
          testOne();
     }

}
