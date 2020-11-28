package com.example.viewpager;



public class Profile {
    static String name;
    static String phone;
    static String email;
    static String password;
    static String confirm_pass;

    static  String gender;
    static  String state;
    static String district;



    static String dob;

    public Profile(){
        this.name="Lyndon";
        this.phone="7873395528";
        this.email="lyn123@gmail.com";
        this.password="45674567";
        this.confirm_pass="45674567";

        this.gender="male";
        this.state="Goa";
        this.district="North Goa";
        this.dob="28 Mar 2010";

    }

    public static String getName(){
        return name;
    }

    public static String getPhone(){
        return phone;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
    public static String getConfirm_pass() {
        return confirm_pass;
    }


    public static String getGender() {
        return gender;
    }

    public static String getState() {
        return state;
    }

    public static String getDistrict() {
        return district;
    }

    public static String getDob() {
        return dob;
    }

}

