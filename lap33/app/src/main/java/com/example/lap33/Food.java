package com.example.lap33;

public class Food {
    private String name;
    private int image;
    private String description;
    private int price;

    public Food(String name, int image, String description, int price) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public String getName() { return name; }
    public int getImage() { return image; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
}
