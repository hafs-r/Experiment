package com.hafsalrahman.ssstest.data.remote;


import com.hafsalrahman.ssstest.data.remote.models.Info;
import com.hafsalrahman.ssstest.data.remote.models.RemoteUser;

import java.util.List;

/**
 * Created by hafsal on 10/24/17.
 */

public class UsersResponse extends BaseResponse {

    public final List<RemoteUser> results;

    public final Info info;

    public UsersResponse(List<RemoteUser> results, Info info) {
        this.results = results;
        this.info = info;
    }

    @Override
    public Info getInfo() {
        return info;
    }


}
