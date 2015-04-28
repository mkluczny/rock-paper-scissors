package com.mkluczny.rps.input;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public Action readAction() {
        final StringBuilder builder = new StringBuilder()
                .append("\n")
                .append("--------------------------------")
                .append("\n")
                .append("[1] Computer vs Human")
                .append("\n")
                .append("[2] Computer vs Computer")
                .append("\n")
                .append("[Q] Quit")
                .append("\n")
                .append("[ ]:");

        System.out.print(builder.toString());

        final String value = scanner.nextLine();
        System.out.println();

        if("1".equalsIgnoreCase(value)) {
            return Action.PLAY_COMPUTER_VS_HUMAN;
        }

        if("2".equalsIgnoreCase(value)) {
            return Action.PLAY_COMPUTER_VS_COMPUTER;
        }

        if("Q".equalsIgnoreCase(value)) {
            return Action.QUIT;
        }

        return Action.UNKNOWN;
    }

    public Figure readFigure() {
        final StringBuilder builder = new StringBuilder("\n").append("| ");
        for(Figure figure : Figure.values()) {
            builder.append(figure).append(" = ").append(figure.getAbbr()).append(" | ");
        }
        builder.append("\n").append("[ ]:");

        System.out.print(builder.toString());

        final String value = scanner.nextLine();
        System.out.println();

        for(Figure figure : Figure.values()) {
            if (figure.getAbbr().equalsIgnoreCase(value)) {
                return figure;
            }
        }

        throw new IllegalArgumentException(value);
    }

    /*
     *  Setters
     */

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}