package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class tab1 extends Fragment
{
    TextInputEditText name , phone , email , password , cpass;

   String nname=Profile.getName();
   String pphone=Profile.getPhone();
    String eemail=Profile.getEmail();
    String ppassword=Profile.getPassword();
    String ccpass=Profile.getConfirm_pass();



    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_tab1, container, false);

      //  Toast toast=Toast.makeText(getContext(),"Hello Javatpoint",Toast.LENGTH_SHORT);
        // toast.setMargin(50,50);
        //toast.show();

        name=(TextInputEditText)view.findViewById(R.id.Nameper);
        phone=(TextInputEditText)view.findViewById(R.id.Phonenumper);
        email=(TextInputEditText)view.findViewById(R.id.emailper);
        password=(TextInputEditText)view.findViewById(R.id.passwordper);
        cpass=(TextInputEditText)view.findViewById(R.id.cpassper);

        Toast.makeText(getContext(),""+ppassword,Toast.LENGTH_LONG).show();
        name.setText(nname);
        phone.setText(pphone);
        email.setText(eemail);
      password.setText(ppassword);

        cpass.setText(ccpass);



        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return view;





    }

}