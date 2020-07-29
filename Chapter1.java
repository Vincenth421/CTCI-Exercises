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

     /** Question 2
     * Given 2 strings, check if one is permutation of the other
     **/
     public static boolean checkPermutation(String str1, String str2)
     {
          char[] c1 = str1.toCharArray();
          char[] c2 = str2.toCharArray();
          Arrays.sort(c1);
          Arrays.sort(c2);

          return (new String(c1)).equals(new String(c2));
     }

     /** Question 3
     * Write a method to replace all spaces in a string with '%20'. You may assume that the string
     * has sufficient space at the end to hold the additional characters, and that you are given the "true"
     * length of the string.
     **/
     public static void URLify(char[] url, int length)
     {
          //only replace spaces until true string length
          for(int i = 0; i < length; i++)
          {
               //if current char is space, replace
               char c = url[i];
               if(c == ' ') replace(url, i);
          }
     }

     private static void replace(char[] url, int index)
     {
          //keep track of chars that we are using to replace
          char temp1 = '2';
          char temp2 = '0';
          int i = index + 1;  //start at next character from space

          url[index] = '%';   //replace current space with '%'

          //replace until end of string
          while(i < url.length - 1)
          {
               //keep track of replaced chars
               char t1 = url[i];
               char t2 = url[i + 1];

               //replace chars
               url[i] = temp1;
               url[i + 1] = temp2;

               //change temps to replaced chars
               temp1 = t1;
               temp2 = t2;

               //go to next needed replacement
               i += 2;
          }

          //if the string isn't even length, we have temp1 is left over, so replace the last character
          if(temp1 != ' ') url[i] = temp1;
     }

     /** Question 4
     * Given a string, write a function to check if it is a permutation of a palindrome.
     **/
     public static boolean palPerm(String str)
     {
          //initialize tracking tools
          int tracker[] = new int[26];
          int n = 0;
          boolean seenOdd = false;

          //case doesn't matter
          str = str.toLowerCase();

          //Go thorugh the string to find number of times characters appear and count number of characters.
          for(int i = 0; i < str.length(); i++)
          {
               if(Character.isLetter(str.charAt(i)))
               {
                    int ind = (int) (str.charAt(i) - 'a');

                    tracker[ind]++;
                    n++;
               }
          }

          //Go through our counts
          for(int i = 0; i < tracker.length; i++)
          {
               if(tracker[i] % 2 == 1)
               {
                    //if we already saw an odd count or number of letters is even, string is not a palindrome
                    if(seenOdd || n % 2 == 0) return false;
                    else seenOdd = true;     //Otherwise say we have seen an odd count letter.
               }
          }

          return true;
     }

     /** Question 5
     * There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, write a function to check if they are
     * one edit (or zero edits) away.
     **/
     public static boolean oneAway(String str1, String str2)
     {
          //edge cases
          if(Math.abs(str1.length() - str2.length()) > 1) return false;
          if(str1.equals(str2)) return true;

          //Tracking variables
          int si = 0;
          int li = 0;
          boolean diff = false;
          String shorter = "";
          String longer = "";

          //Set shorter string
          if(str1.length() <= str2.length())
          {
               shorter = str1;
               longer = str2;
          } else{
               shorter = str2;
               longer = str1;
          }

          while(si < shorter.length() && li < longer.length())
          {
               if(shorter.charAt(si) != longer.charAt(li))
               {
                    //if we already found difference, return false. Otherwise, set diff to true.
                    if(diff) return false;
                    diff = true;

                    //If both strings same length, increase shorter index
                    if(shorter.length() == longer.length()) si++;
               } else {
                    //if characters match, increase shorter index
                    si++;
               }

               //always increase longer index
               li++;
          }

          return true;
     }

}
