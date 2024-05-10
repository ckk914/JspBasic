package com.jsp.chap05;

import java.util.Objects;

public class Person {
    private int id;
    private String personName;
    private int personAge;

    public Person(int id, String personName, int personAge) {
        this.id = id;
        this.personName = personName;
        this.personAge = personAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && personAge == person.personAge && Objects.equals(personName, person.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personName, personAge);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", personAge=" + personAge +
                '}';
    }

}
