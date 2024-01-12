package com.demo.Weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


@Service
public class AccuWeatherService {

    public AccuWeatherService() {}

    public JsonNode Connection() {
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/krakow?unitGroup=metric&include=hours&key=AM9ZTRLEYSXEF4YT5E79H7GBJ&contentType=json";

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
            e.printStackTrace(); // Tutaj można obsłużyć błąd w inny sposób, np. zalogować go lub rzucić własny wyjątek.
            return null;
        }
    }

    public List<WeatherData> getWeatherData() {

        List<WeatherData> weatherDataList = new ArrayList<>();

        JsonNode rootNode = Connection();

        for(JsonNode entry : rootNode.withArray("days")) {
            String datetime = entry.get("datetime").asText();
            Double temperature = entry.get("temp").asDouble();
            Double feelslike = entry.get("feelslike").asDouble();

            weatherDataList.add(new WeatherData(datetime, temperature, feelslike));
        }

        return weatherDataList;
    }
}
