package com.homework.sbt.loaderhomework.storage;

import com.homework.sbt.loaderhomework.data.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonStorage {
    //Неизменяемый лист, для сохранения инацилизации начальных данных\
    private final static List<Person> mDefaultPersonList;
    //Лист, хранящий дефолтные данные. И данные добавленные пользователем
    private final List<Person> mPersonList;
    //Лист слушателей. Оповещаеят о добавлении пользователя в сторедж
    private final List<OnContentChangeListner> mOnContentChangeListners;

    //Статический блок для инициализации дефолтного листа
    static {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Исаак", "Ньютон", 54));
        list.add(new Person("Цай", "Лунь", 36));
        list.add(new Person("Иоганн", "Гутенберг", 63));
        list.add(new Person("Альберт", "Эйнштейн", 47));
        list.add(new Person("Луи", "Пастер", 39));
        list.add(new Person("Галилей", "Галилео", 53));
        list.add(new Person("Цинь", "Шихуанди", 37));
        list.add(new Person("Октавиан", "Август", 53));

        mDefaultPersonList = Collections.unmodifiableList(list);
    }

    //Конструктор, инициализирует лист листнеров и лист персон с добавлением начальных данных
    public PersonStorage() {
        this.mPersonList = new ArrayList<>(mDefaultPersonList);
        mOnContentChangeListners = new ArrayList<>();
    }

    //Добавляем данные в лист и сообщаем слушателям
    public void addPerson(Person person) {
        mPersonList.add(person);
        for (OnContentChangeListner listner : mOnContentChangeListners) {
            listner.onPersonAdd(this, person);
        }
    }

    //Удаляем данные из листа и собщаем слушетлям
    public void removePerson(Person person) {
        mPersonList.remove(person);
        for (OnContentChangeListner listner : mOnContentChangeListners) {
            listner.onPersonRemove(this, person);
        }
    }

    public List<Person> getmPersonList() {
        return mPersonList;
    }

    public void addOnContentChangeListner(OnContentChangeListner listner) {
        mOnContentChangeListners.add(listner);
    }

    public void removeOnContentChangeListner(OnContentChangeListner listner) {
        mOnContentChangeListners.remove(listner);
    }

    //Интерфейс, необходим для оповещение Loadera - о изменении данных
    public interface OnContentChangeListner {
        void onPersonAdd(PersonStorage sender, Person person);

        void onPersonRemove(PersonStorage sender, Person person);
    }
}
