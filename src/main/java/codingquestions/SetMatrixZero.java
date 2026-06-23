//Find all positions where the value is zero, store their row and column numbers,
// then convert those complete rows and columns into zeros
//Approach (Simple):
//Find all cells having 0.
//Store their row and column numbers.
//Make those rows and columns as 0.

package codingquestions;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 1},
                {0, 1, 1}
        };
        matrixzero(matrix);
        //print matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "");
            }

            System.out.println(" ");
        }
    }

    public static void matrixzero(int[][] matrix) {

        Set<Integer> zerorows = new HashSet<>();
        Set<Integer> zerocolumns = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        //find all cells having zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zerorows.add(i);
                    zerocolumns.add(j);
                }
            }
        }

            //  // Step 2: Make rows and columns zero
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (zerorows.contains(i) || zerocolumns.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }


        }
    }


