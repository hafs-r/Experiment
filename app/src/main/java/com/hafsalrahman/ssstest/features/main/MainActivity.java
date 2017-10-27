package com.hafsalrahman.ssstest.features.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hafsalrahman.ssstest.App;
import com.hafsalrahman.ssstest.R;
import com.hafsalrahman.ssstest.data.AppRepository;

import javax.inject.Inject;


/**
 * Created by hafsal on 10/25/17.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    public AppRepository mAppRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getAppComponent().inject(this);
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment(new MainFragment());


    }

    private void initFragment(MainFragment usersFragment) {
        // Add the MainFragment to the layout
        MainPresenter presenter = new MainPresenter(usersFragment, mAppRepository);
        usersFragment.setPresenter(presenter);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, usersFragment);
        fragmentTransaction.commit();
    }

}
