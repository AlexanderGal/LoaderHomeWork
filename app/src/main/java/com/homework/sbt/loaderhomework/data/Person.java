package com.homework.sbt.loaderhomework.data;

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
    public String toString() {
        return "Person{" +
                "mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mAge=" + mAge +
                '}';
    }
}
