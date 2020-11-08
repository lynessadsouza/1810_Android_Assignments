package com.example.snackbar;

public class ItemModel {
    String name;
    String gender;


    int image1;
    int image;

    public ItemModel(String name, String gender, int image1, int image) {
        this.name = name;
        this.gender=gender;
        this.image1 = image1;
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImage1(int ic_edit) {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage(int ic_delete) {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
