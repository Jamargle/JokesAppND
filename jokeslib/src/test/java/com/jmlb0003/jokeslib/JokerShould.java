package com.jmlb0003.jokeslib;

import org.junit.Test;

public class JokerShould {

    @Test
    public void returnAJoke() {
        assert Joker.getJoke().length() != 0;
    }

}
