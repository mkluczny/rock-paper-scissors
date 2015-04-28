package com.mkluczny.rps.player;

import com.mkluczny.rps.input.Figure;
import com.mkluczny.rps.input.UserInput;

public class HumanPlayer extends Player {

    private UserInput userInput;

    public HumanPlayer() {
        this.userInput = new UserInput();
    }

    @Override
    public Figure call() throws Exception {
        while(true) {
            try {
                setFigure(userInput.readFigure());
                return getFigure();
            } catch (Exception e) {
                System.out.println("Invalid figure, please try again...");
            }
        }
    }

    @Override
    public String type() {
        return "Human";
    }

    /*
     *  Setters
     */

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }
}
