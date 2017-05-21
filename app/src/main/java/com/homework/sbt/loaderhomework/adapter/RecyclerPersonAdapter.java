package com.homework.sbt.loaderhomework.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.homework.sbt.loaderhomework.R;
import com.homework.sbt.loaderhomework.data.Person;
import com.homework.sbt.loaderhomework.storage.PersonStorage;

import java.util.ArrayList;
import java.util.List;

public class RecyclerPersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static String TAG = RecyclerPersonAdapter.class.getCanonicalName();
    private final List<Person> mPersons;

    public RecyclerPersonAdapter(PersonStorage personStorage) {
        Log.e(TAG, "RecyclerPersonAdapter constructor");
        mPersons = personStorage.getmPersonList();
    }

    public void setmPersons(List<Person> list) {
        mPersons.clear();
        mPersons.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)");
        return new PersonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.person_card, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e(TAG, "public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)");
        Person person = mPersons.get(position);
        ((PersonViewHolder) holder).fillTextView(person.getmFirstName(), person.getmLastName(), person.getmAge());
    }


    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    private static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView mFirstNameTextView;
        TextView mLastNameTextView;
        TextView mAgeTextView;

        PersonViewHolder(View itemView) {
            super(itemView);
            mFirstNameTextView = (TextView) itemView.findViewById(R.id.person_firstname_text_view);
            mLastNameTextView = (TextView) itemView.findViewById(R.id.person_lastname_text_view);
            mAgeTextView = (TextView) itemView.findViewById(R.id.person_age_text_view);
        }

        void fillTextView(String firstName, String lastName, int age) {
            mFirstNameTextView.setText(firstName);
            mLastNameTextView.setText(lastName);
            mAgeTextView.setText(String.valueOf(age));
        }
    }
}
