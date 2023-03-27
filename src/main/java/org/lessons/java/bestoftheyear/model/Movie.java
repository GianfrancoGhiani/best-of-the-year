package org.lessons.java.bestoftheyear.model;

public class Movie extends Media{
    private int minDuration;
    private String director;

    public Movie(int id, String title, int minDuration, String director) throws IllegalArgumentException {
        super(id, title);
        if (minDuration <= 0) throw new IllegalArgumentException("The movie must have at least 1 min of duration");
        if (director.isBlank()) throw new IllegalArgumentException("The director field cannot be empty");
        this.minDuration = minDuration;
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) throws IllegalArgumentException {
        if (director.isBlank()) throw new IllegalArgumentException("The director field cannot be empty");
        this.director = director;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(int minDuration) throws IllegalArgumentException {
        if (minDuration <= 0) throw new IllegalArgumentException("The movie must have at least 1 min of duration");
        this.minDuration = minDuration;
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

        return "director: " + director + ", " +  super.toString() + ", duration (min): " + minDuration;
    }
}
