// 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
// 2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.


package codingquestions;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        //variant 1
        System.out.println(twoSum(arr,target));
        int[] ans = indices(arr, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    //variant 1
    public static String twoSum(int[] arr, int target) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            int needed = target - num;
            if (set.contains(needed)) {
                return "Yes";
            }
            set.add(num);
        }
        return "No";
    }

    //variant 2
    public static int[] indices(int[] arr, int target) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i=0;i<arr.length;i++) {
            int needed = target - arr[i];
            if (hm.containsKey(needed)) {
                return new int[]{hm.get(needed), i};
            }
            hm.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

}
