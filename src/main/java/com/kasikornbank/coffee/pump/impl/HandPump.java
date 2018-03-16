package com.kasikornbank.coffee.pump.impl;

import com.kasikornbank.coffee.heater.Heater;
import com.kasikornbank.coffee.pump.Pump;
import org.springframework.stereotype.Component;

@Component
public class HandPump implements Pump {
  private final Heater heater;

  public HandPump(Heater heater) {
    this.heater = heater;
  }

  @Override
  public void pump() {
    if (heater.isHot()) {
      System.out.println("=> => Manually pumping => =>");
      System.out.println("herrrrrrr~~~~~");
    }
  }
}
