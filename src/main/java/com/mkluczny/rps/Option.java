package com.mkluczny.rps;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public enum Option {

    ROCK("R"),
    PAPER("P"),
    SCISSORS("S");

    private final String abbr;

    Option(final String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return this.abbr;
    }

    private static final List<Option> VALUES    = unmodifiableList(asList(values()));
    private static final int SIZE               = VALUES.size();
    private static final Random RANDOM          = new Random();

    public static Option random() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static Option userOption(String abbr) {

        if (ROCK.getAbbr().equals(abbr)) {
            return ROCK;
        }

        if (PAPER.getAbbr().equals(abbr)) {
            return PAPER;
        }

        if (SCISSORS.getAbbr().equals(abbr)) {
            return SCISSORS;
        }

        throw new IllegalArgumentException(String.valueOf(abbr));
    }
}
