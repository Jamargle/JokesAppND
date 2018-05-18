package com.jmlb0003.jokesappnd;

public final class MainActivityFragmentPresenterImp implements MainActivityFragmentPresenter {

    private MainActivityFragmentPresenter.View view;

    @Override
    public void attachView(final View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void onTellJoke() {
        if (view != null) {
            view.retrieveAJoke();
        }
    }

}
