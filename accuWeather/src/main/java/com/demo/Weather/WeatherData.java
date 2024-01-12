package com.demo.Weather;

public class WeatherData {

    private String datetime;
    private Double temperature;
    private Double feelslike;

    public WeatherData(String datetime, Double temperature, Double feelslike) {
        this.datetime = datetime;
        this.temperature = temperature;
        this.feelslike = feelslike;
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

    public Double getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(Double feelslike) {
        this.feelslike = feelslike;
    }
}
