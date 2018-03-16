package com.kasikornbank.coffee;

import com.kasikornbank.coffee.cup.Cup;
import com.kasikornbank.coffee.cup.impl.GreenCup;
import com.kasikornbank.coffee.cup.impl.RandomNumberCup;
import com.kasikornbank.coffee.cup.impl.RedCup;
import com.kasikornbank.coffee.cup.impl.YellowCup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Profile("production")
@PropertySource("classpath:/config-prod.properties")
@Configuration
public class CoffeeMakerConfigurationProd {

    @Bean
    public List<Cup> cups(RandomNumberGenerator randomNumberGenerator) {
        List<Cup> cups = new ArrayList<>();
        cups.add(new RandomNumberCup(randomNumberGenerator));
        return cups;
    }

}
