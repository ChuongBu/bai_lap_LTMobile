package com.example.lap3buoi2;

public class ContactModel {
    private String name;
    private String phone;
    private int image;

    public ContactModel(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
