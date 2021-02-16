package br.ufpr.tads.guesscity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private int correctAnswers;
    TextView textViewResult, textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewResult = findViewById(R.id.textViewResult);
        textViewDescription = findViewById(R.id.textViewResultDescription);

        Bundle b = getIntent().getExtras();
        correctAnswers = b.getInt("correctAnswers");
        textViewResult.setText("Você fez " + correctAnswers * 25 + " pontos!");
        textViewDescription.setText(setDescriptionText());
    }

    private String setDescriptionText(){
        switch (correctAnswers){
            case 0:
                return "Não foi dessa vez :( ";
            case 1:
                return "Melhor que nada";
            case 2:
                return "Acertou metade, já está valendo!";
            case 3:
                return "Parabéns!";
            case 4:
                return "Acertou todas! Você é demais!";
            default:
                return "Ops, algo deu errado";

        }
    }
}