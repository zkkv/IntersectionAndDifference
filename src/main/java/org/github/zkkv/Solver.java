package org.github.zkkv;

import java.util.Set;

public class Solver {
    public String[] solve(String contents1, String contents2) {
        Converter converter = new Converter();

        Set<Problem> analysis1 = converter.jsonToSet(contents1);
        Set<Problem> analysis2 = converter.jsonToSet(contents2);

        Set<Problem> leftDifference  = UnionOperations.difference(analysis1, analysis2);
        Set<Problem> rightDifference = UnionOperations.difference(analysis2, analysis1);
        Set<Problem> intersection = UnionOperations.intersection(analysis1, analysis2);

        String json1 = converter.setToJson(leftDifference);
        String json2 = converter.setToJson(rightDifference);
        String jsonBoth = converter.setToJson(intersection);

        return new String[]{json1, json2, jsonBoth};
    }
}
