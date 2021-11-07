package com.rocktech.humanbodyorgan;

public class Organ {
    private int id;
    private String title;
    private int image_url;
    private String description;

    public Organ() {
    }

    public Organ(int id, String title, int image_url, String description) {
        this.id = id;
        this.title = title;
        this.image_url = image_url;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Organ{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image_url=" + image_url +
                ", description='" + description + '\'' +
                '}';
    }
}
