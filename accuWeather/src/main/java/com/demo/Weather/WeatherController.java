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
        List<WeatherData> weatherDataList = accuWeatherService.getWeatherData(cityName);

        List<WeatherData> Cloudcover = weatherDataList.subList(0, Math.min(weatherDataList.size(), 12));

//        for (WeatherData data : Cloudcover) {
//            System.out.println("Datetime: " + data.getDatetime() + ", Temperature: " + data.getTemperature() + ", Cloudcover: " + data.getCloudcover() + ", Precipprob: " + data.getPrecipprob() + ", PreciptypeArray: " + Arrays.toString(data.getPreciptypeArray()));
//        }

        model.addAttribute("weatherDataList", Cloudcover);


        return "forecast";  // Zwraca nazwę pliku HTML (bez rozszerzenia) jako widok
    }

    @PostMapping("")
    public String handleFormData(@RequestParam("cityName") String cityName) {
        // Tutaj możesz przetwarzać przesłaną nazwę miasta
        System.out.println("Przekazana nazwa miasta: " + cityName);
        // Ustaw nowe domyślne miasto
        defaultCity = cityName;
        // Przekieruj użytkownika na tę samą stronę, ale z parametrem cityName
        return "redirect:/forecast?cityName=" + cityName;
    }
}
