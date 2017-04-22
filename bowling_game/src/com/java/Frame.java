package com.java;


/**
 * Created by vinaym on 18/10/16.
 */
public class Frame {

    public int noAttempts = 0;

    int extraScore = 0;

    int MAX_SHOTS=2;

    int[] score = new int[MAX_SHOTS];

    public Frame() {
    }

    public boolean isSpare(int noOfPins) {
        return (score[0] + noOfPins == 10) &&  noAttempts==2;
    }

    public boolean isStrike(int noOfPins) {
        return noOfPins==10 && noAttempts == 1;
    }

    public void setScore(int noOfPins) {
        score[noAttempts] = noOfPins;
        noAttempts++;
    }

    public int frameScore() {
        return score[0] + score[1] + extraScore;
    }

    public boolean isStrike() {
        return score[0]==10;
    }

    public boolean isSpare() {
        return score[0] + score[1] == 10 & score[0]!=10;
    }

    public boolean frameChange(int noOfPins) {
        if(isStrike(noOfPins) || isSpare(noOfPins)) {
            return true;
        } else if(noAttempts==2) {
            return true;
        }
        return false;
    }

}
