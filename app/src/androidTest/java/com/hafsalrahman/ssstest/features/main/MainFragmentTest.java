package com.hafsalrahman.ssstest.features.main;

import android.support.test.espresso.Espresso;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.hafsalrahman.ssstest.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;



/**
 * Created by hafsal on 10/26/17.
 */
public class MainFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testUsersRefresh() throws Exception {

        Espresso.onView(ViewMatchers.withId(R.id.users_recycler)).perform(ViewActions.swipeDown());



    }
}