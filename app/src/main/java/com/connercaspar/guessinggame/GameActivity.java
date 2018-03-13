package com.connercaspar.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private EditText guess;
    private int numGuess;
    int randomNum = randomNum();
    String attemptString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        guess = findViewById(R.id.guess);
        numGuess = 1;
        TextView attemptNum = (TextView)findViewById(R.id.attempt);
        attemptString = getResources().getString(R.string.attempt_number) + numGuess;
        attemptNum.setText(attemptString);


    }

    private int randomNum(){
        return (int) (Math.random() * 5 + 1);
    }

    private void checkGuess() {
        int guessNum = Integer.parseInt(guess.getText().toString());
        TextView resultText = (TextView)findViewById(R.id.result_text_view);
        TextView attemptNum = (TextView)findViewById(R.id.attempt);


        if (guessNum >= 101 || guessNum <= 0) {
            resultText.setText(getResources().getString(R.string.invalid_guess));
        }
        else if (guessNum == randomNum) {
            Intent replayScreen = new Intent(this,ReplayScreen.class);
            startActivity(replayScreen);
        }
        else if (guessNum > randomNum) {
            resultText.setText((getResources().getString(R.string.guess_high)));
            numGuess++;
            attemptNum.setText(attemptString);
        }
        else if (guessNum < randomNum) {
            resultText.setText(getResources().getString(R.string.guess_low));
            numGuess++;
            attemptNum.setText(attemptString);
        }
        if (numGuess == 6) {
            Intent replayScreen = new Intent(this,ReplayScreen.class);
            startActivity(replayScreen);
        }



    }

}
