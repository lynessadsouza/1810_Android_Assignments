package com.example.snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    TextInputEditText itemnames;
    MaterialButton saveitems;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    TextInputEditText editText;
    MaterialButton button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("hi");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);




        student();

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getApplicationContext(), Itemclass.itemmm);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate menu items here
        getMenuInflater().inflate(R.menu.actionbtns, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.reload:
                Itemclass.itemmm.clear();
                recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
                recyclerView.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(this);
                student();
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getApplicationContext(), Itemclass.itemmm);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.setLayoutManager(layoutManager);
        }
        return super.onOptionsItemSelected(item);
    }
    private void student() {
        Itemclass.itemmm.add(new ItemModel("Lynessa", "Female", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Tanvi", "Female", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Ankita", "Female", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Poonam", "Female", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Analise", "Female", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Shabri", "Female", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Akshaya", "Female", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Geefan", "Female", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Natasha", "Female", R.drawable.ic_edit, R.drawable.ic_delete));


        Itemclass.itemmm.add(new ItemModel("Leejoan ","Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Lyndon", "Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Yogesh", "Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Celvin", "Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Sai", "Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Agnelo", "Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Daniel", "Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Nathan", "Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Shubham", "Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Vishwanath", "Male", R.drawable.ic_edit, R.drawable.ic_delete));
        Itemclass.itemmm.add(new ItemModel("Vinay", "Male", R.drawable.ic_edit, R.drawable.ic_delete));








    }
}