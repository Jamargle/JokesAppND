package com.jmlb0003.jokeslib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Joker {

    private static final List<String> JOKES = new ArrayList<>();

    private Joker() {
    }

    public static String getJoke() {
        if (JOKES.isEmpty()) {
            initJokes();
        }
        return JOKES.get(new Random().nextInt(JOKES.size()));
    }

    private static void initJokes() {
        JOKES.add("This is totally a funny joke");
        JOKES.add("This is another joke");
        JOKES.add("This is a joke about animals");
        JOKES.add("This is a joke about films");
        JOKES.add("This is a bad joke");
    }

}
