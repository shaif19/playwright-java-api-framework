//Easy Trick
//Start from top-right corner.
//If target is smaller → move left
//If target is bigger  → move down

package codingquestions;

public class SearchIn2DMatrix {

    public static void main(String[] args) {

        int [][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int target = 5;
        System.out.println(search2DMatrix(matrix,target));
    }

    public static boolean search2DMatrix(int [][] matrix,int target){
        int row =0;  //Start from the first row
        int column= matrix[0].length-1; //matrix[0] means first row
        //Its length is:matrix[0].length = 3
        //Last column index: 3 - 1 = 2

       while(row< matrix.length && column>=0){

           if(matrix[row][column]==target){
               return true;
           }
           else if(matrix[row][column]<target){  //if target is bigger  → move down
               row++;
           }
           else {
               column--;
           }
       }
       return false;

    }

}
