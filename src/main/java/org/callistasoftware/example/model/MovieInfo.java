package org.callistasoftware.example.model;

public class MovieInfo {

    private final String title;
    private final String poster;
    
    public MovieInfo(String title, String poster) {
        this.title = title;
        this.poster = poster;
    }
    public MovieInfo(String title) {
        this(title, null);
    }

    public String getTitle() {
        return title;
    }
    
    public String getPoster() {
        return poster;
    }

}
