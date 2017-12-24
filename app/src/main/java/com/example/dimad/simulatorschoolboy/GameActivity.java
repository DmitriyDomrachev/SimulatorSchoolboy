package com.example.dimad.simulatorschoolboy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private static TextView titleTextView;
    private static TextView situationTextView;
    public static Character player;
    public static boolean first = true, count = false;
    private static int ans;
    public static int numberOfStory = 0;
    public static Story story;
    Button firstAns, secondAns, statist;
    private static String name = "";
    public static boolean finish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        titleTextView = findViewById(R.id.titleTextView);
        situationTextView = findViewById(R.id.situationTextView);
        firstAns = findViewById(R.id.firstButton);
        secondAns = findViewById(R.id.secondButton);
        statist = findViewById(R.id.statistButton);


        View.OnClickListener listener = new View.OnClickListener() { //обработка нажатий
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId()) {
                    case R.id.statistButton:
                        i = new Intent(GameActivity.this, InfoActivity.class);
                        startActivity(i);
                        first = false;
                        break;
                    case R.id.firstButton:
                        Log.d("test", "первая кнопка");
                        goStory(1);
                        setTextStory();
                        ans = 1;
                        break;
                    case R.id.secondButton:
                        Log.d("test", "вторая кнопка");
                        goStory(2);
                        setTextStory();
                        ans = 2;
                        break;

                    default:
                        return;
                }
            }
        };
        statist.setOnClickListener(listener);
        firstAns.setOnClickListener(listener);
        secondAns.setOnClickListener(listener);

        if (first) {        //создание объекта игрока, ситуации, первая установка текста и кнопок
            player = new Character(getIntent().getStringExtra(name));
            story = new Story();
            name = getIntent().getStringExtra("name");
            player.H += story.current_situation.dH;
            player.T += story.current_situation.dT;
            firstAns.setText(story.current_situation.firsVariant);
            secondAns.setText(story.current_situation.secondVariant);
            setTextStory();
        }
    }

    protected void onResume() { //установка текста при возращении в активность
        super.onResume();
        setTextStory();
    }

    private void setTextStory() { // устанока текста и кнопок
        if (story.current_situation.variants != 0) {
            Log.d("test", "смена текста");
            titleTextView.setText(story.current_situation.name);
            situationTextView.setText(name + ", " + story.current_situation.text);
            firstAns.setText(story.current_situation.firsVariant);
            secondAns.setText(story.current_situation.secondVariant);
            if (count) {                                    //подсчет способностей ирока
                Log.d("test", "count:" + count);
                player.H += story.current_situation.dH;
                player.T += story.current_situation.dT;
                count = false;
                if (story.current_situation.dH !=0)
                    Toast.makeText(getBaseContext(), "Владение пк + "+story.current_situation.dH+" %",
                            Toast.LENGTH_SHORT).show();
                if (story.current_situation.dT !=0)
                    Toast.makeText(getBaseContext(), "Школьные знания + "+story.current_situation.dT+" %",
                            Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void goStory(int num) {             //запуск истории
        Log.d("test", "go from game activity");
        Log.d("test", "numberOfSituation: " + numberOfStory);
        story.go(num, player.H, player.T);
        if (story.current_situation.variants == 0) finish = true;
        if (finish) {        //завершение истории
            Log.d("test", "конец");
            Intent e = new Intent(GameActivity.this, EndActivity.class);
            e.putExtra("text",""+story.current_situation.text);
            e.putExtra("name",""+name);
            startActivity(e);
            finish();
        }
        count = true;
        Log.d("test", "история: " + story.current_situation.direction);

    }
    @Override
    public void onBackPressed() {
        // do nothing
    }


}
