/**
 * This implementation of TicTacToe uses a 1 dimensional int array of
10 elements.
 * Only array indices 1-9 are used. Array index 0 is not used.
 * The untaken TicTacToe squares contain numbers 1-9. A square taken
by "X" contains 11,
 * and a square taken by "O" contains 12. X takes the first turn every time.
 *
 * @author Omar Alnaam
 * @version 1
 */

import java.util.Scanner;
import java.util.Random;

public class TicTacToe
{
    // instance variables - replace the example below with your own
    private int [] board;
    private int turn; // start at 0
    private int row1;
    private int col1;
    private int row2;
    private int col2;
    private int row3;
    private int col3;
    private int diag1;
    private int diag2;

    /**
     * Constructor for objects of class TicTacToe
     */
    public TicTacToe()
    {
        // initialise instance variables
        // Make sure the board array has a length of 10.
        board = new int[10];
        turn = 1;

        // Assign numbers 1-9 to the board array elements 1-9;
        // We will not use board[0];
        // Must use a for loop that repeats from 1-9.
        for ( int i = 1; i <= 9; i++ ) {
            board[i] = i;
        }
    } // end constructor

    /**
     * showBoard: Method to show the current 3x3 board of squares.
     * Also, shows whose turn it is: "X's turn" or "O's turn", based
    on the value of turn.
     * See example output in assignment 5 description.
     *
     * Print the 3x3 board of squares;
     * Must use a for loop that repeats from 1-9;
     *      If a board array element contains 11, print "-X-";
     *      If a board array element contains 12, print "-O-";
     *      Otherwise, print the board element surrounded by a space
    on either side.
     *      After printing 3 board elements, print a new line for the next row.
     *
     * After the loop, print whether it's "X's turn" or "O's turn",
     * depending on whether the value of the turn instance variable is
    odd or even.
     */
    public void showBoard()
    {
        System.out.println();

        for ( int i = 1; i <= 9; i++ ) {
            if (board[i] == 11) {
                System.out.print("-X-");
            }
            else if (board[i] == 12) {
                System.out.print("-O-");
            }
            else {
                System.out.print(" " + board[i] + " ");
            }

            if (i % 3 == 0) {
                System.out.println();
            }
        } // end for

        System.out.println();
        // if anyone win dont print X or O turn 
        if (hasWon())
         { System.out.println ();
            }
         else if  (turn % 2 != 0) 
        {
            System.out.println("X's turn");
        }
        else {
            System.out.println("O's turn");
        }
  
        System.out.println();
       
    } // end showBoard()

    /**
     * takeSquare: Method to put "X" or "O" in one of the 9 squares
     *
     * Place an "X" or "O" in the square indicated by squareNumber,
    depending on the value of turn.
     *
     * @param squareNumber (number from 1 - 9)
     */
    public void takeSquare(int squareNumber)
    {
        if (turn % 2 != 0) {
            board[squareNumber] = 11; // X
        }
        else {
            board[squareNumber] = 12; // O
        }
    }

    /**
     * validSquare: Method to check if input squareNumber is valid.
     * A squareNumber is valid if it's between 1-9 AND
     * if the board[squareNumber] does not contain an "X" or "O".
     *
     * @param squareNumber
     * @return valid, true if valid, false if invalid
     */
    public boolean validSquare(int squareNumber)
    {
        boolean valid = true;

        if (squareNumber < 1 || squareNumber > 9) {
            valid = false;
            return valid;
        }
        // that  if condtion help me when computer choose value check if bored = 11 or 12 return false.
        if(board[squareNumber] == 11 || board[squareNumber] == 12){
            valid = false;
            return valid;
        }
        return valid;
    }

