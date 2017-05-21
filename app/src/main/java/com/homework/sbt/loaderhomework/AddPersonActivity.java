package com.homework.sbt.loaderhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.homework.sbt.loaderhomework.data.Person;
import com.homework.sbt.loaderhomework.storage.PersonStorage;
import com.homework.sbt.loaderhomework.storage.PersonStorageProvider;

public class AddPersonActivity extends AppCompatActivity {
    private static final String TAG = AddPersonActivity.class.getCanonicalName();
    private EditText mPersonFirstName;
    private EditText mPersonLastName;
    private EditText mPersonAge;
    private Button mAddNewPerson;

    private PersonStorage mPersonStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "protected void onCreate(Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        mPersonFirstName = (EditText) findViewById(R.id.person_firstname_edit_text);
        mPersonLastName = (EditText) findViewById(R.id.person_lastname_edit_text);
        mPersonAge = (EditText) findViewById(R.id.person_age_edit_text);
        mAddNewPerson = (Button) findViewById(R.id.add_new_person_button);

        PersonStorageProvider provider = (PersonStorageProvider) getApplication();

        mPersonStorage = provider.getPersonStorage();

        mAddNewPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewPerson();
            }
        });
    }

    private void addNewPerson() {
        Log.e(TAG, "private void addNewPerson()");
        String firstName = mPersonFirstName.getText().toString();
        String lastName = mPersonLastName.getText().toString();
        int age = Integer.valueOf(mPersonAge.getText().toString());

        Person person = new Person(firstName, lastName, age);
        mPersonStorage.addPerson(person);
    }
}
