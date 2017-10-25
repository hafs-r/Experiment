package com.hafsalrahman.ssstest.data.remote;



import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hafsal on 10/24/17.
 */

public interface UserService {

    @GET("/api")
    Single<UsersResponse> getUserList();

}
