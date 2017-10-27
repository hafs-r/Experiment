package com.hafsalrahman.ssstest.data;

import com.hafsalrahman.ssstest.data.local.models.LocalUser;
import com.hafsalrahman.ssstest.data.remote.UsersResponse;
import com.hafsalrahman.ssstest.data.remote.models.Id;
import com.hafsalrahman.ssstest.data.remote.models.Info;
import com.hafsalrahman.ssstest.data.remote.models.Location;
import com.hafsalrahman.ssstest.data.remote.models.Login;
import com.hafsalrahman.ssstest.data.remote.models.Name;
import com.hafsalrahman.ssstest.data.remote.models.Picture;
import com.hafsalrahman.ssstest.data.remote.models.RemoteUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hafsal on 10/27/17.
 * implemented for dummy data for testing
 */

public class DataTestUtil {

    public LocalUser getRandomDummyUser() {
        Random rand = new Random();
        return new LocalUser("123ER" + rand.nextInt(), "mr", "firstName", "lastName",
                "gender", "thumbNail");
    }

    public RemoteUser getRandomDummyUserRemote() {
        Random rand = new Random();
        Name name = new Name("mr", "first", "last");
        Id id = new Id("123" + rand.nextInt(), "CODE");
        Location location = new Location("street", "city", "state", "CV6776721");
        Login login = new Login("username", "password", "salt", "$%^&%^RTU&^",
                "GJFFJTRTUR&^R&^R&", "GYTRU^TRYDEUTU^T&R&^T");
        Picture picture = new Picture("large", "medium", "small");
        RemoteUser rUser = new RemoteUser("male", name, location, "first@xyz.com",
                login, "dob", "10/27/17", "+123456615156", "+13245261661", id, picture, "nat");

        return rUser;
    }

    public List<LocalUser> getDummyUsers() {
        List<LocalUser> localUsers = new ArrayList<LocalUser>();
        localUsers.add(getRandomDummyUser());
        localUsers.add(getRandomDummyUser());
        return localUsers;
    }

    public List<RemoteUser> getDummyUsersRemote() {
        List<RemoteUser> remoteUsers = new ArrayList<RemoteUser>();
        remoteUsers.add(getRandomDummyUserRemote());
        return remoteUsers;
    }

    public UsersResponse getDummyUserResponse() {

        Info info = new Info();
        info.page = 1;
        info.results = 1;
        info.seed = "seed";
        info.version = "1";

        UsersResponse response = new UsersResponse(getDummyUsersRemote(), info);

        return response;
    }
}
