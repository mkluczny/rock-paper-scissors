package com.mkluczny.rps.game;

import com.mkluczny.rps.input.Figure;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Judge implements Comparator<Figure> {

    private final static Map<Figure, Map<Figure, Integer>> config;

    static {

        final Map<Figure, Integer> rock = new HashMap<>();
        rock.put(Figure.ROCK,       0);
        rock.put(Figure.PAPER,     -1);
        rock.put(Figure.SCISSORS,   1);

        final Map<Figure, Integer> paper = new HashMap<>();
        paper.put(Figure.ROCK,       1);
        paper.put(Figure.PAPER,      0);
        paper.put(Figure.SCISSORS,  -1);

        final Map<Figure, Integer> scissors = new HashMap<>();
        scissors.put(Figure.ROCK,      -1);
        scissors.put(Figure.PAPER,      1);
        scissors.put(Figure.SCISSORS,   0);

        final Map<Figure, Map<Figure, Integer>> tmp = new HashMap<>();
        tmp.put(Figure.ROCK,     rock);
        tmp.put(Figure.PAPER,    paper);
        tmp.put(Figure.SCISSORS, scissors);

        config = Collections.unmodifiableMap(tmp);
    }

    @Override
    public int compare(Figure o1, Figure o2) {
        return config.get(o1).get(o2);
    }
}
