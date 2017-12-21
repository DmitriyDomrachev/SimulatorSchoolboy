package com.example.dimad.simulatorschoolboy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static Character palyer;
    public static Story story;
    private static EditText playerName;
    public static String PlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerName = findViewById(R.id.nameEditText);
        PlayerName = String.valueOf(playerName.getText());
    }

    protected void onResume(){
        super.onResume();

    }
}
