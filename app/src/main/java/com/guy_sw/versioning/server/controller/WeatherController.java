package com.guy_sw.versioning.server.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guy_sw.versioning.common_models.WeatherStatus;
import com.guy_sw.versioning.common_models.WindDirection;

@RestController()
@NoArgsConstructor
@Getter
@Setter
@RequestMapping("weather")
public class WeatherController {

  @Value("${server.port}")
  private int port;

  @PostConstruct
  public void init() {
    System.out.println("Weather Controller and listening to port: " + port);
  }

  @GetMapping()
  public String getWeatherControllerStatus() {
    return "Weather Controller is up and running!";
  }

  @GetMapping("/{city}")
  public WeatherStatus getTomorrowsWeather(@PathVariable String city) {
    Random random = new Random();
    double degreesCelsius = (random.nextInt(300)) / 10.0; //Something between 0 and 30 in multiplies of 0.1
    WindDirection windDirection = WindDirection.values()[random.nextInt(WindDirection.values().length)];
    return WeatherStatus.builder()
                        .city(city)
                        .temperatureCelsius(degreesCelsius)
                        .windDirection(windDirection)
                        .build();
  }

}
