package com.jmlb0003.step2library;

final class TellAJokeFragmentPresenterImp implements TellAJokeFragmentPresenter {

    private TellAJokeFragmentPresenter.View view;

    public void attachView(final View view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    @Override
    public void prepareView(final String joke) {
        if (view != null) {
            view.showTheJoke(joke);
        }
    }

}
