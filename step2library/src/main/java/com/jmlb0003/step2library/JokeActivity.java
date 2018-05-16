package com.jmlb0003.step2library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public final class JokeActivity extends AppCompatActivity {

    private static final String JOKE_TO_TELL = "JokeActivity:joke_to_tell";

    public static Bundle newBundle(final String jokeToTell) {
        final Bundle bundle = new Bundle();
        bundle.putString(JOKE_TO_TELL, jokeToTell);
        return bundle;
    }

    @Override
    protected void onCreate(final @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        initJokeFragment();
    }

    private void initJokeFragment() {
        final String joke = getIntent().getStringExtra(JOKE_TO_TELL);
        final TellAJokeFragment fragment = TellAJokeFragment.newInstance(joke);

        if (joke != null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.joke_activity_container, fragment)
                    .commit();
        }
    }

}
