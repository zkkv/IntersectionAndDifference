package org.github.zkkv;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.Set;

public class Converter {

    Gson gson;

    public Converter() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public Set<Problem> jsonToSet(String json) {
        OuterObject outer = gson.fromJson(json, OuterObject.class);
        return outer.problems;
    }

    public String setToJson(Set<Problem> set) {
        String plain = gson.toJson(new OuterObject(set));
        JsonElement jsonElem = JsonParser.parseString(plain);
        return gson.toJson(jsonElem);
    }
}
