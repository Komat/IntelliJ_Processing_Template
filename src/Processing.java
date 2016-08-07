/**
 * @description
 * @fileName Processing
 * @author komatsu
 * @date 8/6/16.
 * @version 0.0
 */

import processing.core.*;

public class Processing extends PApplet {

    int length = 100;

    BounceBall[] balls = new BounceBall[length];

    public static void main(String args[]) {
        PApplet.main("Processing");
    }

    public void settings() {
//        size(400, 400);
        size(displayWidth, displayHeight);
    }

    public void setup() {
        colorMode(HSB, length);
        background(length, -1);
        frameRate(10);

        for (int i = 0; i < length; i++) {
            balls[i] = new BounceBall(
                    this,
                    width / 2, 10,
                    random(-20, 20),
                    random(-30, 0),
                    random(5, 20),
                    color(random(length), (float) (length * 0.6), length - 1));
        }
    }

    public void draw() {
        fadeToWhite();

        for (int i = 0; i < length; i++) {
            balls[i].move();
            balls[i].draw();
        }
    }

    private void fadeToWhite() {
        noStroke();
        fill(99, 30);
        rectMode(CORNER);
//        rect(0, 0, width, height);
        rect(0, 0, displayWidth, displayHeight);
    }

}