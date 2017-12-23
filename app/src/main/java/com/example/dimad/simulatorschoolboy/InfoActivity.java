package com.example.dimad.simulatorschoolboy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    Button back;
    public static TextView hack;
    public static TextView think;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        back = findViewById(R.id.backGameButton);
        hack = findViewById(R.id.hackValueTextView);
        think = findViewById(R.id.thinkValueTextView);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId()) {
                    case R.id.backGameButton:
                        i = new Intent(InfoActivity.this, GameActivity.class);
                        startActivity(i);
                        break;

                    default:
                        return;
                }
            }
        };
        back.setOnClickListener(listener);
        think.setText(String.valueOf(GameActivity.player.T));
        hack.setText(String.valueOf(GameActivity.player.H));
    }
}
