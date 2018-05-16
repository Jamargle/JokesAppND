package com.jmlb0003.jokeslib;

import org.junit.Test;

public class JokerShould {

    @Test
    public void test() {
        final Joker joker = new Joker();
        assert joker.getJoke().length() != 0;
    }

}
