package com.hafsalrahman.ssstest.features.main;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import com.hafsalrahman.ssstest.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Created by hafsal on 10/26/17.
 */
public class MainFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testUsersRefresh() throws Exception {

        onView(withId(R.id.users_recycler)).perform(ViewActions.swipeDown());
        onView(withId(R.id.users_recycler)).check(new RecyclerViewItemCountAssertion(1));

    }

}
