package com.jmlb0003.jokesappnd;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MainActivityFragment extends Fragment
        implements JokesAsyncTask.JokeAsyncTaskListener {

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
        callback = (Callback) getActivity();
        setRetainInstance(true);
        return root;
    }

    @OnClick(R.id.tell_joke_button)
    public void tellJoke() {
        new JokesAsyncTask(new ProgressDialog(getActivity()), this).execute();
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

    interface Callback {

        void goToJokeActivity(String joke);

    }

}
