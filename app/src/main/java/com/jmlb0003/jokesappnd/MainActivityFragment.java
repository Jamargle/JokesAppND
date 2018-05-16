package com.jmlb0003.jokesappnd;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jmlb0003.jokeslib.Joker;

public final class MainActivityFragment extends Fragment {

    @BindView(R.id.adView) AdView adView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            final ViewGroup container,
            final Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
        return root;
    }

    @OnClick(R.id.tell_joke_button)
    public void tellJoke() {
        Toast.makeText(getActivity(), Joker.getJoke(), Toast.LENGTH_SHORT).show();
    }

    interface Callback {

    }

}
