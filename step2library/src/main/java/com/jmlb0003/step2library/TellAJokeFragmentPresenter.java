package com.jmlb0003.step2library;

public interface TellAJokeFragmentPresenter {

    void attachView(View view);

    void detachView();

    void prepareView(String joke);

    interface View {

        void showTheJoke(String jokeToShow);

    }

}
