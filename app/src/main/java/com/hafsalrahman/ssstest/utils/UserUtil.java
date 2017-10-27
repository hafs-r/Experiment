package com.hafsalrahman.ssstest.utils;

import com.hafsalrahman.ssstest.data.local.models.LocalUser;
import com.hafsalrahman.ssstest.data.remote.UsersResponse;
import com.hafsalrahman.ssstest.data.remote.models.RemoteUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hafsal on 10/26/17.
 */

public class UserUtil {
    public static List<LocalUser> convertApiUserListToUserList(UsersResponse response) {


        List<LocalUser> localUsers = new ArrayList();
        for (RemoteUser remoteUser : response.results) {
            LocalUser localUserLocal = new LocalUser(remoteUser.id.toString(), remoteUser.name.title, remoteUser.name.first, remoteUser.name.last, remoteUser.gender, remoteUser.picture.medium);
            localUsers.add(localUserLocal);
        }
        return localUsers;
    }
}
