//When the same running sum appears again, Elements between them have sum 0
//First, what is a running sum?
//Keep adding numbers as you move.
//
//        1           → sum = 1
//        1 + 2       → sum = 3
//        1 + 2 + -3  → sum = 0
//        1 + 2 + -3 + 3 → sum = 3


package codingquestions;

import java.util.HashMap;

public class LengthOfLongestsubararyWithZeroSum {

    public static int maxLength(int[] arr){
    HashMap<Integer,Integer>map = new HashMap<>();
    int sum=0;
    int maxlen= 0;

    for(int i=0;i<arr.length;i++){

        // Add current element to running sum
        sum+= arr[i];
        // If sum becomes 0, subarray starts from index 0
        if(sum==0){
            //suppose i=0 & length starts from 1
        maxlen= i+1;
        }
        if(map.containsKey(sum)){
            int length = i - map.get(sum); ////Current position minus the position where I first saw this same running sum
            maxlen = Math.max(maxlen,length);
        }
        else{
            map.put(sum,i);
        }
    }
    return maxlen;
    }

    public static void main(String[] args) {
        int [] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLength(arr));
    }
}
