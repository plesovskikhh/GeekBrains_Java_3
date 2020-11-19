package ru.GeekBrains.Java_3.lession_5;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static final int CARS_COUNT = 5;
    public static void main(String[] args) {

        Stage[] stages = {
                new Road(60),
                new Tunnel(CARS_COUNT / 2),
                new Road(40)
        };

        Race race = new Race(stages, CARS_COUNT);
        race.start();
    }
}




