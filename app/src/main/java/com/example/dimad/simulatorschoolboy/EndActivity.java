package com.example.dimad.simulatorschoolboy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {
private static TextView endText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        endText = findViewById(R.id.endTextView);
        endText.setText(String.valueOf(getIntent().getStringExtra("name"))+", "+String.valueOf(getIntent().getStringExtra("text")));
    }
    @Override
    public void onBackPressed() {

    }
}
