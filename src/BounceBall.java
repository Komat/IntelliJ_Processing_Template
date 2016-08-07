/**
 * @description
 * @fileName BounceBall
 * @author komatsu
 * @date 8/6/16.
 * @version 0.0
 */

import processing.core.PApplet;

public class BounceBall {

    private PApplet _papplet;

    float GRAVITY = 3;
    float FRICTION = (float) 0.8;

    float x;
    float y;
    float spx;
    float spy;
    float radius;
    int ball_color;

    /**
     * @param p
     * @param _x
     * @param _y
     * @param _spx
     * @param _spy
     * @param _radius
     * @param _ball_color
     */
    public BounceBall(
            PApplet p,
            float _x, float _y,
            float _spx, float _spy,
            float _radius,
            int _ball_color
    ) {
        _papplet = p;
        x = _x;
        y = _y;
        spx = _spx;
        spy = _spy;
        radius = _radius;
        ball_color = _ball_color;
    }

    public int getBallColor() {
        return this.ball_color;
    }

    /**
     */
    public void move() {
        spy += GRAVITY;
        x += spx;
        y += spy;
        this.bounce();
    }

    /**
     */
    public void draw() {
        _papplet.noStroke();
        _papplet.fill(ball_color);
        _papplet.ellipse(x, y, radius * 2, radius * 2);
    }

    /**
     */
    public void bounce() {
        float bounceMinX = radius;
//        float bounceMaxX = _papplet.width - radius;
//        float bounceMaxY = _papplet.height - radius;
        float bounceMaxX = _papplet.displayWidth - radius;
        float bounceMaxY = _papplet.displayHeight - radius;

        if (x < bounceMinX || x > bounceMaxX) {
            spx = -spx * FRICTION;
            if (x < bounceMinX) {
                x = bounceMinX - (x - bounceMinX);
            }

            if (x > bounceMaxX) {
                x = bounceMaxX - (x - bounceMaxX);
            }

            if (y > bounceMaxY) {
                spy = -spy * FRICTION;
                if (y > bounceMaxY) {
                    y = bounceMaxY - (y - bounceMaxY);
                }
            }
        }
    }
}