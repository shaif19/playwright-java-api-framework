// Keep track of every row, column, and diagonal count.
// Check if any count reaches the board size.
//If the count becomes +n or -n, that means one player filled the complete row/column/diagonal, so that player wins.
//Otherwise, the game continues.
package codingquestions;

public class TicTacToe {

    int [] rows;
    int [] cols;
    int diagonal;
    int antiDiagonal;
    int n;

    public TicTacToe (int n){
        this.n=n;
        rows= new int[n];
        cols=new int[n];

    }

    public int move (int row,int col,int player){
        //player1= 1, player2=-1
        int value= (player==1)?1:-1; //player1=1,player2=-1
        rows[row]+= value;
        cols[col]+= value;

        if(row==col){
            diagonal+= value;
        }

        //For 3*3 board,Anti-diagonal cells:
        //(0,2)
        //(1,1)
        //(2,0)
        // row+col= 2, hence we take n-1 i.e. 3-1=2
        if(row+col==n-1){
            antiDiagonal+= value;
        }

        //check win, abs ignores the minus sign
        if(Math.abs(rows[row])==n||  //Did someone fill the row?
                Math.abs(cols[col]) == n || //Did someone fill the column?
                Math.abs(diagonal)==n|| //Did someone fill the diagonal?
                Math.abs(antiDiagonal)==n ) //Did someone fill the antidiagonal?
        {
            return player; //winner
        }

         return 0; //no winner yet

    }

    public static void main(String[] args){
        TicTacToe game =new TicTacToe(3);
        System.out.println(game.move(0, 0, 1)); // Player 1
        System.out.println(game.move(1, 1, 2)); // Player 2
        System.out.println(game.move(0, 1, 1)); // Player 1
        System.out.println(game.move(2, 2, 2)); // Player 2
        System.out.println(game.move(0, 2, 1)); // Player 1 wins
    }

}
//output means

//First move → no winner
//Second move → no winner
//Third move → no winner
//Fourth move → no winner
//Fifth move → Player 1 wins