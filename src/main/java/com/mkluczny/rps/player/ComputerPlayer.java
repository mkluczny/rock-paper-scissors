package com.mkluczny.rps.player;

import com.mkluczny.rps.input.Figure;

public class ComputerPlayer extends Player {

    @Override
    public Figure call() throws Exception {
        setFigure(Figure.random());
        return getFigure();
    }

    @Override
    public String type() {
        return "Computer";
    }
}
