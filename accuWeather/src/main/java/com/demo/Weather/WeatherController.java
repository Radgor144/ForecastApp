package com.demo.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/forecast")
public class WeatherController {

    private final AccuWeatherService accuWeatherService;
    private String defaultCity = "krakow";

    @Autowired
    public WeatherController(AccuWeatherService accuWeatherService) {
        this.accuWeatherService = accuWeatherService;
    }

    @GetMapping("")
    public String weather(@RequestParam(required = false) String cityName, Model model) {
        String city = cityName != null ? cityName : defaultCity;
        List<WeatherData> weatherDataList = accuWeatherService.getWeatherData(city);

        List<WeatherData> Cloudcover = weatherDataList.subList(0, Math.min(weatherDataList.size(), 12));



        model.addAttribute("weatherDataList", Cloudcover);


        return "forecast";
    }

    @PostMapping("")
    public String citiesSearch(@RequestParam("cityName") String cityName) {

        System.out.println("Przekazana nazwa miasta: " + cityName);

        defaultCity = cityName;

        return "redirect:/forecast?cityName=" + cityName;
    }
}
