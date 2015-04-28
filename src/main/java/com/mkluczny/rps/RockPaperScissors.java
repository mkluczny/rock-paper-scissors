package com.mkluczny.rps;

import com.mkluczny.rps.game.Game;

import java.util.concurrent.ExecutionException;

public class RockPaperScissors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Game.newGame().play();
    }
}
