package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private final Tuple<String, Integer>[] exams;

    @SafeVarargs
    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }


    @Override
    public JsonObject toJsonObject() {
        JsonPair jsonName = new JsonPair("name", new JsonString(this.name));
        JsonPair jsonSurname = new JsonPair("surname", new JsonString(this.surname));
        JsonPair jsonYear = new JsonPair("year", new JsonNumber(this.year));

        JsonObject[] examsList = new JsonObject[this.exams.length];
        int k = 0;

        for (int i = 0; i < this.exams.length; i++) {
            JsonPair course = new JsonPair("course", new JsonString(this.exams[i].key));
            JsonPair mark = new JsonPair("mark", new JsonNumber(this.exams[i].value));
            boolean isPassed = this.exams[i].value >= 3;
            JsonPair passed = new JsonPair("passed", new JsonBoolean(isPassed));

            JsonObject newExam = new JsonObject(course, mark, passed);
            examsList[k++] = newExam;
        }

        JsonArray infoArray = new JsonArray(examsList);
        JsonPair jExams = new JsonPair("exams", infoArray);
        return new JsonObject(jsonName, jsonSurname, jsonYear, jExams);
    }
}