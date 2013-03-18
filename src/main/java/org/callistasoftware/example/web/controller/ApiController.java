package org.callistasoftware.example.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.callistasoftware.example.model.MovieInfo;
import org.callistasoftware.example.util.JSONHelper;
import org.callistasoftware.example.util.MovieFetcher;
import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping(value = "", produces = "application/json")
public class ApiController {
    
    @Autowired
    private MovieFetcher movieFetcher;
    
    @RequestMapping(value = "/search/{title}", method = RequestMethod.GET)
    @ResponseBody
    public List<MovieInfo> search(@PathVariable(value="title") String title) {
        ArrayList<MovieInfo> result = new ArrayList<MovieInfo>();
        try {
            JsonNode node = JSONHelper.parseJson(movieFetcher.getMovieJSON(title));
            Iterator<JsonNode> iterator = node.get("results").iterator();
            while (iterator.hasNext()) {
                result.add(MovieInfo.parse(iterator.next()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
