package org.lessons.java.bestoftheyear.model;

public class Media {
    private int id;
    private String title;


    public Media(int id, String title) throws IllegalArgumentException {
        if (id < 0) throw new IllegalArgumentException("Your id must be greater than 0");
        if (title.isBlank()) throw  new IllegalArgumentException("The title must not be empty");
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws IllegalArgumentException{
        if (id < 0) throw new IllegalArgumentException("Your id must be greater than 0");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException{
        if (title.isBlank()) throw  new IllegalArgumentException("The title must not be empty");
        this.title = title;
    }

    @Override
    public String toString() {
        return
                "id: "+ id +
                "title: " + title ;
    }
}
