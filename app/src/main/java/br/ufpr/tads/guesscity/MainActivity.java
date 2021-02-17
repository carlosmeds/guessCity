package br.ufpr.tads.guesscity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.ufpr.tads.guesscity.Model.City;

public class MainActivity extends AppCompatActivity {
    private int answeredQuestions = 0, correctAnswers = 0;
    private int count = 0;

    private ImageView cityImageView;
    private String correctAnswer, personAnswer;


    TextView answerTextView;
    EditText personGuess;
    Button buttonGuess, buttonAdvance;

    City c0 = new City("Barcelona", R.drawable.barcelona);
    City c1 = new City("Brasília", R.drawable.brasilia);
    City c2 = new City("Curitiba", R.drawable.curitiba);
    City c3 = new City("Las Vegas", R.drawable.lasvegas);
    City c4 = new City("Montreal", R.drawable.montreal);
    City c5 = new City("Paris",R.drawable.paris);
    City c6 = new City("Rio de Janeiro",R.drawable.riodejaneiro);
    City c7 = new City("Salvador",R.drawable.salvador);
    City c8 = new City("São Paulo",R.drawable.saopaulo);
    City c9 = new City("Tóquio",R.drawable.toquio);

    City [] citiesArray = new City[]{
        c0,c1,c2,c3,c4,c5,c6,c7,c8,c9
    };

    List<String> answeredCities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTextView = findViewById(R.id.textViewAnswer);
        personGuess = findViewById(R.id.editTextPersonGuess);
        cityImageView = (ImageView) findViewById(R.id.imageView);
        buttonGuess = findViewById(R.id.buttonGuess);
        buttonAdvance = findViewById(R.id.buttonAdvance);

        buttonAdvance.setEnabled(false);



        shuffleCities();
        showRandomCity();
    }

    public void onClickAdvance(View view) {
        answerTextView.setText("");
        personGuess.setText("");

            if (answeredQuestions == 4) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("correctAnswers", correctAnswers);
                startActivity(intent);
                finish();
            } else {
                showRandomCity();
                buttonGuess.setEnabled(true);
                buttonAdvance.setEnabled(false);
            }
    }

    public void onclickGuess(View view) {
        personAnswer = personGuess.getText().toString();
        answeredCities.add(correctAnswer);

        personAnswer = personAnswer.toUpperCase();
        String correctAnswerUpperCase = correctAnswer.toUpperCase();
        if (correctAnswerUpperCase.equals(personAnswer)){
            answerTextView.setTextColor(Color.GREEN);
            answerTextView.setText("Você acertou! Parabéns!");
            correctAnswers++;
        } else {
            answerTextView.setTextColor(Color.RED);
            answerTextView.setText("Você Errou :( \n Resposta Correta: " + correctAnswer);
        }
        buttonAdvance.setEnabled(true);
        buttonGuess.setEnabled(false);

        answeredQuestions++;
    }

    public void showRandomCity(){
        cityImageView.setImageResource(citiesArray[answeredQuestions].getCityImage());
        correctAnswer = citiesArray[answeredQuestions].getCityName();
    }

    public void shuffleCities(){
        Collections.shuffle(Arrays.asList(citiesArray));
    }
}