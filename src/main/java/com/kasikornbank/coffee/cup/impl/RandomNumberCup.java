package com.kasikornbank.coffee.cup.impl;

import com.kasikornbank.coffee.RandomNumberGenerator;
import com.kasikornbank.coffee.cup.Cup;
import org.springframework.beans.factory.annotation.Autowired;

public class RandomNumberCup implements Cup {

    private RandomNumberGenerator randomNumberGenerator;

    @Autowired
    public RandomNumberCup(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void pourCoffee() {

    }

    @Override
    public String getLabel() {
        return randomNumberGenerator.generateNumber();
    }
}
