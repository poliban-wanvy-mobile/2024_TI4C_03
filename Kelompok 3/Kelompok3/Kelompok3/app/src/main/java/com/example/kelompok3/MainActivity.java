package com.example.kelompok3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tvQuestion;
    private EditText etAnswer;
    private TextView tvResult;
    private Spinner spinnerOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuestion = findViewById(R.id.tvQuestion);
        etAnswer = findViewById(R.id.etAnswer);
        tvResult = findViewById(R.id.tvResult);
        spinnerOperation = findViewById(R.id.spinnerOperation);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        Button btnBiodata = findViewById(R.id.btnBiodata);
        Button btnGenerate = findViewById(R.id.btnGenerate);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewQuestion();
            }
        });

        btnSubmit.setOnClickListener(v -> checkAnswer());
        btnBiodata.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, BiodataActivity.class));
        });

        generateNewQuestion();
    }

    private void generateNewQuestion() {
        Random rand = new Random();
        int number1 = rand.nextInt(10) + 1;
        int number2 = rand.nextInt(9) + 1;
        String currentOperation = spinnerOperation.getSelectedItem().toString();
        int correctAnswer = 0;

        switch (currentOperation) {
            case "Pertambahan":
                correctAnswer = number1 + number2;
                tvQuestion.setText(getString(R.string.question_template, number1, "+", number2));
                break;
            case "Pengurangan":
                correctAnswer = number1 - number2;
                tvQuestion.setText(getString(R.string.question_template, number1, "-", number2));
                break;
            case "Perkalian":
                correctAnswer = number1 * number2;
                tvQuestion.setText(getString(R.string.question_template, number1, "*", number2));
                break;
            case "Pembagian":
                correctAnswer = number1 / number2;
                tvQuestion.setText(getString(R.string.question_template, number1, "/", number2));
                break;
        }

        tvQuestion.setTag(correctAnswer);
    }

    private void checkAnswer() {
        String answerText = etAnswer.getText().toString();
        if (!answerText.isEmpty()) {
            int userAnswer = Integer.parseInt(answerText);
            int correctAnswer = (int) tvQuestion.getTag();

            if (userAnswer == correctAnswer) {
                tvResult.setText(R.string.correct);
            } else {
                tvResult.setText(getString(R.string.wrong_answer_template, correctAnswer));
            }
            etAnswer.setText("");
        } else {
            tvResult.setText(R.string.enter_answer);
        }
    }
}