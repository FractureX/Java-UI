/*
 * Proyecto M&M
 */
package com.mnm.functions;

import java.awt.Color;

public class Functions {
    
    public static Color extractColor(Color fromColor, Color toColor, boolean increase, double timerMilSec, double timerTick) {
        double rColor = fromColor.getRed();
        double gColor = fromColor.getGreen();
        double bColor = fromColor.getBlue();
        double aColor = fromColor.getAlpha();
        // Red
        if (fromColor.getRed() < toColor.getRed()) {
            // Sumo
            rColor = fromColor.getRed() + Math.ceil(((toColor.getRed() - fromColor.getRed()) * (timerTick / (double) timerMilSec)));
        } else if (fromColor.getRed() > toColor.getRed()) {
            // Resto
            rColor = fromColor.getRed() - Math.ceil(((fromColor.getRed() - toColor.getRed()) * (timerTick / (double) timerMilSec)));
        }
        // Green
        if (fromColor.getGreen()< toColor.getGreen()) {
            // Sumo
            gColor = fromColor.getGreen() + Math.ceil(((toColor.getGreen() - fromColor.getGreen()) * (timerTick / (double) timerMilSec)));
        } else if (fromColor.getGreen() > toColor.getGreen()) {
            // Resto
            gColor = fromColor.getGreen() - Math.ceil(((fromColor.getGreen() - toColor.getGreen()) * (timerTick / (double) timerMilSec)));
        }
        // Blue
        if (fromColor.getBlue() < toColor.getBlue()) {
            // Sumo
            bColor = fromColor.getBlue()+ Math.ceil(((toColor.getBlue() - fromColor.getBlue()) * (timerTick / (double) timerMilSec)));
        } else if (fromColor.getBlue() > toColor.getBlue()) {
            // Resto
            bColor = fromColor.getBlue() - Math.ceil(((fromColor.getBlue() - toColor.getBlue()) * (timerTick / (double) timerMilSec)));
        }
        // Alpha
        if (fromColor.getAlpha()< toColor.getAlpha()) {
            // Sumo
            aColor = fromColor.getAlpha()+ Math.ceil(((toColor.getAlpha() - fromColor.getAlpha()) * (timerTick / (double) timerMilSec)));
        } else if (fromColor.getAlpha() > toColor.getAlpha()) {
            // Resto
            aColor = fromColor.getAlpha() - Math.ceil(((fromColor.getAlpha() - toColor.getAlpha()) * (timerTick / (double) timerMilSec)));
        }
        return new Color((int) rColor, (int) gColor, (int) bColor, (int) aColor);
    }
}
