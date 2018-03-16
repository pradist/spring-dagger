package com.kasikornbank.coffee;

import com.kasikornbank.coffee.cup.Cup;
import com.kasikornbank.coffee.heater.Heater;
import com.kasikornbank.coffee.pump.Pump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
class CoffeeMaker {

  private Heater heater;
  private Pump pump;
  private List<Cup> cups;
  private RandomNumberGenerator randomNumberGenerator;
  private String testValue;

  @Inject
  @Autowired
  public void setHeater(Heater heater) {
//    System.out.println("set Heater");
    this.heater = heater;
  }

  @Qualifier("handPump")
  @Inject
  @Autowired
  public void setPump(Pump pump) {
//    System.out.println("set Pump");
    this.pump = pump;
  }

  @Resource(name = "cups")
  public void setCups(List<Cup> cups) {
//    System.out.println("set Cups");
    this.cups = cups;
  }

  @Autowired
  public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
//    System.out.println("set RandomNumberGenerator");
    this.randomNumberGenerator = randomNumberGenerator;
  }

  @Value("${test.value}")
  public void setTestValue(String testValue) {
    this.testValue = testValue;
  }

  @PostConstruct
  public void setup() {
    System.out.println("CoffeeMaker setup done!!!");
  }

  public void brew() {
    heater.on();
    pump.pump();
    System.out.println(" [_]P coffee! [_]P ");
    heater.off();

    int randomNumber = ThreadLocalRandom.current().nextInt(0, cups.size());
    System.out.println("random Number = " + randomNumber);
    Cup cup = cups.get(randomNumber);
    cup.pourCoffee();
    System.out.println("Here you go!!! your cup's label is " + cup.getLabel());
//    System.out.println("Here is your random number of the day:" + randomNumberGenerator.generateNumber() + "   Please use it for lottery");
    System.out.println("Test value is :" + testValue);
  }

}
