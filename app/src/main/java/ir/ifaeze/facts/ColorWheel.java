package ir.ifaeze.facts;

import android.graphics.Color;

import java.util.Random;

public class ColorWheel {
    // Member variable (properties about the object)
    public String[] mColors = {
            "#39add1",
            "#3079ab",
            "#c25975",
            "#e15258",
            "#f9845b",
            "#838cc7",
            "#7d669e",
            "#53bbb4",
            "#51b46d",
            "#e0ab18"
    };

    // Mathod (abilities: things the object can do)
    public int getColor() {
        // The button is clicked, so update the color label with a new color
        String color;
        // Randomly select a color
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}