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

public final class MainActivityFragment extends Fragment
        implements JokesAsyncTask.JokeAsyncTaskListener {

    @BindView(R.id.adView) AdView adView;

    private Callback callback;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            final ViewGroup container,
            final Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        initAddView();
        callback = (Callback) getActivity();
        setRetainInstance(true);
        return root;
    }

    @OnClick(R.id.tell_joke_button)
    public void tellJoke() {
        new JokesAsyncTask(this).execute();
    }

    @Override
    public void showAJoke(final String joke) {
        callback.goToJokeActivity(joke);
    }

    @Override
    public void thereIsNoJokes() {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), R.string.no_jokes, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initAddView() {
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
    }

    interface Callback {

        void goToJokeActivity(String joke);

    }

}
