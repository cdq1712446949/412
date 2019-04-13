package com.example.machenike.a412;

public class MyItem {

    private String name;
    private double price;
    private int image_id;
    private int number=0;

    public MyItem(){

    }

    public MyItem(String name,double price,int image_id){
        this.name=name;
        this.price=price;
        this.image_id=image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
