package com.example.quizApp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        EditText editTextNumber1 = findViewById(R.id.etNumber1);
        EditText editTextNumber2 = findViewById(R.id.etNumber2);
        EditText editTextNumberResult = findViewById(R.id.etResult);

        Button buttonAdd = findViewById(R.id.btAdd);
        Button buttonSubs = findViewById(R.id.btSubstract);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTextNumber1.getText()) || TextUtils.isEmpty(editTextNumber2.getText())) {
                    Toast.makeText(CalculatorActivity.this, "Please enter values", Toast.LENGTH_SHORT).show();
                    return;
                }
                int n1 = Integer.parseInt(editTextNumber1.getText().toString());
                int n2 = Integer.parseInt(editTextNumber2.getText().toString());

                editTextNumberResult.setText(String.valueOf(n1 + n2));
            }
        });
        buttonSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTextNumber1.getText()) || TextUtils.isEmpty(editTextNumber2.getText())) {
                    Toast.makeText(CalculatorActivity.this, "Please enter values", Toast.LENGTH_SHORT).show();
                    return;
                }
                int n1 = Integer.parseInt(editTextNumber1.getText().toString());
                int n2 = Integer.parseInt(editTextNumber2.getText().toString());

                editTextNumberResult.setText(String.valueOf(n1 - n2));
            }
        });
    }
}