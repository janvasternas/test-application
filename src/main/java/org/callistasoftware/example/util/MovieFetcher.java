package org.callistasoftware.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MovieFetcher {
    
    public final static String url = "http://api.themoviedb.org/3/search/movie?query={query}&api_key={key}";

    private final RestTemplate template = new RestTemplate();

    private String key;

    public void setKey(String key) {
        this.key = key;        
    }
    
    public MovieFetcher() {
        ArrayList<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
        list.add(new StringHttpMessageConverter());
        template.setMessageConverters(list);
    }
    
    public String getMovieJSON(String title) throws IOException, JsonParseException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("key", key);
        params.put("query", title);
        String jsonText = template.getForObject(url, String.class, params);
        return jsonText;
    }


}
