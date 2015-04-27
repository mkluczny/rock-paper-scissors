package com.mkluczny.rps.player;

import com.mkluczny.rps.Option;

import java.util.concurrent.Callable;

public abstract class Player implements Callable<Option> {

    public static Player human() {
        return new HumanPlayer();
    }

    public static Player computer() {
        return new ComputerPlayer();
    }
}
