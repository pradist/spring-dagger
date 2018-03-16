package com.kasikornbank.coffee.heater.impl;

import com.kasikornbank.coffee.heater.Heater;
import org.springframework.stereotype.Component;

@Component
public class ElectricHeater implements Heater {
  boolean heating;

  @Override
  public void on() {
    System.out.println("~ ~ ~ heating ~ ~ ~");
    this.heating = true;
  }

  @Override
  public void off() {
    this.heating = false;
  }

  @Override
  public boolean isHot() {
    return heating;
  }
}
