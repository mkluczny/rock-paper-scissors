package com.mkluczny.rps.player;

import com.mkluczny.rps.Option;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ComputerPlayerTest {

    private ComputerPlayer player;

    @Before
    public void setUp() {
        player = new ComputerPlayer();
    }

    @Test
    public void shouldReturnRandomlySelectedOption() throws Exception {
        // when
        final Option option = player.call();

        // then
        assertThat(option).isInstanceOf(Option.class);
    }
}
