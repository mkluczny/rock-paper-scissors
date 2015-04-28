package com.mkluczny.rps.input;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static com.mkluczny.rps.input.Action.*;
import static com.mkluczny.rps.input.Figure.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserInputTest {

    private UserInput userInput;

    @Before
    public void setUp() {
        initMocks(this);

        userInput = new UserInput();
    }

    @Test
    public void shouldReturnNullForUnknownAction() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("UNKNOWN".getBytes())));

        // when/then
        assertThat(userInput.readAction()).isEqualTo(UNKNOWN);
    }

    @Test
    public void shouldReturnCvsHFor1Action() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("1".getBytes())));

        // when/then
        assertThat(userInput.readAction()).isEqualTo(PLAY_COMPUTER_VS_HUMAN);
    }

    @Test
    public void shouldReturnCvsCFor2Action() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("2".getBytes())));

        // when/then
        assertThat(userInput.readAction()).isEqualTo(PLAY_COMPUTER_VS_COMPUTER);
    }

    @Test
    public void shouldReturnQuitForQAction() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("Q".getBytes())));

        // when/then
        assertThat(userInput.readAction()).isEqualTo(QUIT);
    }

    @Test
    public void shouldReturnRockForLowerCaseR() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("r".getBytes())));

        // when/then
        assertThat(userInput.readFigure()).isEqualTo(ROCK);
    }

    @Test
    public void shouldReturnRockForUpperCaseR() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("R".getBytes())));

        // when/then
        assertThat(userInput.readFigure()).isEqualTo(ROCK);
    }

    @Test
    public void shouldReturnPaperForLowerCaseR() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("p".getBytes())));

        // when/then
        assertThat(userInput.readFigure()).isEqualTo(PAPER);
    }

    @Test
    public void shouldReturnPaperForUpperCaseR() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("P".getBytes())));

        // when/then
        assertThat(userInput.readFigure()).isEqualTo(PAPER);
    }

    @Test
    public void shouldReturnScissorsForLowerCaseS() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("s".getBytes())));

        // when/then
        assertThat(userInput.readFigure()).isEqualTo(SCISSORS);
    }

    @Test
    public void shouldReturnScissorsForUpperCaseS() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("S".getBytes())));

        // when/then
        assertThat(userInput.readFigure()).isEqualTo(SCISSORS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidFigure() throws Exception {
        // given
        userInput.setScanner(new Scanner(new ByteArrayInputStream("Invalid".getBytes())));

        // when
        userInput.readFigure();
    }
}
