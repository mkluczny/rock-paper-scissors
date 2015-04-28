package com.mkluczny.rps.game;

import com.mkluczny.rps.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static com.mkluczny.rps.input.Figure.PAPER;
import static com.mkluczny.rps.input.Figure.SCISSORS;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RoundManagerTest {

    @Spy
    private RoundManager roundManager = new RoundManager();

    @Mock
    Player player1;

    @Mock
    Player player2;

    @Before
    public void setUp() {
        initMocks(this);

        when(player1.type()).thenReturn("Computer");
        when(player2.type()).thenReturn("Computer");
    }

    @Test
    public void shouldWinFirstUser() throws Exception {
        // given
        when(player1.getFigure()).thenReturn(SCISSORS);
        when(player2.getFigure()).thenReturn(PAPER);

        // when
        final Player winner = roundManager.play(player1, player2);

        // then
        assertThat(winner).isEqualTo(player1);
    }

    @Test
    public void shouldWinSecondUser() throws Exception {
        // given
        when(player1.getFigure()).thenReturn(PAPER);
        when(player2.getFigure()).thenReturn(SCISSORS);

        // when
        final Player winner = roundManager.play(player1, player2);

        // then
        assertThat(winner).isEqualTo(player2);
    }

    @Test
    public void shouldReplayIfDraw() throws Exception {
        // given
        when(player1.getFigure()).thenReturn(PAPER, PAPER, PAPER).thenReturn(PAPER, PAPER, PAPER);
        when(player2.getFigure()).thenReturn(PAPER, PAPER, PAPER).thenReturn(SCISSORS, SCISSORS, SCISSORS);

        // when
        roundManager.play(player1, player2);

        // then
        verify(roundManager).printDraw(player1, player2);
    }
}
