package codingquestions;

import java.util.HashSet;

public class RepeatingAndMissingNumbers {

    public static void main(String[] args) {

        int[] nums = {1,2,4,5,6,7,5};
//Find repeating
        HashSet<Integer>hm = new HashSet<>();
        int missing = -1; // u can also take 0
        int repeating = -1; // u can also take 0
        for(int num:nums){
            if(hm.contains(num)){
                repeating = num;
            }
            else {
                hm.add(num);
            }
        }
//Find missing
        for(int i=1;i< nums.length;i++){ //i=1 because we have to compare starting ele of array i.e. 1
            if(!hm.contains(i)){
                missing = i;
                break;
            }
        }

        System.out.println(missing);
        System.out.println(repeating);

    }
}
