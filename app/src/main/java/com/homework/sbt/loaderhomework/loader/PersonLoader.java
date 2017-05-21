package com.homework.sbt.loaderhomework.loader;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.homework.sbt.loaderhomework.data.Person;
import com.homework.sbt.loaderhomework.storage.PersonStorage;

import java.util.List;

public class PersonLoader extends AsyncTaskLoader<List<Person>> implements PersonStorage.OnContentChangeListner {
    private static final String TAG = PersonLoader.class.getCanonicalName();
    private PersonStorage mPersonStorage;
    private List<Person> mCachedPersonList;

    //Конструктор, получаем storage, устанавливаем loader слушателем для storage
    public PersonLoader(Context context, PersonStorage personStorage) {
        super(context);
        mPersonStorage = personStorage;
        mPersonStorage.addOnContentChangeListner(this);
        Log.e(TAG, "PersonLoader constructor");
    }

    //Загружаем список персон из storage
    @Override
    public List<Person> loadInBackground() {
        Log.e(TAG, "public List<Person> loadInBackground()");
        SystemClock.sleep(500);
        return mPersonStorage.getmPersonList();
    }

    //Проверяем если у нас пустой кэш или storage был изменен
    //Если да - запускаем загрузку, нет возвращаем кэшированый результат
    @Override
    protected void onStartLoading() {
        Log.e(TAG, "protected void onStartLoading()");
        if (mCachedPersonList == null || takeContentChanged()) {
            forceLoad();
        } else {
            deliverResult(mCachedPersonList);
        }
    }

    //Возвращаем результат, и сохраняем его в кэш
    @Override
    public void deliverResult(List<Person> data) {
        Log.e(TAG, "public void deliverResult(List<Person> data)");
        super.deliverResult(data);
        mCachedPersonList = data;
    }

    //При ресете, отписываемся из слушателей у storage
    @Override
    protected void onReset() {
        Log.e(TAG, "protected void onReset()");
        mPersonStorage.removeOnContentChangeListner(this);
        super.onReset();
    }

    //При добавлении пользователя в лист, сообщаем об этом лоадеру
    @Override
    public void onPersonAdd(PersonStorage sender, Person person) {
        Log.e(TAG, "public void onPersonAdd(PersonStorage sender, Person person)");
        onContentChanged();
    }

    //При удалении прользователя из стореджа, собщаяем об этом лоадеру
    @Override
    public void onPersonRemove(PersonStorage sender, Person person) {
        Log.e(TAG, "public void onPersonRemove(PersonStorage sender, Person person)");
        onContentChanged();
    }
}
