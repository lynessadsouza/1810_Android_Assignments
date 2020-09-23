package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText e1;
    Button clickme;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.editText);

        clickme=(Button)findViewById(R.id.click);

        clickme.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name= e1.getText().toString().trim();

                Intent i= new Intent(MainActivity.this,Main2Activity.class);

                i.putExtra("new_name",name);
                startActivity(i);

            }
        });


    }
}
