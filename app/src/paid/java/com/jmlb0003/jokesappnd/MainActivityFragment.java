package com.jmlb0003.jokesappnd;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MainActivityFragment extends Fragment
        implements MainActivityFragmentPresenter.View,
        JokesAsyncTask.JokeAsyncTaskListener {

    private MainActivityFragmentPresenter presenter;
    private Callback callback;

    @Override
    public void onCreate(final @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainActivityFragmentPresenterImp();
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

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @OnClick(R.id.tell_joke_button)
    public void tellJoke() {
        presenter.onTellJoke();
    }

    @Override
    public void retrieveAJoke() {
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
