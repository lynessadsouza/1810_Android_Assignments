package com.example.viewpager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DBClient {
    UserDBHelper dbhelper;
    Context context;
    SQLiteDatabase database;
    ArrayList<String> users;

    public  DBClient(Context context){
        this.context = context;
    }

    public void open(){
        dbhelper = new UserDBHelper(context);
        database = dbhelper.getWritableDatabase();
    }
    public void close(){
        dbhelper.close();
    }

    public ArrayList<String> getuser(){
        String query="select * from users";
        Cursor cursor = database.rawQuery(query,null);
        if(cursor!=null&&cursor.getCount()>0) {
            cursor.moveToFirst();
            users = new ArrayList<>();
            users.add(cursor.getString(0));
            users.add(cursor.getString(1));
            users.add(cursor.getString(2));
            users.add(cursor.getString(3));
            users.add(cursor.getString(4));
            users.add(cursor.getString(5));
            users.add(cursor.getString(6));
            users.add(cursor.getString(7));
            users.add(cursor.getString(8));
            cursor.close();
            return users;
        }
        else
            return null;
    }

    public void addUser(String username,String phoneno,String email,String password,String cpassword,String gender, String state, String district, String dob){
        ContentValues params = new ContentValues();
        params.put("name",username);
        params.put("phone",phoneno);
        params.put("email",email);
        params.put("password",password);
        params.put("confirm_pass",cpassword);
        params.put("gender",gender);
        params.put("state",state);
        params.put("district",district);
        params.put("dob",dob);



        database.insert("users",null,params);

        Toast.makeText(context,"Stored", Toast.LENGTH_LONG).show();
    }
}