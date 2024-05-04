package org.github.zkkv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String inPath1 = scanner.next();
        String inPath2 = scanner.next();
        String outPath1 = scanner.next();
        String outPath2 = scanner.next();
        String outPathBoth = scanner.next();

        String contents1 = Files.readString(Paths.get(inPath1));
        String contents2 = Files.readString(Paths.get(inPath2));

        Converter converter = new Converter();

        Set<Problem> analysis1 = converter.jsonToSet(contents1);
        Set<Problem> analysis2 = converter.jsonToSet(contents2);

        Set<Problem> intersection = UnionOperations.intersection(analysis1, analysis2);
        Set<Problem> leftDifference  = UnionOperations.difference(analysis1, analysis2);
        Set<Problem> rightDifference = UnionOperations.difference(analysis2, analysis1);

        String json1 = converter.setToJson(leftDifference);
        String json2 = converter.setToJson(rightDifference);
        String jsonBoth = converter.setToJson(intersection);

        Files.writeString(Paths.get(outPath1), json1);
        Files.writeString(Paths.get(outPath2), json2);
        Files.writeString(Paths.get(outPathBoth), jsonBoth);
    }
}