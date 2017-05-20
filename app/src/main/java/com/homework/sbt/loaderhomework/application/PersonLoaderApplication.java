package com.homework.sbt.loaderhomework.application;

import android.app.Application;

import com.homework.sbt.loaderhomework.storage.PersonStorage;
import com.homework.sbt.loaderhomework.storage.PersonStorageProvider;

/**
 * Наследуемся от Application.
 * Сохраняем в него Storage, для возможности обращения к нему из приложения
 *
 * Прописываем в Манифесте.
 */

public class PersonLoaderApplication extends Application implements PersonStorageProvider {
    private PersonStorage mPersonStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        mPersonStorage = new PersonStorage();
    }

    @Override
    public PersonStorage getPersonStorage() {
        return mPersonStorage;
    }
}
