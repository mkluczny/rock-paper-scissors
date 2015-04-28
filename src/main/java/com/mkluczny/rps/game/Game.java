package com.mkluczny.rps.game;

import com.mkluczny.rps.input.Action;
import com.mkluczny.rps.input.UserInput;

import java.util.concurrent.ExecutionException;

import static com.mkluczny.rps.player.Player.computer;
import static com.mkluczny.rps.player.Player.human;

public class Game {

    private RoundManager    roundManager;
    private UserInput       userInput;

    private Game() {
        this.roundManager   = new RoundManager();
        this.userInput      = new UserInput();
    }

    public void play() throws ExecutionException, InterruptedException {

        while(true) {

            final Action action = userInput.readAction();

            switch(action) {
                case QUIT:
                    return;

                case PLAY_COMPUTER_VS_COMPUTER:
                    roundManager.play(computer(), computer());
                    break;

                case PLAY_COMPUTER_VS_HUMAN:
                    roundManager.play(computer(), human());
                    break;

                default:
                    printInvalidActionSelected();
                    break;
            }
        }
    }

    public static Game newGame() {
        return new Game();
    }

    /*
     *  Private
     */

    private void printInvalidActionSelected() {
        System.out.println("Invalid action selected.");
    }

    /*
     *  Setters
     */

    public void setRoundManager(RoundManager roundManager) {
        this.roundManager = roundManager;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }
}
