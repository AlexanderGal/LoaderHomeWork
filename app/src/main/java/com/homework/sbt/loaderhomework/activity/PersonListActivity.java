package com.homework.sbt.loaderhomework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.homework.sbt.loaderhomework.R;
import com.homework.sbt.loaderhomework.adapter.RecyclerPersonAdapter;
import com.homework.sbt.loaderhomework.data.Person;
import com.homework.sbt.loaderhomework.loader.PersonLoader;
import com.homework.sbt.loaderhomework.storage.PersonStorage;
import com.homework.sbt.loaderhomework.storage.PersonStorageProvider;

import java.util.List;

public class PersonListActivity extends AppCompatActivity {
    private static final String TAG = PersonListActivity.class.getCanonicalName();
    private static final int LOADER_ID = 431234;

    private RecyclerView mRecyclerView;
    private RecyclerPersonAdapter mRecyclerPersonAdapter;
    private PersonStorage mPersonStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "protected void onCreate(Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_list_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PersonStorageProvider provider = (PersonStorageProvider) getApplication();
        mPersonStorage = provider.getPersonStorage();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerPersonAdapter = new RecyclerPersonAdapter();
        mRecyclerView.setAdapter(mRecyclerPersonAdapter);

        getSupportLoaderManager().initLoader(LOADER_ID, null, new PersonLoaderCallbacks());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.e(TAG, "public boolean onCreateOptionsMenu(Menu menu)");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e(TAG, "public boolean onOptionsItemSelected(MenuItem item)");
        int id = item.getItemId();
        if (id == R.id.add_new_person_menu_item) {
            startActivity(new Intent(this, PersonAddActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class PersonLoaderCallbacks implements LoaderManager.LoaderCallbacks<List<Person>> {
        private String TAG = PersonLoaderCallbacks.class.getCanonicalName();

        @Override
        public Loader<List<Person>> onCreateLoader(int id, Bundle args) {
            Log.e(TAG, "public Loader<List<Person>> onCreateLoader(int id, Bundle args)");
            return new PersonLoader(PersonListActivity.this,mPersonStorage);
        }

        @Override
        public void onLoadFinished(Loader<List<Person>> loader, List<Person> data) {
            Log.e(TAG, "public void onLoadFinished(Loader<List<Person>> loader, List<Person> data)");
            mRecyclerPersonAdapter.setmPersons(data);
        }

        @Override
        public void onLoaderReset(Loader<List<Person>> loader) {
            Log.e(TAG, "public void onLoaderReset(Loader<List<Person>> loader)");
        }
    }
}
