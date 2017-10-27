package com.hafsalrahman.ssstest.data;



import com.hafsalrahman.ssstest.data.remote.UsersResponse;


import io.reactivex.Single;


/**
 * Created by hafsal on 10/24/17.
 */

public interface AppDataStore {

    Single getUsers();


}
