package com.jmlb0003.jokesappnd.utils;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public final class FireBaseAnalyticsTracker {

    public static final String INTERSTITIAL_AD = "interstitial_ad";

    private FirebaseAnalytics firebaseAnalytics;

    public FireBaseAnalyticsTracker(final Context context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public void trackSelectContentEvent(
            final String id,
            final String name,
            final String contentType) {

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

}
