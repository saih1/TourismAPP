package com.saihtoo.tourismapp;

public class Destinations {
    int id, image; String title, description;

    public Destinations(int id, int image, String title, String description) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public int getImage()
    {
        return image;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }
}
