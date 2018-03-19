package com.connercaspar.guessinggame;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ReplayScreen extends AppCompatActivity {

    private Button yes;
    private Button no;
    private ImageView win;
    private ImageView loss;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replay_screen);
        yes = findViewById(R.id.yes_button);
        no = findViewById(R.id.no_button);
        listenForButtonPress();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getResult();
    }

    private void listenForButtonPress() {
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickYes();
            }
        });

    }

    public void clickYes() {
        finish();
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
        if (replayScreen.hasExtra("win")) {
            win = findViewById(R.id.win_face);
            win.setVisibility(View.VISIBLE);
        }
        else if (replayScreen.hasExtra("loss")) {
            loss = findViewById(R.id.loss_face);
            loss.setVisibility(View.VISIBLE);
        }
}


}
