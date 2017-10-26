package com.hafsalrahman.ssstest.features.main;

import com.hafsalrahman.ssstest.data.AppRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by hafsal on 10/25/17.
 */
public class MainPresenterTest {


    @Mock
    AppRepository mAppRepository;

    @Mock
    MainContract.View mView;

    private MainPresenter mMainPresenter;

    @Before
    public void setUp() throws Exception {

        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mMainPresenter = new MainPresenter(mView,mAppRepository);
        

    }

    @Test
    public void name() throws Exception {



    }

    @After
    public void tearDown() throws Exception {

    }

}