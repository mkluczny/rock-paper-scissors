package com.mkluczny.rps;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Judge implements Comparator<Option> {

    private final static Map<Option, Map<Option, Integer>> config;

    static {

        final Map<Option, Integer> rock = new HashMap<>();
        rock.put(Option.ROCK,       0);
        rock.put(Option.PAPER,     -1);
        rock.put(Option.SCISSORS,   1);

        final Map<Option, Integer> paper = new HashMap<>();
        paper.put(Option.ROCK,       1);
        paper.put(Option.PAPER,      0);
        paper.put(Option.SCISSORS,  -1);

        final Map<Option, Integer> scissors = new HashMap<>();
        scissors.put(Option.ROCK,      -1);
        scissors.put(Option.PAPER,      1);
        scissors.put(Option.SCISSORS,   0);

        final Map<Option, Map<Option, Integer>> tmp = new HashMap<>();
        tmp.put(Option.ROCK,     rock);
        tmp.put(Option.PAPER,    paper);
        tmp.put(Option.SCISSORS, scissors);

        config = Collections.unmodifiableMap(tmp);
    }

    @Override
    public int compare(Option o1, Option o2) {
        return config.get(o1).get(o2);
    }
}
