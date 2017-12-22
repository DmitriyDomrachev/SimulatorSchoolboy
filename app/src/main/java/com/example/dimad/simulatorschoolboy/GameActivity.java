package com.example.dimad.simulatorschoolboy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private static TextView titleTextView;
    private static TextView situationTextView;
    public static Character player;
    public static Story story;
    Button firstAns, secondAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        titleTextView = findViewById(R.id.titleTextView);
        situationTextView = findViewById(R.id.situationTextView);
        titleTextView.setText(getString(R.string.titleFirst));
        player = new Character(getIntent().getStringExtra("name"));

        situationTextView.setText(player.name+", "+getString(R.string.situationText));
        story = new Story();
        

    }
}
