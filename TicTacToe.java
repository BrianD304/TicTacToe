package edu.purdue.duffy18.cs180;


/**
 * Created by Brian Duffy on 4/6/2016.
 */
public class TicTacToe {
    TicTacToeViewInterface view; //The view interface used to make modifications to the view
    char[][] board; //The 3x3 board represented with characters
    char currentPlayer; //Keeps track of whose turn it is currently
    int cellsOccupied; //Keeps track of how many cells on the board are occupied
    char winner; //Keeps track of who won

    /**
     * Constructor. Initializes the instance variables.
     */
    public TicTacToe(TicTacToeViewInterface view) {
        this.view = view;
        this.cellsOccupied = 0;
        this.board = new char[3][3];
        this.currentPlayer = 'O';


        //TODO: Initialize instance variables.
    }

    /**
     * This function is called to start a new game.
     */
    public void newGame() {
        reset();
        //TODO: Complete this method.
        //Hint : Call reset(). That's it :)

    }


    public void reset() {
        view.resetButtons();
        this.board = new char[3][3];
        this.currentPlayer = 'O';
        this.cellsOccupied = 0;


        //TODO: Complete this method.
        //should reset every button
        //Every time a new game begins, make sure to reset the view as well
        //as the board and the other instance variables.
    }

    /**
     * This function checks if the given player has won the game or not.
     * The checks have to be made in each column, row, forward and backward diagonals.
     * If a player has won, use a message alert box, toast, etc. to print the winner.
     */
    public boolean checkWinner(char player) {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == player) {
            winner = player;
            return true;
        }
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == player) {
            winner = player;
            return true;
        }
        if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == player) {
            winner = player;
            return true;
        }
        if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == player) {
            winner = player;
            return true;
        }
        if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == player) {
            winner = player;
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == player) {
            winner = player;
            return true;
        }
        if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == player) {
            winner = player;
            return true;
        }
        if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == player) {
            winner = player;
            return true;
        }
        return false;
    }

    //TODO: Complete this method.
    // Iterate through the board matrix and check if you find a sequence of winning patters and set
    // winner to the 'X' or 'O' accordingly. Further, return true if there is a winning pattern.


    /**
     * This function updates the game board whenever a user clicks on any of the game buttons,
     * inside this function you need to call checkWinner to check if a player has won the last
     * click on the board
     */
    public void updateGameBoard(int x, int y) {

        if (checkWinner(currentPlayer)) {
            if (currentPlayer == 'O') {
                view.showWinner("Blue");
                view.disableButtons();
                return;
            } else {
                view.showWinner("Red");
                view.disableButtons();
                return;
            }
        }

        if (cellsOccupied < 9) {
            if (currentPlayer == 'X') {
                view.update(x, y, currentPlayer);
                board[x][y] = currentPlayer;

            }
            if (currentPlayer == 'O') {
                view.update(x, y, currentPlayer);
                board[x][y] = currentPlayer;

            }
            cellsOccupied++;
        } else {
            view.gameOver();
            view.disableButtons();
            newGame();
            return;
        }

        if (cellsOccupied == 9) {
            view.gameOver();
            view.disableButtons();
            newGame();
            return;
        }
        if (checkWinner(currentPlayer)) {
            if (currentPlayer == 'O') {
                view.showWinner("Blue");
                view.disableButtons();
                return;
            } else {
                view.showWinner("Red");
                view.disableButtons();
                return;
            }
        }
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }


    //TODO: Complete this method.
    //Step 1: Check if current player is a winner in which case, you'd not do further updates.
    //Step 2: Check if the count of cellsOccupied is 9, in which case the game would be over.
    // You can perhaps make an additional method void gameOver() to handle this scenario and
    // call it here.
    //Step 3: Update the view by setting the text of button at position (x,y) to the current
    // player's symbol.
    // Call the update method of the view object to do so.
    //Step 4: Update instance variables of this class as needed
    //Step 5: If current player is X, change it to O and vice-versa.
    //Step 6: Check again if the current player is a winner


}
