package com.hafsalrahman.ssstest.data.local;

import com.hafsalrahman.ssstest.data.DataTestUtil;
import com.hafsalrahman.ssstest.data.local.dao.UserDao;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;

import static org.mockito.Mockito.when;

/**
 * Created by hafsal on 10/27/17.
 */
public class AppLocalDataStoreTest {

    @Mock
    DataBaseSource lDataBaseSource;


    private List<LocalUser> USERS = new ArrayList<LocalUser>();

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        when(lDataBaseSource.getUserDao()).thenReturn(new UserDao() {
            @Override
            public Single<List<LocalUser>> getUsers() {
                return Single.create(new SingleOnSubscribe<List<LocalUser>>() {

                    @Override
                    public void subscribe(@NonNull SingleEmitter<List<LocalUser>> emittor) {

                        try {
                            emittor.onSuccess(USERS);
                        } catch (Exception e) {
                            emittor.onError(e);
                        }

                    }
                });

            }

            @Override
            public void insertMultipleListRecord(List<LocalUser> localUsers) {
                USERS = localUsers;
            }

            @Override
            public void deleteAll() {
                USERS.clear();
            }
        });

    }

    @Test
    public void insertDataTest() throws Exception {

        int count = lDataBaseSource.getUserDao().getUsers().blockingGet().size();
        USERS = new DataTestUtil().getDummyUsers();
        lDataBaseSource.getUserDao().insertMultipleListRecord(USERS);
        int updatedCount = lDataBaseSource.getUserDao().getUsers().blockingGet().size();
        Assert.assertNotEquals(count, updatedCount);

    }

    @Test
    public void deleteDataTest() throws Exception {
        USERS = new DataTestUtil().getDummyUsers();
        lDataBaseSource.getUserDao().insertMultipleListRecord(USERS);
        int count = lDataBaseSource.getUserDao().getUsers().blockingGet().size();
        lDataBaseSource.getUserDao().deleteAll();
        int updatedCount = lDataBaseSource.getUserDao().getUsers().blockingGet().size();
        Assert.assertNotEquals(count, updatedCount);
    }

    @After
    public void tearDown() throws Exception {
        lDataBaseSource.close();
    }

}