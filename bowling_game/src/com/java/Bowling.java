package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinaym on 18/10/16.
 */
public class Bowling {

    private static final int MAX_FRAMES = 10;
    private List<Frame> frames;
    private static final int MAX_PINS = 10;
    private int currentFrame=0;
    private boolean gameover = false;
    private int extraBalls = 0;
    private boolean gotBonusBall = false;


    public Bowling() {
        frames = new ArrayList<>(MAX_FRAMES);
        for(int i=0;i<MAX_FRAMES;i++) {
            frames.add(new Frame());
        }
    }


    public void roll(int noOfPins) {
        if (noOfPins > MAX_PINS) {
            throw new RuntimeException("Illegal Parameter " + noOfPins);
        }

        if(gotBonusBall) {
            adjustScoreOfBonusFrame(noOfPins);
        } else {
            adjustScoreOfLastFrame(noOfPins);
        }

        if(extraBalls==0 && !gotBonusBall) {
            frames.get(currentFrame).setScore(noOfPins);

            boolean nextFrame = frames.get(currentFrame).frameChange(noOfPins);

            if (nextFrame && currentFrame != 9) {
                currentFrame++;
            } else if (nextFrame && frames.get(9).isStrike() && extraBalls == 0) {
                System.out.println("Congrats");
                gotBonusBall = true;
                extraBalls = 2;
            } else if(nextFrame && frames.get(9).isSpare() && extraBalls == 0) {
              gotBonusBall = true;
                extraBalls = 1;
            } else if (nextFrame && extraBalls == 0) {
                gameover = true;
            }
        }
        else {
            extraBalls--;
            if(extraBalls==0) {
                gameover=true;
            }
        }
    }

    private void adjustScoreOfBonusFrame(int noOfPins) {
        Frame lastFrame = frames.get(getLastFrameNumber());
        Frame currentFrame = frames.get(getCurrentFrameNumber());

        if(extraBalls==2) {
            lastFrame.extraScore += noOfPins;
        }
        currentFrame.extraScore+=noOfPins;

    }


    public boolean isGameOver() {
        return gameover;
    }

    private void adjustScoreOfLastFrame(int noOfPins) {
        if (getLastFrameNumber() >= 0) {

            Frame lastFrame = frames.get(getLastFrameNumber());
            Frame currentFrame = frames.get(getCurrentFrameNumber());


            if (lastFrame.isStrike()) {
                lastFrame.extraScore += noOfPins;
            } else if (lastFrame.isSpare() && currentFrame.noAttempts == 0) {
                lastFrame.extraScore += noOfPins;
            }

            if(getSecondLastFrameNumber()>=0) {
                Frame secondLastFrame = frames.get(getSecondLastFrameNumber());
                if (secondLastFrame.isStrike() && lastFrame.isStrike() && currentFrame.noAttempts == 0) {
                    secondLastFrame.extraScore += noOfPins;
                }
            }

        }
    }


    private int getCurrentFrameNumber() {
        return currentFrame;
    }

    private int getLastFrameNumber() {
        return currentFrame-1;
    }

    private int getSecondLastFrameNumber() {
        return currentFrame-2;
    }


    public int totalScore() {
        int score=0;
        for(Frame frame:frames) {
            score += frame.frameScore();
        }
        return score;
    }
}
