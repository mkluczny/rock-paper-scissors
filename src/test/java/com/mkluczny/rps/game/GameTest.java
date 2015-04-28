package com.mkluczny.rps.game;

import com.mkluczny.rps.input.UserInput;
import com.mkluczny.rps.player.ComputerPlayer;
import com.mkluczny.rps.player.HumanPlayer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static com.mkluczny.rps.input.Action.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class GameTest {

    @Spy
    private Game game = new Game();

    @Mock
    private RoundManager roundManager;

    @Mock
    private UserInput userInput;


    @Before
    public void setUp() {
        initMocks(this);

        game.setUserInput(userInput);
        game.setRoundManager(roundManager);
    }

    @Test
    public void shouldQuitGame() throws Exception {
        // given
        when(userInput.readAction()).thenReturn(QUIT);

        // when
        game.play();

        // then
        verifyZeroInteractions(roundManager);
    }

    @Test
    public void shouldPlayComputerVsComputer() throws Exception {
        // given
        when(userInput.readAction()).thenReturn(PLAY_COMPUTER_VS_COMPUTER, QUIT);

        // when
        game.play();

        // then
        verify(roundManager).play(any(ComputerPlayer.class), any(ComputerPlayer.class));
    }

    @Test
    public void shouldPlayComputerVsHuman() throws Exception {
        // given
        when(userInput.readAction()).thenReturn(PLAY_COMPUTER_VS_HUMAN, QUIT);

        // when
        game.play();

        // then
        verify(roundManager).play(any(ComputerPlayer.class), any(HumanPlayer.class));
    }

    @Test
    public void shouldNotPlayGameForInvalidAction() throws Exception {
        // given
        when(userInput.readAction()).thenReturn(UNKNOWN, QUIT);

        // when
        game.play();

        // then
        verifyZeroInteractions(roundManager);
    }
}
