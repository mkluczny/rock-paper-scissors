package com.mkluczny.rps;

import com.mkluczny.rps.game.Game;

import java.util.concurrent.ExecutionException;

public class RockPaperScissors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Game().play();
        System.exit(0);
    }
}
