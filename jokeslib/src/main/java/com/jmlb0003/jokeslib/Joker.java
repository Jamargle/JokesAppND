package com.jmlb0003.jokeslib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Joker {

    private final List<String> jokes;

    public Joker() {
        jokes = new ArrayList<>();
        jokes.add("This is totally a funny joke");
        jokes.add("This is another joke");
        jokes.add("This is a joke about animals");
        jokes.add("This is a joke about films");
        jokes.add("This is a bad joke");
    }

    public String getJoke() {
        return jokes.get(new Random().nextInt(jokes.size()));
    }

}
