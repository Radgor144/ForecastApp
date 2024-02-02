package com.demo.Weather;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class CouldCover {

    public CouldCover() {
    }

    public List<WeatherData> CloudcoverBy12Hours(Connection connection) {

        List<WeatherData> weatherDataList = new ArrayList<>();

        JsonNode rootNode = connection.Json();

        for(JsonNode days : rootNode.withArray("days")) {
            String datetime2 = days.get("datetime").asText();
            System.out.println(datetime2);

            for (JsonNode hour : days.withArray("hours")) {

                String datetime = hour.get("datetime").asText();
                Double temperature = hour.get("temp").asDouble();
                Double cloudcover = hour.get("cloudcover").asDouble();

                String Normaldatetime = datetime.substring(0, 5);

                if (temperature == 0.0 ) {
                    continue;
                }

                weatherDataList.add(new WeatherData(Normaldatetime, temperature, cloudcover));

                System.out.println(Normaldatetime + "  " + temperature + "  " + cloudcover);
            }
        }

        return weatherDataList;
    }

}
