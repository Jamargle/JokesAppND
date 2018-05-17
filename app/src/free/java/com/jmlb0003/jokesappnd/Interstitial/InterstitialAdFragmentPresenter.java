package com.jmlb0003.jokesappnd.Interstitial;

public interface InterstitialAdFragmentPresenter {

    String INTERSTITIAL_AD_OPENED_ID = "interstitial_ad_opened";
    String INTERSTITIAL_AD_CLOSED_ID = "interstitial_ad_closed";
    String INTERSTITIAL_AD_NAME = "main_fragment_interstitial";

    void attachView(View view);

    void detachView();

    void onOpenAd();

    void onCloseAd();

    interface View {

        void showInterstitialAd();

        void closeInterstitialAd();

    }

}
