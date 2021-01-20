package com.alexwork;

import java.util.concurrent.ThreadLocalRandom;

public class Coordinate{
    int value = 0;
    boolean found = false;

    public Coordinate(){
        this.value = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        this.found = false;
    }

}