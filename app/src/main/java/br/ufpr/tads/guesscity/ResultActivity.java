package br.ufpr.tads.guesscity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private int correctAnswers = 4;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewResult = findViewById(R.id.textViewResult);

        Bundle b = getIntent().getExtras();
        correctAnswers = b.getInt("correctAnswers");
        textViewResult.setText("Você fez " + correctAnswers * 25 + " pontos!");
    }
}