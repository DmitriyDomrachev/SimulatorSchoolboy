package com.example.dimad.simulatorschoolboy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private static EditText playerName;
    public static String PlayerName;
    Button startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerName = findViewById(R.id.nameEditText);
        PlayerName = String.valueOf(playerName.getText());
        startGame = findViewById(R.id.startGameButton);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId()) {
                    case R.id.startGameButton:
                        i = new Intent(MainActivity.this, GameActivity.class);
                        i.putExtra("name",""+playerName.getText());
                        startActivity(i);
                        break;

                    default:
                        return;
                }
            }
        };
        startGame.setOnClickListener(listener);
    }

    protected void onResume(){
        super.onResume();

    }
    @Override
    public void onBackPressed() {
        // do nothing
    }
}
