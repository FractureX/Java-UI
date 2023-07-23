package com.mnm.easings;

public class EasingsFunctions {

    public static float easeOutBounce(float x) {
        float n1 = 7.5625f;
        float d1 = 2.75f;
        double v;
        if (x < 1 / d1) {
            v = n1 * x * x;
        } else if (x < 2 / d1) {
            v = n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            v = n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            v = n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
        return (float) v;
    }

    public static float easeOutQuint(float x) {
        return (float) (1 - Math.pow(1 - x, 5));
    }

    public static float easeOutSine(float x) {
        return (float) (Math.sin((x * Math.PI) / 2));
    }
    
    public static float easeInOutSine(float x) {
        return (float) (-(Math.cos(Math.PI * x) - 1) / 2);
    }

}
