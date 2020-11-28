package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
  //  Profile myProfile = new Profile();
    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;


    DBClient dbClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Profile myProfile = new Profile();
        String nname = myProfile.getName();
        String pphone = myProfile.getPhone();
        String eemail = myProfile.getEmail();
        String ppassword = myProfile.getPassword();
        String ccpass = myProfile.getConfirm_pass();
        String ggender=myProfile.getGender();
        String sstate=myProfile.getState();
        String ddistrict=myProfile.getDistrict();
        String ddob=myProfile.getDob();

        dbClient = new DBClient(this);
        dbClient.open();
        dbClient.addUser(nname,pphone,eemail,ppassword,ccpass,ggender,sstate,ddistrict,ddob);


        Toast.makeText(getApplicationContext(),"User Saved Successfully", Toast.LENGTH_LONG).show();
        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Page1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page2"));
     //   tabLayout.addTab(tabLayout.newTab().setText("Page3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}