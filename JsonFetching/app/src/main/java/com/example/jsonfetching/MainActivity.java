package com.example.jsonfetching;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button click;
    public  static TextView data;


    public  static TextView sal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.fetcheddata);

        sal = (TextView) findViewById(R.id.salary);

        fetchdata process = new fetchdata();
        process.execute();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     Toast.makeText(getApplicationContext(),"Hi ", Toast.LENGTH_LONG).show();
               calculatesalary process1 = new calculatesalary();
                process1.execute();
                click.setVisibility(View.INVISIBLE);

            }
        });
    }
}

