//step 1: Find if a cycle exists , it is imp bcoz we need to move fast from there, and slow will start from entrance only
//step 2: Find where the cycle starts (duplicate number)

package codingquestions;

public class DuplicatesUsingFloydAlgo {

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    // Find intersection point
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow]; //move 1 step
            fast = nums[nums[fast]]; //move 2 step

        }while (slow != fast);
        // Find cycle starting point (duplicate number)
        slow = nums[0];
        while(slow!=fast){
            slow= nums[slow];
            fast= nums[fast];
        }
        return slow;

    }
}
