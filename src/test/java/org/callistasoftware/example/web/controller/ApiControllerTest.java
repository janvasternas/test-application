package org.callistasoftware.example.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.callistasoftware.example.model.MovieInfo;
import org.callistasoftware.example.util.MovieFetcher;
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
    public void test() throws Exception {
        List<MovieInfo> list = Collections.singletonList(new MovieInfo("The Title"));
        when(fetcher.getMovies("the title")).thenReturn(list);
        List<MovieInfo> found = controller.search("the title");
        assertEquals(list, found);
    }

}
