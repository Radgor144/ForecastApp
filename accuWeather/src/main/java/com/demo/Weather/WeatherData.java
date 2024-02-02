package com.demo.Weather;

public class WeatherData {

    private String datetime;
    private Double temperature;
    private Double cloudcover;

    public WeatherData(String datetime, Double temperature, Double cloudcover) {
        this.datetime = datetime;
        this.temperature = temperature;
        this.cloudcover = cloudcover;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String dateTime) {
        this.datetime = dateTime;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(Double cloudcover) {
        this.cloudcover = cloudcover;
    }
}
