package com.connercaspar.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReplayScreen extends AppCompatActivity {

    private Button yes;
    private Button no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replay_screen);
        getResult();
        yes = findViewById(R.id.yes_button);
        no = findViewById(R.id.no_button);
        listenForButtonPress();
    }

    private void listenForButtonPress() {
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickYes();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNo();
            }
        });
    }

    public void clickYes() {
        finish();
    }

    public void clickNo() {
        System.exit(1);
    }
    public void getResult() {
        Intent replayScreen = getIntent();
        if (replayScreen.hasExtra("result")) {
            TextView replay = (TextView)findViewById(R.id.replay_text_view);
            replay.setText(replayScreen.getStringExtra(("result")));
        }
        if (replayScreen.hasExtra("number")) {
            TextView number = (TextView)findViewById(R.id.number_text_view);
            number.setText(replayScreen.getStringExtra("number"));
        }
}


}
