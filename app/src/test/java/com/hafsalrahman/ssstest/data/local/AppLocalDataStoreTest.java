package com.hafsalrahman.ssstest.data.local;

import com.hafsalrahman.ssstest.data.DataTestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Created by hafsal on 10/27/17.
 */
public class AppLocalDataStoreTest {

    @Mock
    DataBaseSource lDataBaseSource;

    DataTestUtil lDataTestUtil;


    @Before
    public void setUp() throws Exception {
        lDataTestUtil = new DataTestUtil();
    }

    @Test
    public void insertDataTest() throws Exception {

        int count = lDataBaseSource.getUserDao().getUsers().blockingGet().size();
        lDataBaseSource.getUserDao().insertMultipleListRecord(lDataTestUtil.getDummyUsers());
        int updatedCount = lDataBaseSource.getUserDao().getUsers().blockingGet().size();


    }

    @Test
    public void deleteDataTest() throws Exception {

        int count = lDataBaseSource.getUserDao().getUsers().blockingGet().size();
        lDataBaseSource.getUserDao().deleteAll();
        int updatedCount = lDataBaseSource.getUserDao().getUsers().blockingGet().size();

    }

    @After
    public void tearDown() throws Exception {

    }

}