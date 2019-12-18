package com.keith.president;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.keith.president.inject.PresidentModule;

public class Main {

    public static void main (String[] args) {
        Injector injector = Guice.createInjector(new PresidentModule());
        GameManager gameManager = injector.getInstance(GameManager.class);
        gameManager.launch();
    }

}