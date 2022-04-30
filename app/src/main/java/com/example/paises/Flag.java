package com.example.paises;

public class Flag {
    private String title;
    private String imageUrl;


    public Flag(String t, String imageUrl){
        this.title=t;
        this.imageUrl=imageUrl;
    }

    public String getTitle() {
        return title;
    }
    public String getimageUrl() {
        return imageUrl;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setimageUrl(String thumb) {
        this.imageUrl = thumb;
    }
}
