package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import java.util.Calendar;

public class tab2 extends Fragment

{
 MaterialTextView uname;
    TextInputEditText  state;

    DatePickerDialog datepicker;
    EditText dob;
    String date1;

    String uuname=Profile.getName();
    String ggender=Profile.getGender();
     String sstate=Profile.getState();
    String ddistrict=Profile.getDistrict();
    String ddob=Profile.getDob();
    //String ccpass=Profile.getConfirm_pass();

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
       // Toast toast=Toast.makeText(getContext(),"page2",Toast.LENGTH_SHORT);
        // toast.setMargin(50,50);
        //toast.show();
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        View view = inflater.inflate(R.layout.activity_tab2, container, false);

        RadioGroup gender_rg = (RadioGroup) view.findViewById(R.id.radiogroup);
        state=(TextInputEditText)view.findViewById(R.id.state);
        Spinner spinner = (Spinner) view.findViewById(R.id.District);

        uname=(MaterialTextView)view.findViewById(R.id.username);
        uname.setText(uuname);

        dob=(EditText)view.findViewById(R.id.dob_1);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                datepicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {



                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dob.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                        date1= dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                    }
                }, year, month, day);
                datepicker.show();
            }

        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.setSelection(i);
            //    Toast.makeText(getContext(),""+i, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (ggender=="male")
        {
            gender_rg.check(R.id.male);
        }
       // Toast.makeText(getContext(),"hi "+ggender,Toast.LENGTH_LONG).show();
        if (ggender=="female")
        {
            gender_rg.check(R.id.female);
        }
        if (ggender=="others")
        {
            gender_rg.check(R.id.other);
        }

        state.setText(sstate);

       if (ddistrict == "North Goa")
            spinner.setSelection(0);
        if (ddistrict == "South Goa")
            spinner.setSelection(1);
        dob.setText(ddob);




        return view;
    }


}