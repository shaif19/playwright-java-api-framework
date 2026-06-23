//Increase count for the same number, decrease for a different number. The number that survives till the end is the majority element

package codingquestions;

public class MajorityElementMooreVotingAlgo {

    public static void main(String[] args) {

        int [] num = {2, 2, 1, 1, 2, 2, 2};
        System.out.println("Majority element is " +majorityElement(num));
    }
    public static int majorityElement(int [] num){
        int candidate= num[0]; //assuming candidate is 1st element i.e. 4
        int count=1; //hence count =1
        for(int i=1;i< num.length;i++){ //Because before the loop starts, you already used the first element as the candidate.
              if(num[i]==candidate){
                  count++;
              }
              else{
                  count--;
              }
              if(count==0){ //Old candidate i.e. num[0] has lost all votes.Pick current number as new candidate.
                  candidate= num[i];
                  count=1;
              }
        }
        return candidate;
    }
}
