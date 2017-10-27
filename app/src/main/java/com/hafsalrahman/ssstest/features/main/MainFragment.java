package com.hafsalrahman.ssstest.features.main;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hafsalrahman.ssstest.R;
import com.hafsalrahman.ssstest.base.BasePresenter;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;
import com.hafsalrahman.ssstest.features.main.adapters.UsersAdapter;
import com.hafsalrahman.ssstest.utils.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hafsal on 10/25/17.
 */
public class MainFragment extends Fragment implements MainContract.View {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefresh;
    UsersAdapter mUsersAdapter;
    MainPresenter mainPresenter;


    public MainFragment() {

    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) root.findViewById(R.id.users_recycler);
        mSwipeRefresh = (SwipeRefreshLayout) root.findViewById(R.id.swipe_refresh);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                loadUsers();
            }
        });
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        VerticalSpaceItemDecoration dividerItemDecoration = new VerticalSpaceItemDecoration(16);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mUsersAdapter = new UsersAdapter(this.getContext(), new ArrayList<LocalUser>(0));
        mRecyclerView.setAdapter(mUsersAdapter);
        loadUsers();
        return root;
    }

    private void loadUsers() {
        mSwipeRefresh.setRefreshing(true);
        mainPresenter.loadUsers();
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.mainPresenter = (MainPresenter) presenter;
    }

    @Override
    public void showUsers(List<LocalUser> localUsers) {
        mUsersAdapter.updateList(localUsers);
        mRecyclerView.smoothScrollToPosition(mUsersAdapter.getItemCount() - 1);
        mSwipeRefresh.setRefreshing(false);

    }

    @Override
    public void showError(String message) {
        showSnackBar(message);
    }

    @Override
    public void showInfo(int message) {
        String text = getActivity().getString(message);
        showSnackBar(text);
    }

    private void showSnackBar(String message) {
        mSwipeRefresh.setRefreshing(false);
        final Snackbar snackbar = Snackbar
                .make(mRecyclerView, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }


}
