package com.demo.Weather;

public class WeatherData {

    private String resolvedAddress;
    private String datetime;
    private Double temperature;
    private Double cloudcover;
    private Double precipprob;
    private String[] preciptypeArray;
    private Double humidity;


    public WeatherData(String resolvedAddress, String datetime, Double temperature, Double cloudcover, Double precipprob, String[] preciptypeArray, Double humidity) {
        this.resolvedAddress = resolvedAddress;
        this.datetime = datetime;
        this.temperature = temperature;
        this.cloudcover = cloudcover;
        this.precipprob = precipprob;
        this.preciptypeArray = preciptypeArray;
        this.humidity = humidity;
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

    public String[] getPreciptypeArray() {
        return preciptypeArray;
    }

    public void setPreciptypeArray(String[] preciptypeArray) {
        this.preciptypeArray = preciptypeArray;
    }

    public Double getPrecipprob() {
        return precipprob;
    }

    public void setPrecipprob(Double precipprob) {
        this.precipprob = precipprob;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getResolvedAddress() {
        return resolvedAddress;
    }

    public void setResolvedAddress(String resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }
}
