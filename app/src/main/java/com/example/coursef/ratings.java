package com.example.coursef;

public class ratings {
    private String title;
    public String id;


    private  String rating;


    public ratings(String id, String title, String rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;

    }

    public String getId() {
        return id;
    }

    public  String getTitle() {
        return title;
    }


    public  String getRating() {
        return rating;
    }


}

