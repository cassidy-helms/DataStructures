package com.breadth_first_search;

public class Person {
    private String name;
    private String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj instanceof Person) {
            Person p = (Person) obj;
            return this.getName().equals(p.getName()) && this.getCity().equals(p.getCity());
        }

        return false;
    }

    @Override
    public String toString() {
        return name + " - " + city;
    }
}
