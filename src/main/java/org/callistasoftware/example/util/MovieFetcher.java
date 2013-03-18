package org.callistasoftware.example.util;

import java.util.List;

import org.callistasoftware.example.model.MovieInfo;

public interface MovieFetcher {
    public List<MovieInfo> getMovies(String title) throws Exception;
}
