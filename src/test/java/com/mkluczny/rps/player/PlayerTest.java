package com.mkluczny.rps.player;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void shouldCreateHumanPlayer() {
        assertThat(Player.human()).isInstanceOf(HumanPlayer.class);
    }

    @Test
    public void shouldCreateComputerPlayer() {
        assertThat(Player.computer()).isInstanceOf(ComputerPlayer.class);
    }
}
