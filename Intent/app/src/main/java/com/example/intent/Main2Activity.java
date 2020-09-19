package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity
{
    TextView uname;
    EditText pass;
    Button passbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        uname=(TextView)findViewById(R.id.textView);
        pass=(EditText)findViewById(R.id.editText);
        passbtn=(Button)findViewById(R.id.button2);

        Intent i =getIntent();
         String final_name= i.getStringExtra("new_name");
        uname.setText(final_name);

        passbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String userrname=uname.getText().toString().trim();
                String password=pass.getText().toString().trim();



                Intent secondIntent= new Intent(Main2Activity.this,Main3Activity.class);
                secondIntent.putExtra("Final_name", userrname);
                secondIntent.putExtra("Final_pass",password);

                startActivity(secondIntent);

            }
        });



    }
}
