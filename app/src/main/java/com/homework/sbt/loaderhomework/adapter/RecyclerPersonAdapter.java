package com.homework.sbt.loaderhomework.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.homework.sbt.loaderhomework.R;
import com.homework.sbt.loaderhomework.data.Person;

import java.util.ArrayList;
import java.util.List;

public class RecyclerPersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Person> mPersons;

    public RecyclerPersonAdapter() {
        mPersons = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    private static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView mFirstNameTextView;
        TextView mLastNameTextView;
        TextView mAgeTextView;

        public PersonViewHolder(View itemView) {
            super(itemView);
//            mFirstNameTextView = itemView.findViewById(R.id.);
//            mLastNameTextView = itemView.findViewById(R.id);
//            mAgeTextView = itemView.findViewById(R.id);
        }
    }
}