    /**
     * play: Method to play TicTacToe.
     * Requires Scanner.
     *
     * Pick a player for X: human or machine
     * Pick a player for O: human or machine
     * In a game loop that repeats 9 times, do:
     *      - Call showBoard to show the board.
     *      - Get X player or O player's square number by calling the
     *        getHumanSquare or getMachineSquare method. Which method
     *        you call depends on whose turn it is, and what type of players
     *        that X or O are.
     *      - Call the takeSquare() method with the square number that
     *        is returned by getHumanSquare() or getMachineSquare().
     *      - If anyone has won, break and declare winner.
     *      - Increment turn variable after every turn.
     *      
     * Show the board again after the game loop ends.
     */
    public void playTicTacToe()
    {
        int player1;
        int player2;
        turn = 1;
        // ask the user you want play with who
        System.out.print("Choose player for X (1=human, 2=machine):");
        Scanner player11 = new Scanner(System.in);
        player1 = player11.nextInt();
        // // ask the user you want play with who
        System.out.print("Choose player for O (1=human, 2=machine):");
        Scanner player22 = new Scanner(System.in);
        player2 = player22.nextInt();
        boolean keepPlaying = true;
        for ( int i= 1; i <=9; i++ )  {
            int where  = 0;
            showBoard();
            if(turn%2==1){
                // if player 1 is  humen  will input value of getHumanSequare in (where) instance varible else computer will pick random number
                 if(player1==1) {
                        while (true) {
                            where = getHumanSquare();
                            if(validSquare(where)){
                                takeSquare(where);
                                break;
                            }
                        }
                        
                        
                    } else {
                        while (true) {
                            where = getMachineSquare();
                            if(validSquare(where)){
                                takeSquare(where);
                                break;
                            }
                        }
                    }
                } else {
                    // if player 2 is  human  will input value of getHumanSequare in (where) instance varible else computer will pick random number
                    if(player2==1){
                        while (true) {
                            where = getHumanSquare();
                            if(validSquare(where)){
                                takeSquare(where);
                                break;
                            }
                        }
                        
                        
                    } else {
                        while (true) {
                            where = getMachineSquare();
                            if(validSquare(where)){
                                takeSquare(where);
                                break;
                            }
                        }
                    }

                }
            // if someone win ( true ) show board and break the loop.
            if ( hasWon())
            { 
                break;
            }

            turn++;
        }

        showBoard();

    }
    // sums of rows, columns, diagonals.
    public void sum(){
        this.row1 =0;
        this.row2 = 0;
        this.row3 = 0;
        this.col1 = 0;
        this.col2 = 0;
        this.col3 = 0;
        this.diag1 = 0;
        this.diag2 = 0;
        // sum the first row 
        for(int i =1; i<4;i++){
            // use this condition to hlep me in Machine method to find if x or o equal 11 or 12 sum the value , 
            // if not 12 or 11 dont sum inatial value of bored because each bored value have inatial  from 1 - 9   

            if(board[i]== 11 || board[i] == 12){
                this.row1 += board[i];
            }
        }
        // sum the Second row 
        for(int i =4; i<7;i++){
            if(board[i]== 11 || board[i] == 12){
                this.row2 += board[i];
            }
        }
        // sum the third row
        for(int i =7; i<10;i++){
            if(board[i]== 11 || board[i] == 12){
                this.row3 += board[i];
            }
        }
        // sum the first  column
        for(int i =1; i<8;i+=3){
            if(board[i]== 11 || board[i] == 12){
                this.col1 += board[i];
            }
        }
        // sum the second column
        for(int i =2; i<9;i+=3){
            if(board[i]== 11 || board[i] == 12){
                this.col2 += board[i];
            }
        }
        // sum the Third colum
        for(int i =3; i<10;i+=3){
            if(board[i]== 11 || board[i] == 12){
                this.col3 += board[i];
            }
        }
        // sum the first daig
        for(int i =1; i<10;i+=4){
            if(board[i]== 11 || board[i] == 12){
                this.diag1 += board[i];
            }
        }
        // sum the Second daig
        for(int i =3; i<8;i+=2){
            if(board[i]== 11 || board[i] == 12){
                this.diag2+= board[i];
            }
        }

    }

    /**
     * hasWon: Check for game won.
     * If this method returns true, X or O has won.
     * @return won, true or false
     */

