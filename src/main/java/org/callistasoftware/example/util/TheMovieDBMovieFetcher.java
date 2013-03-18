package org.callistasoftware.example.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.callistasoftware.example.model.MovieInfo;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class TheMovieDBMovieFetcher implements MovieFetcher {

    public final static String url = "http://api.themoviedb.org/3/search/movie?query={query}&api_key={key}";

    private final RestTemplate template = new RestTemplate();

    private String key;

    public void setKey(String key) {
        this.key = key;        
    }
    
    public TheMovieDBMovieFetcher() {
        ArrayList<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
        list.add(new StringHttpMessageConverter());
        template.setMessageConverters(list);
    }
    
    public List<MovieInfo> getMovies(String title) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("key", key);
        params.put("query", title);
        String jsonText = template.getForObject(url, String.class, params);

        return TheMovieDBMovieParser.parse(jsonText);
    }

}
