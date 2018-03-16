package com.kasikornbank.coffee.pump.impl;

import com.kasikornbank.coffee.heater.Heater;
import com.kasikornbank.coffee.pump.Pump;
import org.springframework.stereotype.Component;

@Component
public class Thermosiphon implements Pump {
  private final Heater heater;

  Thermosiphon(Heater heater) {
    this.heater = heater;
  }

  @Override
  public void pump() {
    if (heater.isHot()) {
      System.out.println("=> => Thermosiphon pumping => =>");
    }
  }
}
