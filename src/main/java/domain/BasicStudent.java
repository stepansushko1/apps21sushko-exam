package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {}

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair jsonName = new JsonPair("Name", new JsonString(this.name));
        JsonPair jsonSurname = new JsonPair("Surname", new JsonString(this.surname));
        JsonPair jsonYear = new JsonPair("Year", new JsonNumber(this.year));
        return new JsonObject(jsonName, jsonSurname, jsonYear);
    }
}
