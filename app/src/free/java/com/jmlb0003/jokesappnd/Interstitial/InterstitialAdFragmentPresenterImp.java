package com.jmlb0003.jokesappnd.Interstitial;

import com.jmlb0003.jokesappnd.utils.FireBaseAnalyticsTracker;

class InterstitialAdFragmentPresenterImp implements InterstitialAdFragmentPresenter {

    private InterstitialAdFragmentPresenter.View view;
    private FireBaseAnalyticsTracker fireBaseAnalyticsTracker;

    InterstitialAdFragmentPresenterImp(final FireBaseAnalyticsTracker fireBaseAnalyticsTracker) {
        this.fireBaseAnalyticsTracker = fireBaseAnalyticsTracker;
    }

    @Override
    public void attachView(View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void onOpenAd() {
        fireBaseAnalyticsTracker.trackSelectContentEvent(
                INTERSTITIAL_AD_OPENED_ID,
                INTERSTITIAL_AD_NAME,
                FireBaseAnalyticsTracker.INTERSTITIAL_AD);
        if (view != null) {
            view.showInterstitialAd();
        }
    }

    @Override
    public void onCloseAd() {
        fireBaseAnalyticsTracker.trackSelectContentEvent(
                INTERSTITIAL_AD_CLOSED_ID,
                INTERSTITIAL_AD_NAME,
                FireBaseAnalyticsTracker.INTERSTITIAL_AD);
        if (view != null) {
            view.closeInterstitialAd();
        }
    }

}
