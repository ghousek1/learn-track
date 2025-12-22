package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.Main;

public class Student extends Person {
    private String batch;
    private boolean active;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String batch) {
        super(id, firstName, lastName, null);
        this.batch = batch;
        this.active = true;
    }

    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    public String getBatch() {
        return batch;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String getDisplayName() {
        return super.getDisplayName() + " (Student - " + batch + ")";
    }
}
