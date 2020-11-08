package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    TextInputEditText editText;
    MaterialButton editbtn;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<ItemModel> itm;

    ItemModel temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);




        editText = (TextInputEditText) findViewById(R.id.editeditemname);
        editbtn = (MaterialButton) findViewById(R.id.edit);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getApplicationContext(), Itemclass.itemmm);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);

        Intent i = getIntent();

        int position1 = i.getIntExtra("position", 0);
        String gend = i.getStringExtra("gender");





        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edited = editText.getText().toString();


                    //     Toast.makeText(getApplicationContext(), "" + edited, Toast.LENGTH_LONG).show();
                    Integer image = R.drawable.ic_delete;
                    Integer image1 = R.drawable.ic_edit;

                    ItemModel itemModel = new ItemModel(edited, gend, image1, image);

                    editText.setText("");
                    Itemclass.itemmm.set(position1, itemModel);
                    recyclerAdapter.notifyItemChanged(position1);
                    //Intent i = new Intent(getApplicationContext(), MainActivity. class);
                    // startActivity(i);


            }
        });


    }
}