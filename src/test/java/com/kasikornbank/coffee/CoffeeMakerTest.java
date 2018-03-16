package com.kasikornbank.coffee;

import com.kasikornbank.coffee.cup.Cup;
import com.kasikornbank.coffee.heater.Heater;
import com.kasikornbank.coffee.heater.impl.ElectricHeater;
import com.kasikornbank.coffee.pump.Pump;
import com.kasikornbank.coffee.pump.impl.HandPump;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CoffeeMakerTest {

    private Heater heater;
    private Pump pump;
    private RandomNumberGenerator randomNumberGenerator;
    private List<Cup> cups = new ArrayList<>();
    private CoffeeMakerConfigurationProd coffeeMakerConfiguration;
    private String testValue;

    @Before
    public void setup() {
        heater = new ElectricHeater();
        pump = new HandPump(heater);
        randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generateNumber()).thenReturn("1111111");
        coffeeMakerConfiguration = new CoffeeMakerConfigurationProd();
        cups.addAll(coffeeMakerConfiguration.cups(randomNumberGenerator));
        testValue = "test";
    }

    @Test
    public void happy_case_brew() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.setHeater(heater);
        coffeeMaker.setPump(pump);
        coffeeMaker.setRandomNumberGenerator(randomNumberGenerator);
        coffeeMaker.setCups(cups);
        coffeeMaker.setTestValue(testValue);
        coffeeMaker.brew();
    }
}
