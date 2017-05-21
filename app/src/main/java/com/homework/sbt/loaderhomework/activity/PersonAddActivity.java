package com.homework.sbt.loaderhomework.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.homework.sbt.loaderhomework.R;
import com.homework.sbt.loaderhomework.data.Person;
import com.homework.sbt.loaderhomework.storage.PersonStorage;
import com.homework.sbt.loaderhomework.storage.PersonStorageProvider;

public class PersonAddActivity extends AppCompatActivity {
    private static final String TAG = PersonAddActivity.class.getCanonicalName();
    private EditText mPersonFirstName;
    private EditText mPersonLastName;
    private EditText mPersonAge;
    private Button mAddNewPerson;

    private PersonStorage mPersonStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "protected void onCreate(Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_add_layout);

        mPersonFirstName = (EditText) findViewById(R.id.person_firstname_edit_text);
        mPersonLastName = (EditText) findViewById(R.id.person_lastname_edit_text);
        mPersonAge = (EditText) findViewById(R.id.person_age_edit_text);
        mAddNewPerson = (Button) findViewById(R.id.add_new_person_button);

        PersonStorageProvider provider = (PersonStorageProvider) getApplication();

        mPersonStorage = provider.getPersonStorage();

        mAddNewPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkField(mPersonFirstName, mPersonLastName, mPersonAge))
                    addNewPerson();
            }
        });
    }

    private void addNewPerson() {
        Log.e(TAG, "private void addNewPerson()");
        String firstName = mPersonFirstName.getText().toString();
        String lastName = mPersonLastName.getText().toString();
        Integer age = Integer.valueOf(mPersonAge.getText().toString());

        Person person = new Person(firstName, lastName, age);
        mPersonStorage.addPerson(person);
        finish();
    }

    private boolean checkField(EditText... editTexts) {
        for (EditText editText : editTexts) {
            if (editText.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), R.string.all_field_is_req, Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }
}
