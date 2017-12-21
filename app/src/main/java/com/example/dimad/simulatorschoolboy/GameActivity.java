package com.example.dimad.simulatorschoolboy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private static TextView titleTextView;
    private static TextView situationTextView;
    Button firstAns, secondAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        titleTextView = findViewById(R.id.titleTextView);
        situationTextView = findViewById(R.id.situationTextView);
        titleTextView.setText(getString(R.string.titleFirst));
        situationTextView.setText(MainActivity.PlayerName+", "+getString(R.string.situationText));

    }
}
