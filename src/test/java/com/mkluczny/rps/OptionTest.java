package com.mkluczny.rps;

import org.junit.Test;

import static com.mkluczny.rps.Option.*;
import static org.fest.assertions.Assertions.assertThat;

public class OptionTest {

    @Test
    public void shouldMapUserOptionToRock() {
        assertThat(userOption(ROCK.getAbbr())).isEqualTo(ROCK);
    }

    @Test
    public void shouldMapUserOptionToScissors() {
        assertThat(userOption(SCISSORS.getAbbr())).isEqualTo(SCISSORS);
    }

    @Test
    public void shouldMapUserOptionToPaper() {
        assertThat(userOption(PAPER.getAbbr())).isEqualTo(PAPER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRaiseAnExceptionForUnknownUserOption() {
        userOption("UNKNOWN");
    }

    @Test
    public void shouldReturnRandomOption() {
        assertThat(Option.random()).isInstanceOf(Option.class);
    }
}
