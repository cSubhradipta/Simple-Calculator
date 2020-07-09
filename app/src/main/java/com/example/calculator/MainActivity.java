package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button decimal;
    private Button percent;
    private Button add;
    private Button sub;
    private Button div;
    private Button multiply;
    private Button equal;
    private Button clear;
    private Button del;
    private TextView result;
    private TextView control;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = 'x';
    private final char DIVISION = '/';
    private final char PERCENT = '%';
    private final char EQUALTO = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIviews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + "9");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setText(control.getText().toString() + ".");
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = ADDITION;
                control.setText(String.valueOf(val1) + " + ");
                control.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = SUBTRACTION;
                control.setText(String.valueOf(val1) + " - ");
                control.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = MULTIPLICATION;
                control.setText(String.valueOf(val1) + " x ");
                control.setText(null);

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = DIVISION;
                control.setText(String.valueOf(val1) + " / ");
                control.setText(null);
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = PERCENT;
                control.setText(String.valueOf(val1) + " % ");
                result.setText(String.valueOf(val1/100));
                control.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = EQUALTO;
                result.setText(String.valueOf(val1));
                control.setText(null);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (control.getText().length() > 0){
                    CharSequence name = control.getText().toString();
                    control.setText(name.subSequence(0, name.length()-1));
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                control.setText(null);
                result.setText(null);
            }
        });



    }

    private void setupUIviews() {
        zero = (Button)findViewById(R.id.button_0);
        one = (Button)findViewById(R.id.button_1);
        two = (Button)findViewById(R.id.button_2);
        three = (Button)findViewById(R.id.button_3);
        four = (Button)findViewById(R.id.button_4);
        five = (Button)findViewById(R.id.button_5);
        six = (Button)findViewById(R.id.button_6);
        seven = (Button)findViewById(R.id.button_7);
        eight = (Button)findViewById(R.id.button_8);
        nine = (Button)findViewById(R.id.button_9);
        decimal = (Button)findViewById(R.id.button_dot);
        percent = (Button)findViewById(R.id.button_percentage);
        add = (Button)findViewById(R.id.button_add);
        sub = (Button)findViewById(R.id.button_subtract);
        div = (Button)findViewById(R.id.button_divide);
        multiply = (Button)findViewById(R.id.button_multiply);
        equal = (Button)findViewById(R.id.button_result);
        clear = (Button)findViewById(R.id.button_cancel);
        del = (Button)findViewById(R.id.button_delete);
        control = (TextView)findViewById(R.id.control);
        result = (TextView)findViewById(R.id.result);

    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(control.getText().toString());

            switch(ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;

                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;

                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;

                case DIVISION:
                    val1 = val1 / val2;
                    break;

                case PERCENT:
                    val1 = val1 % 100;
                    break;

                case EQUALTO:
                    break;
            }
        }

        else{

            val1 = Double.parseDouble(control.getText().toString());
        }
    }
}