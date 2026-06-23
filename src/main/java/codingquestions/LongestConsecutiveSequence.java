//Store all numbers in a HashSet, start counting only from numbers
// that don't have a previous consecutive number,
// and keep track of the longest sequence length.

package codingquestions;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args){
        int [] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("longest Consecutive sequence is "+longestConsecutive(nums));

    }

    public static int longestConsecutive(int [] nums){

        // Add all elements into set
        HashSet<Integer>set= new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest = 0;
        for(int num:set) {
            // Is it the start of a sequence?
            if (!(set.contains(num - 1))) { //search for prev number, if no prev number it means we can start from here
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)){
                    currentNum++;
                    count++;
                }
                longest= Math.max(longest,count); //
            }
        }
        return longest;
    }
}