    public boolean hasWon()
    {
        boolean win = false;
        sum(); // to sum each rows, columes, diags.

        // to check if X win 
        if ( row1 ==33 || row2 == 33 ||row3 == 33 || col1 == 33|| col2== 33 || col3 == 33 || diag1 == 33 || diag2==33 )
        {
            System.out.println ( "====== winner: X ======== " );
            return true;

        }
        // check if O win 
        else if  ( row1 == 36 || row2== 36 || row3 == 36 || col1 == 36 || col2 == 36 || col3 == 36 || diag1== 36 || diag2 == 36)
        {
            System.out.println ( "====== winner: O ======== " );
            return true;
        }
        return win;   
    }

    /**
     * getHumanSquare: This method will ask a human player for an
    input square to
     *                 take. If the input square number is valid, return the
     *                 square number. The human player can be
    playing either X
     *                 or O.
     * Requires Scanner.
     * @return squareNumber, a valid squareNumber from 1-9
     *
     */

    public int getHumanSquare()
    {
        Scanner in = new Scanner(System.in);
        int squarenumber;

        while(true) {
            System.out.print("Enter a square number: ");
            squarenumber = in.nextInt();
            if (validSquare(squarenumber)) {
                break;
            }
        }
        return squarenumber;
    }

    /**
     * getMachineSquare: This method contains an algorithm through which the
     *                   computer will choose a valid square
    number to take to
     *                   win the game or to prevent the opponent
    from winning
     *                   the game. The computer can be playing
    either X or O.
     * @return squareNumber, a valid squareNumber from 1-9
     */

    public int getMachineSquare (){
        sum(); // call this method to sum the rows, cols, diags

        // check to win or block and return value to make computer get that value and play.
        // check first row if = 22 or 24 then check if bored[i] is valid or not to choose which value should computer get it.
        // first row 
        if( row1 == 22 || row1 == 24 )
        {
            if ( validSquare(board[1]))
            {
                return 1;
            }
            else if (validSquare(board[2]))
            {
                return 2;
            }
            else 
            {
                return 3 ; 
            }
        }

        else if( row2 == 22 || row2 == 24 )
        {
            if ( validSquare(board[4]))
            {
                return 4;
            }
            else if (validSquare(board[5]))
            {
                return 5;
            }
            else
            {
                return 6 ; 
            }
        }

        else if( row3 == 22 || row3 == 24 )
        {
            if ( validSquare(board[7]))
            {
                return 7;
            }
            else if (validSquare(board[8]))
            {
                return 8;
            }
            else
            {
                return 9 ; 
            }
        }

        else if( col1 == 22 || col1 == 24 )
        {
            if ( validSquare(board[1]))
            {
                return 1;
            }
            else if (validSquare(board[4]))
            {
                return 4;
            }
            else
            {
                return 7 ; 
            }
        }

        else if( col2 == 22 || col2 == 24 )
        {
            if ( validSquare(board[2]))
            {
                return 2;
            }
            else if (validSquare(board[5]))
            {
                return 5;
            }
            else
            {
                return 8 ; 
            }
        }
        else if( col3 == 22 || col3 == 24 )
        {
            if ( validSquare(board[3]))
            {
                return 3;
            }
            else if (validSquare(board[6]))
            {
                return 6;
            }
            else
            {
                return 9 ; 
            }
        }

        else if( diag1 == 22 || diag1 == 24 )
        {
            if ( validSquare(board[1]))
            {
                return 1;
            }
            else if (validSquare(board[5]))
            {
                return 5;
            }
            else
            {
                return 9 ; 
            }
        }

        else if( diag2 == 22 || diag2 == 24 )
        {
            if ( validSquare(board[3]))
            {
                return 3;
            }
            else if (validSquare(board[5]))
            {
                return 5;
            }
            else
            {
                return 7 ; 
            }
        }
        else {
            return ((int)((Math.random()*(8))+1));
        }
    }  

} // end