package com.mkluczny.rps.player;

import com.mkluczny.rps.Option;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static com.mkluczny.rps.Option.SCISSORS;
import static org.fest.assertions.Assertions.assertThat;

public class HumanPlayerTest {

    private HumanPlayer player;

    @Before
    public void setUp() {
        player = new HumanPlayer();
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void shouldReturnUserSelectedOption() throws Exception {
        // when
        mockUserInput(SCISSORS.getAbbr());

        // when
        final Option option = player.call();

        // then
        assertThat(option).isEqualTo(SCISSORS);
    }

    @Test
    public void shouldReturnUserSelectedOptionIfLowerCase() throws Exception {
        // when
        mockUserInput(SCISSORS.getAbbr().toLowerCase());

        // when
        final Option option = player.call();

        // then
        assertThat(option).isEqualTo(SCISSORS);
    }

    /*
        Private
     */

    private void mockUserInput(final String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
