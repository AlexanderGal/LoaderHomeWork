package com.homework.sbt.loaderhomework.data;

/**
 * Простой класс сущности.
 */

public class Person {
    private String mFirstName;
    private String mLastName;
    private int mAge;

    public Person() {
    }

    public Person(String mFirstName, String mLastName, int mAge) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mAge = mAge;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (mAge != person.mAge) return false;
        if (mFirstName != null ? !mFirstName.equals(person.mFirstName) : person.mFirstName != null)
            return false;
        return mLastName != null ? mLastName.equals(person.mLastName) : person.mLastName == null;

    }

    @Override
    public int hashCode() {
        int result = mFirstName != null ? mFirstName.hashCode() : 0;
        result = 31 * result + (mLastName != null ? mLastName.hashCode() : 0);
        result = 31 * result + mAge;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mAge=" + mAge +
                '}';
    }
}
