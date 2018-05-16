package com.jmlb0003.step2library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public final class TellAJokeFragmentPresenterImpShould {

    private TellAJokeFragmentPresenter.View mockView;
    private TellAJokeFragmentPresenterImp presenter;

    @Before
    public void setUp() {
        mockView = mock(TellAJokeFragmentPresenter.View.class);
        presenter = new TellAJokeFragmentPresenterImp();

        presenter.attachView(mockView);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(mockView);
    }

    @Test
    public void prepareViewToShowAJoke() {
        final String joke = "Some joke";
        presenter.prepareView(joke);

        verify(mockView).showTheJoke(joke);
    }

}
