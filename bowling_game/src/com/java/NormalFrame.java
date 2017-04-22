package com.java;


/**
 * Created by vinaym on 18/10/16.
 */
public class NormalFrame extends Frame {

    @Override
    public boolean isOver() {
        if (isStrike() || isSpare()) {
            return true;
        } else if (shotsPlayed() == 2) {
            return true;
        }
        return false;
    }
}
