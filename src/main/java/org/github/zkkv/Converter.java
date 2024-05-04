package org.github.zkkv;

import com.google.gson.Gson;
import java.util.Set;

public class Converter {

    Gson gson;

    public Converter() {
        gson = new Gson();
    }

    public Set<Problem> jsonToSet(String json) {
        OuterObject outer = gson.fromJson(json, OuterObject.class);
        return outer.problems;
    }

    public String setToJson(Set<Problem> set) {
        return gson.toJson(set);
    }
}
