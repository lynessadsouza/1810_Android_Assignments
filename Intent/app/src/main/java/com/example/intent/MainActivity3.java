package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity
{
    TextView user ,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        user=(TextView)findViewById(R.id.textview10);
        pass=(TextView)findViewById(R.id.textview_pasword);

        Intent snintent=getIntent();

        String usernamee= snintent.getStringExtra("Final_name");
        String passwordd=snintent.getStringExtra("Final_password");

        user.setText("Your name is "+usernamee);
        pass.setText("Password is" +passwordd);


    }
}
