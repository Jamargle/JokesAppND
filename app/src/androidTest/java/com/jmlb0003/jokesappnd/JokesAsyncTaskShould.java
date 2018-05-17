package com.jmlb0003.jokesappnd;

import android.app.ProgressDialog;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.UiThreadTest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(AndroidJUnit4.class)
public class JokesAsyncTaskShould {

    @Rule
    public UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();

    private JokesAsyncTaskListener asyncTaskListener;
    private ProgressDialog dialog;
    private JokesAsyncTask task;

    @Before
    public void setUp() throws Throwable {
        asyncTaskListener = new JokesAsyncTaskListener();
        dialog = mock(ProgressDialog.class);

        uiThreadTestRule.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                task = new JokesAsyncTask(dialog, asyncTaskListener);
            }
        });
    }

    @Test
    @UiThreadTest
    public void showDialogWhenExecute() {
        task.execute();
        verify(dialog).show();
    }

    @Test
    @UiThreadTest
    public void returnsJokeSuccessfully() {
        try {
            final String joke = task.execute().get(10, TimeUnit.SECONDS);
            assertFalse(joke.isEmpty());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private class JokesAsyncTaskListener implements JokesAsyncTask.JokeAsyncTaskListener {

        @Override
        public void showAJoke(final String joke) {
            assertFalse(joke == null);
            assertFalse(joke.isEmpty());
        }

        @Override
        public void thereIsNoJokes() {
            int i = 0;
        }

    }

}
