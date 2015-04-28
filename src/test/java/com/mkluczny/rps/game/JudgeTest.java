package com.mkluczny.rps.game;

import org.junit.Before;
import org.junit.Test;

import static com.mkluczny.rps.input.Figure.*;
import static org.fest.assertions.Assertions.assertThat;

public class JudgeTest {

    private Judge judge;

    @Before
    public void setUp() {
        judge = new Judge();
    }

    @Test
    public void rockEqualsRock() {
        assertThat(judge.compare(ROCK, ROCK)).isEqualTo(0);
    }

    @Test
    public void rockLosesWithPaper() {
        assertThat(judge.compare(ROCK, PAPER)).isEqualTo(-1);
    }

    @Test
    public void rockBeatsScissors() {
        assertThat(judge.compare(ROCK, SCISSORS)).isEqualTo(1);
    }

    @Test
    public void paperEqualsPaper() {
        assertThat(judge.compare(PAPER, PAPER)).isEqualTo(0);
    }

    @Test
    public void paperLosesWithScissors() {
        assertThat(judge.compare(PAPER, SCISSORS)).isEqualTo(-1);
    }

    @Test
    public void paperWindsWithRock() {
        assertThat(judge.compare(PAPER, ROCK)).isEqualTo(1);
    }

    @Test
    public void scissorsEqualsScissors() {
        assertThat(judge.compare(SCISSORS, SCISSORS)).isEqualTo(0);
    }

    @Test
    public void scissorsLosesWithRock() {
        assertThat(judge.compare(SCISSORS, ROCK)).isEqualTo(-1);
    }

    @Test
    public void scissorsBeatsPaper() {
        assertThat(judge.compare(SCISSORS, PAPER)).isEqualTo(1);
    }
}
