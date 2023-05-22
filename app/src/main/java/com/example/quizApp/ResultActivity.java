package com.example.quizApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

public class ResultActivity extends AppCompatActivity {

    private Button buttonNewQuiz, buttonFinish;

    private TextView tvCongratulations, tvScore;
    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        buttonNewQuiz = findViewById(R.id.btnTakeNewQuize);
        buttonFinish = findViewById(R.id.btnFinish);
        tvCongratulations = findViewById(R.id.tv_congratulation);
        tvScore = findViewById(R.id.tv_score);
        name = getIntent().getStringExtra("name");
        String score = getIntent().getStringExtra("score");

        tvCongratulations.setText("Congratulation "+ name);
        tvScore.setText("Your score "+ score);


        buttonNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, EnterActivity.class);
                intent.putExtra("name", name);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0); // quit application
            }
        });

    }
}