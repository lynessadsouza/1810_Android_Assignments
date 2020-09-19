package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity
{
    TextView namep;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        namep=(TextView)findViewById(R.id.textView);

        Intent secondIntent=getIntent();

        String username=secondIntent.getStringExtra("Final_name");

        Toast toast= Toast.makeText(getApplicationContext(),""+username,Toast.LENGTH_LONG);
        toast.show();

       // String password=secondIntent.getStringExtra("Final_pass");


        namep.setText(username);



    }
}
