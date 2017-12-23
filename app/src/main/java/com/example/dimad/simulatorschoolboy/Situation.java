package com.example.dimad.simulatorschoolboy;

import android.util.Log;

/**
 * Created by dimad on 21.12.2017.
 */


// описание ситуации
public class Situation {
    Situation[][][] direction;
    public String name, text, firsVariant, secondVariant;
    public int variants;
    int dH, dT;

    public Situation(String name, String text, String firstVar, String secondVar, int Variants, int dh, int dt) {
        Log.d("test", "создалась ситуация");

        this.variants = Variants;
        this.name = name;
        this.text = text;
        this.firsVariant = firstVar;
        this.secondVariant = secondVar;
        dH = dh;
        dT = dt;
        direction = new Situation[4][variants][2];
    }
}
