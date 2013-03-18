package org.callistasoftware.example.util;

import static org.junit.Assert.assertEquals;

import org.callistasoftware.example.model.MovieInfo;
import org.codehaus.jackson.JsonNode;
import org.junit.Test;
import org.mockito.Mockito;

public class TheMovieDBMovieParserTest {

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
