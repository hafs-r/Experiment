package com.hafsalrahman.ssstest.data.local.dao;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.hafsalrahman.ssstest.data.local.DataBaseSource;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;
import com.hafsalrahman.ssstest.utils.TestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

/**
 * Created by hafsal on 11/12/17.
 */
@RunWith(AndroidJUnit4.class)
public class UserDaoTest {


    private DataBaseSource localDataBase;
    private UserDao userDao;
    @Before
    public void setUp() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        localDataBase = Room.inMemoryDatabaseBuilder(context, DataBaseSource.class).build();
        userDao = localDataBase.getUserDao();
    }

    @Test
    public void isDataBaseCreated() throws Exception {
        assertNotNull(localDataBase);
    }

    @Test
    public void isStoreDaoCreated() throws Exception {
        assertNotNull(userDao);
    }


    @Test
    public void isInsertionWorksFine() throws Exception {
        TestObserver<List<LocalUser>> observer = new TestObserver<>();
        userDao.insertMultipleListRecord(TestUtil.getListStoreLocal());
        userDao.getUsers().toObservable().subscribe(observer);
        observer.assertNoErrors().assertValue(TestUtil.getListStoreLocal());
    }

    @Test
    public void isQueryingWorksFine() throws Exception {
        TestObserver<List<LocalUser>> observer = new TestObserver<>();
        userDao.insertMultipleListRecord(TestUtil.getListStoreLocal());
        userDao.getUsers().toObservable().subscribe(observer);
        observer.assertNoErrors().assertValue(TestUtil.getListStoreLocal());
    }


    @After
    public void tearDown() throws Exception {

        localDataBase.close();
    }

}

