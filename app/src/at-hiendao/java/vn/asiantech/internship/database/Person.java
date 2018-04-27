package vn.asiantech.internship.database;

public class Person {
    private final String mName;
    private final int mAge;

    Person(String name, int age) {
        mName = name;
        mAge = age;
    }

    public int getAge() {
        return mAge;
    }

    public String getName() {
        return mName;
    }
}
