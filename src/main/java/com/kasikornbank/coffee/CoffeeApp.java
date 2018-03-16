package com.kasikornbank.coffee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoffeeApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CoffeeMaker coffeeMaker = applicationContext.getBean(CoffeeMaker.class);
        coffeeMaker.brew();
    }
}
