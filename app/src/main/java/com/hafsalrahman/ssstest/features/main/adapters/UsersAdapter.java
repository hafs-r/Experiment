package com.hafsalrahman.ssstest.features.main.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hafsalrahman.ssstest.R;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;
import com.hafsalrahman.ssstest.utils.NetUtils;

import java.util.List;

/**
 * Created by hafsal on 10/25/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<LocalUser> mLocalUsers;
    private Context mContext;

    public UsersAdapter(Context context, List<LocalUser> myList) {
        this.mLocalUsers = myList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LocalUser localUser = mLocalUsers.get(position);
        Glide.with(mContext)
                .load(localUser.thumbnail)
                .fitCenter()
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.noimage)
                .into(holder.image);
        holder.name.setText(localUser.title + " " + localUser.firstName + " " + localUser.lastName);

        holder.gender.setText(localUser.gender);
    }


    public void updateList(final List<LocalUser> localUsers) {
        if (!NetUtils.network)
            mLocalUsers.clear();
        mLocalUsers.addAll(localUsers);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mLocalUsers.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView name;
        AppCompatTextView gender;
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (AppCompatTextView) itemView.findViewById(R.id.name);
            gender = (AppCompatTextView) itemView.findViewById(R.id.gender);
        }
    }

}