//Use a sliding window with two pointers (left, right) and a HashSet.
// Expand the window by moving right. When a duplicate character is found, shrink the window from the left until the duplicate is removed.
// Track the maximum window size throughout the process.

package codingquestions;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){

        String str = "abcabcbb";
        System.out.println("Longest substring is " +longestSubstring(str));
    }

    public static int longestSubstring(String str){

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for(int right=0;right<str.length();right++){
            char currentChar = str.charAt(right);
            //Remove duplicates from left side
            while(set.contains(currentChar)){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(currentChar);
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
