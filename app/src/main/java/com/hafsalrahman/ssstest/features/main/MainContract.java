package com.hafsalrahman.ssstest.features.main;

import com.hafsalrahman.ssstest.base.BasePresenter;
import com.hafsalrahman.ssstest.base.BaseView;
import com.hafsalrahman.ssstest.data.local.models.User;

import java.util.List;

/**
 * Created by hafsal on 10/25/17.
 */

public class MainContract {

    interface View extends BaseView {

        void showUsers(List<User> properties);

        void showError(String message);


    }

    interface Presenter extends BasePresenter {
        void loadUsers();

    }
}
