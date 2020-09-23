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
         final String final_name= i.getStringExtra("new_name");
        uname.setText(final_name);



        passbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password =pass.getText().toString().trim();
                Intent snintent=new Intent(getApplicationContext(),MainActivity3.class);


                snintent.putExtra("Final_name",final_name);
                snintent.putExtra("Final_password",password);


                startActivity(snintent);
            }
        });

    }



}
