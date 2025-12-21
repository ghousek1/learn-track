package com.airtribe.learntrack.entity;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String batch;
    private boolean active;

    public Student() {}

    public Student(String firstName, String lastName, String batch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.batch = batch;
        this.active = true;
    }

    public Student(String firstName, String lastName, String email, String batch) {
        this(firstName, lastName, batch);
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
