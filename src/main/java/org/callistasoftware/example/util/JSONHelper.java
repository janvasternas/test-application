package org.callistasoftware.example.util;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.TreeMapper;

@SuppressWarnings("deprecation")
public class JSONHelper {

    public static JsonNode parseJson(String ent) throws IOException, JsonParseException {
        JsonNode node = new TreeMapper().readTree(ent);
        return node;
    }
}
