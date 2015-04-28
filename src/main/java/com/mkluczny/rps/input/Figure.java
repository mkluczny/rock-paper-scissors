package com.mkluczny.rps.input;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public enum Figure {

    ROCK("R"),
    PAPER("P"),
    SCISSORS("S");

    private final String abbr;

    private static final List<Figure> VALUES    = unmodifiableList(asList(values()));
    private static final int SIZE               = VALUES.size();
    private static final Random RANDOM          = new Random();

    Figure(final String abbr) {
        this.abbr = abbr;
    }

    public static Figure random() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public String getAbbr() {
        return this.abbr;
    }
}
