package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private static final String LogcatTag = "CALCULATOR_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LogcatTag, "Button have been pushed");
                calculateAnswer();
            }
        });

    }

    private void calculateAnswer() {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton subtract = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "All views have been founded");

        float numone = Integer.parseInt(numOne.getText().toString());
        float numtwo = Integer.parseInt(numTwo.getText().toString());

        Log.d(LogcatTag, "Successfully grabbed date from input fields");
        Log.d(LogcatTag, "numone is: " + numone + " ; "+" numtwo is: " + numtwo);

        float result = 0;

        if(add.isChecked()){
            Log.d(LogcatTag, "Opetation is add");
            result = numone + numtwo;
        }

        if(subtract.isChecked()){
            Log.d(LogcatTag, "Opetation is subtract");
            result = numone - numtwo;
        }

        if(multiply.isChecked()){
            Log.d(LogcatTag, "Opetation is multiply");
            result = numone * numtwo;
        }

        if(divide.isChecked()){
            Log.d(LogcatTag, "Opetation is divide");
            if (numtwo == 0){
                Toast.makeText(this, "Number two Cannot be zero", Toast.LENGTH_SHORT).show();
                return;
            }
            result = numone / numtwo;
        }

        Log.d(LogcatTag, "The result of operations is: " + result);
        answer.setText("The answer is " + result);

    }
}