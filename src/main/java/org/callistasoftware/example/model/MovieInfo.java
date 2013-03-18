package org.callistasoftware.example.model;

import org.codehaus.jackson.JsonNode;

public class MovieInfo {

    private final String title;
    private final String poster;
    
    public MovieInfo(String title, String poster) {
        this.title = title;
        this.poster = poster;
    }
    public static MovieInfo parse(JsonNode data) {
        String title = getFieldValue(data, "title");
        String poster = getFieldValue(data, "poster_path");
        return new MovieInfo(title, poster);
    }

    public String getTitle() {
        return title;
    }
    
    public String getPoster() {
        return poster;
    }

    private static String getFieldValue(JsonNode data, String name) {
        return data.get(name).getValueAsText();
    }
}
