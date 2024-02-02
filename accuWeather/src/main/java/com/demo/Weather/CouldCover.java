package com.demo.Weather;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CouldCover {

    public CouldCover() {
    }

    public List<WeatherData> CloudcoverBy12Hours(Connection connection) {

        List<WeatherData> weatherDataList = new ArrayList<>();

        JsonNode rootNode = connection.Json();

        String resolvedAddress = rootNode.get("resolvedAddress").asText();

        for(JsonNode days : rootNode.withArray("days")) {
            String datetime2 = days.get("datetime").asText();
            System.out.println(datetime2);

            for (JsonNode hour : days.withArray("hours")) {


                String datetime = hour.get("datetime").asText();
                Double temperature = hour.get("temp").asDouble();
                Double cloudcover = hour.get("cloudcover").asDouble();

                Double precipprob = hour.get("precipprob").asDouble();
                String[] preciptypeArray = new String[0];

                JsonNode preciptypeNode = hour.get("preciptype");
                if (preciptypeNode != null && preciptypeNode.isArray()) {
                    preciptypeArray = new String[preciptypeNode.size()];
                    for (int i = 0; i < preciptypeNode.size(); i++) {
                        preciptypeArray[i] = preciptypeNode.get(i).asText();
                    }
                }

                Double humidity = hour.get("humidity").asDouble();

                String Normaldatetime = datetime.substring(0, 5);

                if (temperature == 0.0 ) {
                    continue;
                }

                weatherDataList.add(new WeatherData(resolvedAddress, Normaldatetime, temperature, cloudcover, precipprob, preciptypeArray, humidity));
                System.out.println(resolvedAddress + " " + Normaldatetime + "  " + temperature + "  " + cloudcover + "  " + precipprob + "  " + Arrays.toString(preciptypeArray) + " " + humidity);
            }
        }



        return weatherDataList;
    }

}
