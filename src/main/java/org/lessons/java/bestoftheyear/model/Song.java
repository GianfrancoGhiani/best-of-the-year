package org.lessons.java.bestoftheyear.model;

public class Song extends Media{
    public Song(int id, String title) throws IllegalArgumentException {
        super(id, title);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) throws IllegalArgumentException {
        super.setId(id);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) throws IllegalArgumentException {
        super.setTitle(title);
    }

    @Override
    public String toString() {
        return  super.toString();
    }
}
