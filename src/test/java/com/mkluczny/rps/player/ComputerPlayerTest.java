package com.mkluczny.rps.player;

import com.mkluczny.rps.input.Figure;
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
    public void shouldReturnRandomlySelectedFigure() throws Exception {
        // when
        final Figure figure = player.call();

        // then
        assertThat(figure).isInstanceOf(Figure.class);
    }

    @Test
    public void shouldReturnComputerType() throws Exception {
        // when/then
        assertThat(player.type()).isEqualTo("Computer");
    }
}
