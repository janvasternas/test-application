package org.callistasoftware.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.callistasoftware.example.model.MovieInfo;
import org.codehaus.jackson.JsonParseException;

public class StaticMovieFetcher implements MovieFetcher {

    private static final List<MovieInfo> movies = new ArrayList<MovieInfo>();
    static {
        for (int i = 1; i < 12; i ++) {
            movies.add(new MovieInfo("Title " + i));
        }
    }
    
    public List<MovieInfo> getMovies(String title) throws IOException, JsonParseException {
        return movies;
    }
}
