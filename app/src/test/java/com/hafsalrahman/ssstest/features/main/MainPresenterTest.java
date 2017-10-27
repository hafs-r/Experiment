package com.hafsalrahman.ssstest.features.main;

import com.hafsalrahman.ssstest.data.AppRepository;
import com.hafsalrahman.ssstest.data.DataTestUtil;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by hafsal on 10/25/17.
 */
public class MainPresenterTest {


    @Mock
    MainContract.View mView;
    @Mock
    AppRepository mAppRepository;

    private MainPresenter mMainPresenter;


    private  List<LocalUser> USERS;

    @Before
    public void setUp() throws Exception {
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        USERS=new DataTestUtil().getDummyUsers();
        when(mAppRepository.getUsers()).thenReturn(Single.create(new SingleOnSubscribe<List<LocalUser>>() {

            @Override
            public void subscribe(@NonNull SingleEmitter<List<LocalUser>> emitter) throws Exception {
                try {
                    emitter.onSuccess(USERS);

                } catch (Exception e) {
                    emitter.onError(e);
                }
            }


        }));

    }

    @Test
    public void invokeUsersFromDataRepository() throws Exception {


        mMainPresenter = new MainPresenter(mView, mAppRepository);
        mMainPresenter.loadUsers();
        verify(mAppRepository, atLeastOnce()).getUsers();

        mAppRepository.getUsers().test().assertNoErrors().assertValue(USERS);
    }

    @After
    public void tearDown() throws Exception {

    }

}