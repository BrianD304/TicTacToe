package edu.purdue.duffy18.cs180;

/**
 * Created by Brian Duffy on 4/6/2016.
 */

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToeView implements TicTacToeViewInterface {

    Button[][] myButtons; //The 3x3 matrix of buttons
    Button newGameButton; //The "New Game" button
    Context context;

    /**
     * Constructor. Initializes the instance variables.
     */
    public TicTacToeView(Button[][] myButtons, Button newGameButton, Context context) {
        this.myButtons = myButtons;
        this.newGameButton = newGameButton;
        this.context = context;
        //TODO: Initialize instance variables.
    }

    @Override
    public void update(int x, int y, char player) {
        //TODO: Complete this method.
        if (player == 'O') {
            myButtons[x][y].setText("" + player);
            myButtons[x][y].setEnabled(false);
        } else {
            myButtons[x][y].setText("" + player);
            myButtons[x][y].setEnabled(false);
        }
        if (player == 'O') {
            myButtons[x][y].setTextColor(Color.BLUE);
        } else {
            myButtons[x][y].setTextColor(Color.RED);
        }


        //Step 1: Update the text of button at index (x, y) to the player's symbol. In order to convert a char to a String, you can do (charVariable + "")
        //Example usage : myButtons[x][y].setText("" + player);
        //Step 2: Disable the button at index (x, y) from being clicked further.
        //Example usage : myButtons[x][y].setEnabled(false);
        //Step 3: Set text color of the button to BLUE for O or RED for X.
        //Example usage : myButtons[x][y].setTextColor(Color.BLUE);
    }

    @Override
    public void showWinner(String winner) {
        Toast t = Toast.makeText(context, winner + " is the winner!", Toast.LENGTH_LONG);
        t.setGravity(0,0,0);
        t.show();
        //NOT REQUIRED TO BE WRITTEN FOR THIS LAB
    }

    @Override
    public void resetButtons() {
        for (int i = 0; i < myButtons.length; i++) {
            for (int j = 0; j < myButtons[0].length; j++) {
                myButtons[i][j].setText("");
                myButtons[i][j].setTextColor(Color.BLACK);
                myButtons[i][j].setEnabled(true);
            }
        }
        //TODO: Complete this method.
        //Step 1: Iterate through the myButton matrix.
        //Step 2: Reset the text of the current button.
        //Example usage : myButtons[i][j].setText("");
        //Step 3: Reset the color of text for the current button
        //Example usage : myButtons[x][y].setTextColor(Color.BLACK);
        //Step 4: Make the button clickable again
        //Example usage : myButtons[x][y].setEnabled(true);
    }

    @Override
    public void disableButtons() {
        for (int i = 0; i < myButtons.length; i++) {
            for (int j = 0; j < myButtons[0].length; j++) {
                myButtons[i][j].setEnabled(false);
            }
        }
        //TODO: Complete this method.
        //Step 1: Iterate through the myButton matrix.
        //Step 2: Make the current button un-clickable
        //Example usage : myButtons[x][y].setEnabled(false);
    }

    @Override
    public void gameOver() {
        Toast t = Toast.makeText(context, "Game Over\nNo more moves left",Toast.LENGTH_LONG);
        t.setGravity(0,0,0);
        t.show();
        //NOT REQUIRED TO BE WRITTEN FOR THIS LAB
    }
}