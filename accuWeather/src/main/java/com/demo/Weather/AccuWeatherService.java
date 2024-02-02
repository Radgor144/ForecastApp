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


    CouldCover couldCover = new CouldCover();

    public List<WeatherData> getWeatherData(String cityName) {
        Connection connection = new Connection(cityName);
        return couldCover.CloudcoverBy12Hours(connection);
    }

}
