package com.example.mychatfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView.Adapter mAdapter;

    RecyclerView.LayoutManager layoutManager;

    MaterialButton nxtpg;

    //   LinearLayout myLinearLayout;
    MaterialButton sendmsg;
    TextInputEditText sendermsg;


    List<senderwrapper> smsgs;
    List<recwrapper> rmsgs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smsgs= new ArrayList<>();
        rmsgs= new ArrayList<>();

     //  LayoutInflater layoutInflater=LayoutInflater.from(this);

        nxtpg = (MaterialButton) findViewById(R.id.nextpage);
        sendmsg = (MaterialButton) findViewById(R.id.sendmsg);

        //   final ArrayList<senderwrapper> msgs= senderwrapper.getI

       // MyChatAdapter chatAdapter= new MyChatAdapter(this, smsgs);

        RecyclerView recyclerView= (RecyclerView)findViewById(R.id.recyclerview);


        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        nxtpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent np = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(np);
            }
        });


        sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendermsg = (TextInputEditText) findViewById(R.id.sendermsg);
                String msg = sendermsg.getText().toString().trim();
              //  addArray.add(msg);

                rmsgs.add( new recwrapper(MyChatAdapter2.View_type_sen,msg));

                smsgs.add(new senderwrapper(MyChatAdapter.View_type_rec,msg));
                sendermsg.setText("");
                mAdapter= new MyChatAdapter(smsgs);
                recyclerView.setAdapter(mAdapter);



                Toast.makeText(getApplicationContext(),"Zal mugo Save" , Toast.LENGTH_LONG).show();





            }
        });
mAdapter=new MyChatAdapter(smsgs);
recyclerView.setAdapter(mAdapter);


    }
}