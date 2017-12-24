package com.example.dimad.simulatorschoolboy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {
    private static TextView endText;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        endText = findViewById(R.id.endTextView);
        endText.setText(String.valueOf(getIntent().getStringExtra("name")) + ", " + String.valueOf(getIntent().getStringExtra("text")));


    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()){
          super.onBackPressed();
          System.exit(0);
        }
              else
            Toast.makeText(getBaseContext(), "Двойное нажатие для выхода!",
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }



}
