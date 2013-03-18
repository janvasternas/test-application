package org.callistasoftware.example.model;

import static org.junit.Assert.assertEquals;

import org.callistasoftware.example.util.JSONHelper;
import org.codehaus.jackson.JsonNode;
import org.junit.Ignore;
import org.junit.Test;

public class MovieInfoTest {

    private static final String JSON = "{\"adult\":false,\"backdrop_path\":\"/backdrop.jpg\",\"id\":1234567,\"original_title\":\"Original title\",\"release_date\":\"2002-06-25\",\"poster_path\":\"/poster.jpg\",\"popularity\":0.8,\"title\":\"Title\",\"vote_average\":7.5,\"vote_count\":1}";

    @Test
    public void parseTitle() throws Exception {
        JsonNode jsonNode = JSONHelper.parseJson(JSON);
        MovieInfo movieInfo = MovieInfo.parse(jsonNode);
        assertEquals("Title", movieInfo.getTitle());
        assertEquals("/poster.jpg", movieInfo.getPoster());
    }

    @Test
    @Ignore("Not used yet")
    public void parsePoster() throws Exception {
        JsonNode jsonNode = JSONHelper.parseJson(JSON);
        MovieInfo movieInfo = MovieInfo.parse(jsonNode);
        assertEquals("/poster.jpg", movieInfo.getPoster());
    }
}
