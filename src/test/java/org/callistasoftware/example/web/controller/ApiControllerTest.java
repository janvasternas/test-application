package org.callistasoftware.example.web.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.List;

import org.callistasoftware.example.model.MovieInfo;
import org.callistasoftware.example.util.MovieFetcher;
import org.codehaus.jackson.JsonParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApiControllerTest {

    @Mock
    private MovieFetcher fetcher;
    
    @InjectMocks
    private final ApiController controller = new ApiController();
    
    @Test
    public void test() throws JsonParseException, IOException {
        when(fetcher.getMovieJSON("the title")).thenReturn("{\"results\": [{\"title\" : \"The Title\", \"poster_path\" : \"/path.jpg\"}]}");
        List<MovieInfo> search = controller.search("the title");
        assertEquals(1, search.size());
        assertEquals("The Title", search.get(0).getTitle());
    }

}
