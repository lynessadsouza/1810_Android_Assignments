package com.example.mycal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;
    EditText Result;

    float number1, number2;

    boolean Addition, sub, Mul, Div;

    int   flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        Result = (EditText) findViewById(R.id.edt1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText(Result.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (Result == null)
                {
                    Result.setText("");
                }
                else
                    {
                    number1 = Float.parseFloat(Result.getText() + "");
                    Addition = true;
                    Result.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1 = Float.parseFloat(Result.getText() + "");
                sub = true;
                Result.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1 = Float.parseFloat(Result.getText() + "");
                Mul = true;
                Result.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1 = Float.parseFloat(Result.getText() + "");
                Div = true;
                Result.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number2 = Float.parseFloat(Result.getText() + "");

                if (Addition == true)
                {
                    Result.setText(number1 + number2 + "");
                    Addition = false;
                }

                if (sub == true)
                {
                    Result.setText(number1 - number2 + "");
                    sub = false;
                }

                if (Mul == true)
                {
                    Result.setText(number1 * number2 + "");
                    Mul = false;


                }

                if (Div == true)
                {
                    Result.setText(number1 / number2 + "");
                    Div = false;
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result.setText("");
            }
        });



        button10.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if(flag==0)
                {
                    Result.setText(Result.getText() + ".");
                    flag = 1;
                }
                else
                {
                    Toast toast= Toast.makeText(getApplicationContext(),"Two dot operators are not allowed", Toast.LENGTH_LONG);
                    toast.show();
                }

            }

        });
    }


}
