package com.demo.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/weather")
public class WeatherController {

    private final AccuWeatherService accuWeatherService;

    @Autowired
    public WeatherController(AccuWeatherService accuWeatherService) {
        this.accuWeatherService = accuWeatherService;
    }

    @GetMapping("")
    public String weather(Model model) {
        List<WeatherData> weatherDataList = accuWeatherService.getWeatherData();

        model.addAttribute("weatherDataList", weatherDataList);

        return "weather";  // Zwraca nazwę pliku HTML (bez rozszerzenia) jako widok
    }
}
