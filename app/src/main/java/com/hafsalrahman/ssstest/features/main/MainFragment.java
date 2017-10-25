package com.hafsalrahman.ssstest.features.main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hafsalrahman.ssstest.R;
import com.hafsalrahman.ssstest.base.BasePresenter;
import com.hafsalrahman.ssstest.data.local.models.User;

import java.util.List;
/**
 * Created by hafsal on 10/25/17.
 */
public class MainFragment extends Fragment implements MainContract.View {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public void showUsers(List<User> properties) {

    }

    @Override
    public void showError(String message) {

    }
}
