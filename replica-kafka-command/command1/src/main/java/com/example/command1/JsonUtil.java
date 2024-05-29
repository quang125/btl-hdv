package com.example.command1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author QuangNN
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {
    public static ObjectMapper MAPPER = new ObjectMapper();
    static {
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssXXX");
        MAPPER.setDateFormat(df);
        MAPPER.registerModule(new JavaTimeModule());
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonProcessingException {
        return MAPPER.readValue(json, classOfT);
    }

    public static String toJson(Object object) throws JsonProcessingException {
        return MAPPER.writeValueAsString(object);
    }

    public static Map<String, Object> readFromJson(String json) throws JsonProcessingException {
        return MAPPER.readValue(json, Map.class);
    }
    public static List<String> fromJsonList(String json) throws JsonProcessingException {
        JsonNode jsonNode = new ObjectMapper().readTree(json);
        return fromJsonNode(jsonNode);
    }
    private static List<String>fromJsonNode(JsonNode jsonNode){
        List<String> result = new ArrayList<>();
        for (JsonNode element : jsonNode) {
            result.add(element.toString());
        }
        return result;
    }
}