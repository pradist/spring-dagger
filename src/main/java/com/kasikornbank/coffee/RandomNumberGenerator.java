package com.kasikornbank.coffee;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomNumberGenerator {
    public String generateNumber() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(0, 10000000));
    }

    @PostConstruct
    public void setup() {
        System.out.println("RandomNumberGenerator setup done!!!");
    }
}
