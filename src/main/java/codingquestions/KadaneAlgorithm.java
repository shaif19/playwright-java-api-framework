//Problem Statement: Given an integer array nums, find the subarray with the largest sum
// and return the sum of the elements present in that subarray.
//A subarray is a contiguous non-empty sequence of elements within an array.

//Approach: Keep adding elements while the sum increases; if starting fresh from the
// current element gives a larger sum,
// start a new subarray. Track the maximum sum throughout the array.

package codingquestions;

public class KadaneAlgorithm {

    public static void main(String[] args) {

        int[] num = {-1,2,1,4,2,5};
        System.out.println(subarrayMaxSum(num));

    }

    public static int subarrayMaxSum(int [] num){
        int currentsum =num[0];
        int maxsum = num[0];

        for(int i=0;i<num.length;i++){
            currentsum = Math.max(num[i],currentsum+num[i]);
            maxsum = Math.max(currentsum,maxsum);
        }
        return maxsum;
    }
}
