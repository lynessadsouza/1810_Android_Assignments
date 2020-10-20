package com.example.mychatfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity  {
MaterialButton prevpg;
    private RecyclerView.Adapter mmAdapter;

    RecyclerView.LayoutManager layoutManager1;

    RecyclerView recyclerView1;

    MaterialButton sendmsg2;
    TextInputEditText recmsg;




    List<senderwrapper> smsgs;

    List<recwrapper> rrmsgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        smsgs= new ArrayList<>();
       rrmsgs= new ArrayList<>();


        recyclerView1=(RecyclerView)findViewById(R.id.recyclerview);
        layoutManager1= new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager1);

        sendmsg2 = (MaterialButton) findViewById(R.id.sendmsg2);



        prevpg=(MaterialButton)findViewById(R.id.prevpage);
        prevpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent prepg= new Intent(MainActivity2.this,MainActivity.class);
                startActivity(prepg);
            }
        });

        sendmsg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recmsg=(TextInputEditText)findViewById(R.id.recmsg);
                String msg1 = recmsg.getText().toString().trim();

                smsgs.add( new senderwrapper(MyChatAdapter.View_type_sen,msg1));

                rrmsgs.add(new recwrapper(MyChatAdapter2.View_type_rec,msg1));
                recmsg.setText("");
                mmAdapter= new MyChatAdapter2(rrmsgs);
                recyclerView1.setAdapter(mmAdapter);

            }
        });
        mmAdapter=new MyChatAdapter2(rrmsgs);
        recyclerView1.setAdapter(mmAdapter);
    }
}