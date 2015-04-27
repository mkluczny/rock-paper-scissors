package com.mkluczny.rps.player;

import com.mkluczny.rps.Option;

import java.util.Scanner;

import static com.mkluczny.rps.Option.userOption;

public class HumanPlayer extends Player {

    @Override
    public Option call() throws Exception {
        while(true) {
            try {
                System.out.println(("[R = Rock, P = Paper, S = Scissors]:"));
                return userOption(new Scanner(System.in).nextLine().toUpperCase());
            } catch (Exception e) {
                System.out.println("Invalid option, please try again.");
            }
        }
    }
}
