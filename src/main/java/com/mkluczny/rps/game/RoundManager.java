package com.mkluczny.rps.game;

import com.mkluczny.rps.input.Figure;
import com.mkluczny.rps.player.Player;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.lang.String.format;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class RoundManager {

    private final ExecutorService executor = newFixedThreadPool(2);

    private Judge judge;

    public RoundManager() {
        this.judge = new Judge();
    }

    public Player play(final Player player1, final Player player2) throws ExecutionException, InterruptedException {
        while(true) {

            waitForFigures(player1, player2);

            switch (judge.compare(player1.getFigure(), player2.getFigure())) {

                case 1:
                    printWinner(player1);
                    return player1;

                case -1:
                    printWinner(player2);
                    return player2;

                default:
                    printDraw(player1, player2);
            }
        }
    }

    public void printWinner(final Player player) {
        System.out.println(format("%s having %s wins!", player.type(), player.getFigure()));
    }

    public void printDraw(final Player player1, final Player player2) {
        System.out.println(format("Draw! %s - %s. Let's try one more time!", player1.getFigure(), player2.getFigure()));
    }

    public void printFigures(final Player player1, final Player player2) {
        System.out.println(format("%s %s vs %s %s", player1.type(), player1.getFigure(), player2.type(), player2.getFigure()));
    }

    /*
     *  Private
     */

    private void waitForFigures(final Player player1, final Player player2) throws ExecutionException, InterruptedException {
        final Future<Figure> player1Bet = executor.submit(player1);
        final Future<Figure> player2Bet = executor.submit(player2);
        player1Bet.get();
        player2Bet.get();

        printFigures(player1, player2);
    }
}
