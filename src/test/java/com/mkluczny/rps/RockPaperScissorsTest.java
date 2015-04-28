package com.mkluczny.rps;

import com.mkluczny.rps.game.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Game.class)
public class RockPaperScissorsTest {

    @Mock
    private Game game;

    @Test
    public void shouldPlayGame() throws Exception {
        // given
        mockStatic(Game.class);
        when(Game.newGame()).thenReturn(game);

        // when
        RockPaperScissors.main(new String[]{});

        // then
        verify(game).play();
    }
}
