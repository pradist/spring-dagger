package com.kasikornbank.coffee;

import com.kasikornbank.coffee.cup.Cup;
import com.kasikornbank.coffee.cup.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.ArrayList;
import java.util.List;

@Profile("test")
@PropertySource("classpath:/config.properties")
@Configuration
public class CoffeeMakerConfiguration {

    @Bean
    public List<Cup> cups() {
        List<Cup> cups = new ArrayList<>();
        cups.add(new RedCup());
        cups.add(new YellowCup());
        cups.add(new GreenCup());
        cups.add(new BlueCup());
        return cups;
    }
}
