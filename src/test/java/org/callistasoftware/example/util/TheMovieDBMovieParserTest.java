package org.callistasoftware.example.util;

import static org.junit.Assert.assertEquals;

import org.callistasoftware.example.model.MovieInfo;
import org.codehaus.jackson.JsonNode;
import org.junit.Test;
import org.mockito.Mockito;

public class TheMovieDBMovieParserTest {

    // Example json node
    // {"adult":false,"backdrop_path":"/gM3KKiN80qbJgKHjPnmAfwxSicG.jpg","id":603,"original_title":"The Matrix","release_date":"1999-03-30","poster_path":"/gynBNzwyaHKtXqlEKKLioNkjKgN.jpg","popularity":9.620000000000001,"title":"The Matrix","vote_average":9.0,"vote_count":328}

    @Test
    public void test() {
        JsonNode node = Mockito.mock(JsonNode.class);
        JsonNode valueNode = Mockito.mock(JsonNode.class);
        Mockito.when(node.get("?")).thenReturn(valueNode);
        Mockito.when(valueNode.getValueAsText()).thenReturn("value");
        
        MovieInfo movie = TheMovieDBMovieParser.build(node);
        assertEquals("value", movie.getTitle());
    }

}
