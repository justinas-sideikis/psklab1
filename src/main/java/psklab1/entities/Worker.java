package psklab1.entities;

import java.io.Serializable;

public class Worker implements Serializable {
    private String name;
    private String surname;
    private String middlename;

    public Worker(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Worker(String name, String surname, String middlename) {
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}