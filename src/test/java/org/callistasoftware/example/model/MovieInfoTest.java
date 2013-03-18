package org.callistasoftware.example.model;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MovieInfoTest {

    @Test
    public void ifCreatedWithTitlePosterIsNull() throws Exception {
        MovieInfo movieInfo = new MovieInfo("The title");
        assertNull(movieInfo.getPoster());
    }

}
