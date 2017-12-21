package com.example.dimad.simulatorschoolboy;

/**
 * Created by dimad on 21.12.2017.
 */
// описание ситуации
public class Situation {
    Situation [] direction;
    String  subject, text;
    int dH, dT;
    public Situation (String subject, String text, int variants, int dh, int dt){
        this.subject = subject;
        this.text = text;
        dH = dh;
        dT = dt;
        direction = new Situation[variants];
    }
}
