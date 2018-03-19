package com.connercaspar.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    private EditText guess;
    private int numGuess;
    private int randomNum;
    String attemptString;
    private Button submit;
    private TextView resultText;
    private TextView attemptNum;
    private String myNumberString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        guess = findViewById(R.id.guess);
        attemptNum = (TextView)findViewById(R.id.attempt_text_view);
        resultText = (TextView)findViewById(R.id.result_text_view);
        submit = findViewById(R.id.submit);
        startGame();
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                submitClicked();
            }
        });
    }

    private void startGame() {
        numGuess = 1;
        attemptString = getResources().getString(R.string.attempt_number) + numGuess;
        attemptNum.setText(attemptString);
        randomNum = randomNum();
    }


    private int randomNum(){
        return (int) (Math.random() * 100 + 1);
    }

    private void submitClicked() {
        int guessNum = -1;
        try {
            guessNum = Integer.parseInt(guess.getText().toString());
        }catch (Exception e) {
            resultText.setText(getResources().getString(R.string.invalid_guess));
            guess.getText().clear();
        }
        myNumberString = getResources().getString(R.string.my_number) + randomNum;
            if (guessNum >= 101 || guessNum <= 0) {
                resultText.setText(getResources().getString(R.string.invalid_guess));
            } else if (guessNum == randomNum) {
                Intent replayScreen = new Intent(this, ReplayScreen.class);
                replayScreen.putExtra("result", getResources().getString(R.string.win));
                replayScreen.putExtra("number", randomNum);
                replayScreen.putExtra("win", "win");
                startActivity(replayScreen);
                startGame();
            } else if (guessNum > randomNum) {
                resultText.setText((getResources().getString(R.string.guess_high)));
                numGuess++;
                attemptString = getResources().getString(R.string.attempt_number) + numGuess;
                attemptNum.setText(attemptString);
            } else if (guessNum < randomNum) {
                resultText.setText(getResources().getString(R.string.guess_low));
                numGuess++;
                attemptString = getResources().getString(R.string.attempt_number) + numGuess;
                attemptNum.setText(attemptString);
            }
            if (numGuess == 6) {
                Intent replayScreen = new Intent(this, ReplayScreen.class);
                replayScreen.putExtra("result", getResources().getString(R.string.out_of_guesses));
                replayScreen.putExtra("number", myNumberString);
                replayScreen.putExtra("loss", "loss");
                startActivity(replayScreen);
                startGame();
            }
            guess.getText().clear();
    }

}
