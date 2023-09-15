package com.bajidev.studentms.model;

public enum Category {

    TEACHER("Teacher"),
    STUDENT("Student");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
