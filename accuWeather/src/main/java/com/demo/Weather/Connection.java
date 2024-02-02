package com.demo.Weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    public Connection() {
    }

    public JsonNode Json() {
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/krakow?unitGroup=metric&include=fcst%2Chours%2Cdays%2Ccurrent%2Cevents%2Calerts&key=AM9ZTRLEYSXEF4YT5E79H7GBJ&contentType=json";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.body());

            return rootNode;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
