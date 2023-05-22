package com.example.quizApp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

public class EnterActivity extends AppCompatActivity {

    private Button buttonEnter, btnCalculator;

    private EditText etName;

    private String name = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        buttonEnter = findViewById(R.id.btnEnter);
        btnCalculator = findViewById(R.id.btnCalculator);
        etName = findViewById(R.id.et_name);

        name = getIntent().getStringExtra("name");

        if (!TextUtils.isEmpty(name)) {
            etName.setText(name);
        }

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etName.getText().toString())) {
                    Toast.makeText(EnterActivity.this, "Please enter name", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(EnterActivity.this, QuizActivity.class);
                    intent.putExtra("name", etName.getText().toString());
                    startActivity(intent);
                }
            }
        });

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

    }
}