package com.mkluczny.rps;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public enum Option {

    ROCK,
    PAPER,
    SCISSORS;

    private static final List<Option> VALUES    = unmodifiableList(asList(values()));
    private static final int SIZE               = VALUES.size();
    private static final Random RANDOM          = new Random();

    public static Option random() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static Option userOption(String abbr) {
        switch (abbr) {
            case "R": return ROCK;
            case "P": return PAPER;
            case "S": return SCISSORS;
            default: throw new IllegalArgumentException(String.valueOf(abbr));
        }
    }
}
