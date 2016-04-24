package edu.purdue.duffy18.cs180;

/**
 * Created by Brian Duffy on 4/6/2016.
 */
public interface TicTacToeViewInterface {
    void update(int x, int y, char player); //Updates button at (x, y) with the player's symbol
    void showWinner(String winner); //Shows the winner
    void resetButtons(); //Resets all the buttons
    void disableButtons(); //Disables all the buttons from being clicked
    void gameOver(); //Disables any further actions in the game

}
