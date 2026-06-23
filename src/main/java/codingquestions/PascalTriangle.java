//In Pascal's Triangle, each row starts and ends with 1, and every middle number is the sum of the two numbers above it.


package codingquestions;

public class PascalTriangle {

    public static void main(String[] args) {
        int rows = 5;

        for (int i = 0; i < rows; i++) {
            int num = 1;

            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");

                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

}
