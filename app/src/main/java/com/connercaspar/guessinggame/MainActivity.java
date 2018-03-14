package com.connercaspar.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button begin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin = findViewById(R.id.start);
        begin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beginClicked();
            }
        });
    }

    public void beginClicked() {
        Intent playGame = new Intent(this,GameActivity.class);
        startActivity(playGame);
    }


}
