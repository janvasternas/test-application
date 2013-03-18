package org.callistasoftware.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.callistasoftware.example.model.MovieInfo;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;

public class TheMovieDBMovieParser {

    //private static final String IMG_BASE_PATH = "http://d3gtl9l2a4fn1j.cloudfront.net/t/p/w185";

    public static MovieInfo build(JsonNode data) {
        String title = getFieldValue(data, "?");
        //String poster = IMG_BASE_PATH + getFieldValue(data, "poster_path");
        return new MovieInfo(title);
    }
    
    private static String getFieldValue(JsonNode data, String name) {
        return data.get(name).getValueAsText();
    }

    @SuppressWarnings("deprecation")
    private static JsonNode parseJson(String ent) throws IOException, JsonParseException {
        JsonNode node = new org.codehaus.jackson.map.TreeMapper().readTree(ent);
        return node;
    }

    public static List<MovieInfo> parse(String jsonText) throws Exception {
        JsonNode jsonNode = parseJson(jsonText);
        Iterator<JsonNode> iterator = jsonNode.get("results").iterator();
        List<MovieInfo> result = new ArrayList<MovieInfo>();
        while (iterator.hasNext()) {
            result.add(build(iterator.next()));
        }
        return result;
    }
}
