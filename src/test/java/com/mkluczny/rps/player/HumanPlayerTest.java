package com.mkluczny.rps.player;

import com.mkluczny.rps.input.Figure;
import com.mkluczny.rps.input.UserInput;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static com.mkluczny.rps.input.Figure.SCISSORS;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HumanPlayerTest {

    @Mock
    private UserInput userInput;

    private HumanPlayer player;

    @Before
    public void setUp() {
        initMocks(this);
        player = new HumanPlayer();
        player.setUserInput(userInput);
    }

    @Test
    public void shouldReturnUserSelectedFigure() throws Exception {
        // given
        when(userInput.readFigure()).thenReturn(SCISSORS);

        // when
        final Figure figure = player.call();

        // then
        assertThat(figure).isEqualTo(SCISSORS);
    }

    @Test
    public void shouldRepeatReadingUsersFigureIfUserInputInvalid() throws Exception {
        // given
        when(userInput.readFigure()).thenThrow(new RuntimeException()).thenReturn(SCISSORS);

        // when
        final Figure figure = player.call();

        // then
        assertThat(figure).isEqualTo(SCISSORS);
    }

    @Test
    public void shouldReturnHumanType() throws Exception {
        // when/then
        assertThat(player.type()).isEqualTo("Human");
    }
}
