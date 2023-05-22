package com.example.quizApp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private Button[] buttonAnswers = new Button[4];

    private ProgressBar progressBar;
    private TextView textViewQuestion1, textViewProgress;
    private List<Questions> questionsList;

    private int[] answers = new int[4];
    private Button btnSubmit, btnCalculator;

    private int correctAnswer = 0;
    private int questionIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        progressBar = findViewById(R.id.progressbar);
        textViewProgress = findViewById(R.id.tvProgress);
        buttonAnswers[0] = findViewById(R.id.btnAns1);
        buttonAnswers[1] = findViewById(R.id.btnAns2);
        buttonAnswers[2] = findViewById(R.id.btnAns3);
        buttonAnswers[3] = findViewById(R.id.btnAns4);

        textViewQuestion1 = findViewById(R.id.tv_q1);

        btnSubmit = findViewById(R.id.btnSubmit);

        populateQuestionModel();

        showQuestions(questionIndex);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (questionIndex < questionsList.size()-1){
                   checkAnswer();
                   questionIndex++;
                   showQuestions(questionIndex);
               } else {
                   btnSubmit.setText("Submit");
                   Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                   intent.putExtra("name", getIntent().getStringExtra("name"));
                   intent.putExtra("score", correctAnswer + "/" + questionsList.size());
                   startActivity(intent);
               }
            }
        });
    }

    private void checkAnswer() {
        for (int i = 0; i < buttonAnswers.length; i++) {
            buttonAnswers[i].setEnabled(false);
            if (questionsList.get(questionIndex).getCorrectAns() == i){
               buttonAnswers[i].setBackgroundColor(getResources().getColor(R.color.teal_700));
            } else {
                buttonAnswers[i].setBackgroundColor(getResources().getColor(R.color.red));
            }
        }
        if (buttonAnswers[questionsList.get(questionIndex).getCorrectAns()].isPressed()){
            correctAnswer++;
        }
    }

    private void populateQuestionModel() {
        questionsList = new ArrayList<>();
        Questions questions = new Questions("What is capital of Australis", Arrays.asList("Canbera", "Sydney", "Perth", "Adelaid"), 0);
        Questions questions1 = new Questions("What is capital of India", Arrays.asList("Mumbai", "New Delhi", "Pune", "Nagpur"), 1);
        Questions questions2 = new Questions("What is capital of England", Arrays.asList("Glasgow", "Leads", "Bristol", "London"), 3);
        Questions questions3 = new Questions("What is capital of USA", Arrays.asList("Chicago",
                "Newyork", "Washington", "LA"), 2);

        questionsList.add(questions);
        questionsList.add(questions1);
        questionsList.add(questions2);
        questionsList.add(questions3);

        progressBar.setMax(questionsList.size());
    }

    private void showQuestions(int questionIndex) {
        //Question
        textViewQuestion1.setText(questionsList.get(this.questionIndex).getQuestion());

        //answer
        List<String> options = questionsList.get(questionIndex).getOptions();
        for (int i = 0 ; i < options.size(); i++ ){
            buttonAnswers[i].setText(options.get(i));
            buttonAnswers[i].setBackgroundColor(getResources().getColor(R.color.white));
            buttonAnswers[i].setEnabled(true);
            buttonAnswers[i].setOnClickListener(null);
            buttonAnswers[i].setOnClickListener(v -> checkAnswer());
        }
        int progress = questionIndex + 1;
        progressBar.setProgress(progress);
        textViewProgress.setText("Question "+progress +"of" + questionsList.size());

    }

    public void addRadioButtons(RadioGroup radioGroup, List<String> options, int correctAnsIndex) {
        radioGroup.setOrientation(LinearLayout.VERTICAL);
        //
        for (int i = 0; i < 4; i++) {
            RadioButton rdbtn = new RadioButton(this);
            rdbtn.setId(i);
            rdbtn.setText(options.get(i));
            int finalI = i;
            rdbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (!isChecked){
                        return;
                    }
                    if (finalI == correctAnsIndex){
                        Log.d("AnsIndexCorrect ", options.get(finalI));
                        answers[finalI] = 1;
                    }
                }
            });
            radioGroup.addView(rdbtn);
        }
    }

}