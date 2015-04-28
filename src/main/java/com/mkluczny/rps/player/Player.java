package com.mkluczny.rps.player;

import com.mkluczny.rps.input.Figure;

import java.util.concurrent.Callable;

public abstract class Player implements Callable<Figure> {

    private volatile Figure figure;

    /*
     *  Factory Methods
     */

    public static Player human() {
        return new HumanPlayer();
    }

    public static Player computer() {
        return new ComputerPlayer();
    }

    /*
     *  Player's type
     */

    public abstract String type();

    /*
     *  Getters & Setters
     */

    public void setFigure(final Figure figure) {
        this.figure = figure;
    }

    public Figure getFigure() {
        return this.figure;
    }
}
