package com.jmlb0003.jokesappnd;

interface MainActivityFragmentPresenter {

    void attachView(View view);

    void detachView();

    void onTellJoke();

    interface View {

        void openInterstitialAd();

        void continueTheFlowAfterAd();

    }

}
