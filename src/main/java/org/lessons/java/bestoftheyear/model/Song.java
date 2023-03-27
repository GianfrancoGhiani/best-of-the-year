package org.lessons.java.bestoftheyear.model;

public class Song extends Media{
    private String artist;

    public Song(int id, String title, String artist) throws IllegalArgumentException {
        super(id, title);
        if (artist.isBlank()) throw new IllegalArgumentException("The artist must be specified");
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist.isBlank()) throw new IllegalArgumentException("The artist must be specified");
        this.artist = artist;
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
        return  "artist: "+ artist + ", "+ super.toString();
    }
}
