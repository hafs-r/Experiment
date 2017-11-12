package com.hafsalrahman.ssstest.utils;

import com.hafsalrahman.ssstest.data.local.models.LocalUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hafsal on 11/12/17.
 */

public class TestUtil {

    public static List<LocalUser> getListStoreLocal() {
        List<LocalUser> storeLocals = new ArrayList<LocalUser>();
        storeLocals.add(new LocalUser("2831", "Mr", "Test", "LastName"
                , "1", "thumbnail"));

        return storeLocals;
    }
}
