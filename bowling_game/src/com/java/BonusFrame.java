package com.java;


/**
 * Created by vinaym on 18/10/16.
 */
public class BonusFrame extends Frame {

    @Override
    public boolean isOver() {
        if ((isStrike() || isSpare()) && shotsPlayed() == 3) {
            return true;
        } else if (!isSpare() && !isStrike() && shotsPlayed() == 2) {
            return true;
        } else if(shotsPlayed() >= 3) {
            return true;
        }

        return false;
    }
}
