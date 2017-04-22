package com.java;

import java.util.Scanner;

/**
 * Created by vinaym on 18/10/16.
 */
public class BowlingAlley {
    public static void main(String[] args) {

        Bowling bowling = new Bowling();
        while(!bowling.isGameOver()) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Number of Pins Down");
            bowling.roll(Integer.parseInt(input.next()));
        }

        System.out.println(bowling.totalScore());


    }
}
