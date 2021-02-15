package br.ufpr.tads.guesscity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int answeredQuestions = 0, correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAdvance(View view) {
//        if (answeredQuestions == 4) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("correctAnswers", correctAnswers);
            startActivity(intent);
            finish();
//        }
    }

    public void onclickGuess(View view) {
        answeredQuestions++;
        correctAnswers++;
    }
}