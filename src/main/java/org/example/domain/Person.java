package org.example.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Person {
    private final int id;
    private final String name;
    public Person(String json) {
        Person request = new Gson().fromJson(json, Person.class);
        this.id = request.getId();
        this.name = request.getName();
    }
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
