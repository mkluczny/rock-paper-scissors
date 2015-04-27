package com.mkluczny.rps.player;

import com.mkluczny.rps.Option;

public class ComputerPlayer extends Player {

    @Override
    public Option call() throws Exception {
        return Option.random();
    }
}
