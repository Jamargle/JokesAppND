package com.jmlb0003.jokesappnd;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.jmlb0003.backend.jokeApi.JokeApi;
import com.jmlb0003.jokeslib.Joker;
import java.io.IOException;

public final class JokesAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String LOCAL_SERVER_ROOT = "http://10.0.2.2:8080/";
    private static final String API_ENDPOINT = "_ah/api/";
    private static JokeApi myApiService = null;

    private final ProgressDialog dialog;
    private final JokeAsyncTaskListener asyncTaskListener;

    JokesAsyncTask(
            final Context context,
            final JokeAsyncTaskListener listener) {

        dialog = new ProgressDialog(context);
        asyncTaskListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            final JokeApi.Builder builder = new JokeApi
                    .Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(LOCAL_SERVER_ROOT + API_ENDPOINT)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {

                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }

                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            asyncTaskListener.thereIsNoJokes();
            return null;
        }
    }

    @Override
    protected void onPostExecute(final String joke) {
        if (dialog.isShowing()) {
            dialog.hide();
        }
        if (joke != null && !joke.isEmpty()) {
            asyncTaskListener.showAJoke(joke);
        }
    }

    interface JokeAsyncTaskListener {

        void showAJoke(String joke);

        void thereIsNoJokes();

    }

}
