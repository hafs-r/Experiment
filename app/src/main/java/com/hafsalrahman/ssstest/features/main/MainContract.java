package com.hafsalrahman.ssstest.features.main;

import com.hafsalrahman.ssstest.base.BasePresenter;
import com.hafsalrahman.ssstest.base.BaseView;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;

import java.util.List;

/**
 * Created by hafsal on 10/25/17.
 */

public class MainContract {

    interface View extends BaseView {

        void showUsers(List<LocalUser> properties);

        void showError(String message);

        void showInfo(int message);


    }

    interface Presenter extends BasePresenter {
        void loadUsers();

    }
}
