package com.mkluczny.rps.input;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FigureTest {

    @Test
    public void shouldReturnRandomFigure() {
        assertThat(Figure.random()).isInstanceOf(Figure.class);
    }
}
