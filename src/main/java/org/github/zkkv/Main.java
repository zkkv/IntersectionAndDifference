package org.github.zkkv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private final String file1 = """
            
            """;

    private final String file2 = """
            
            """;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // TODO: UNCOMMENT ME
        
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

        //debug(analysis1);
        //debug(analysis2);
    }

    // TODO: REMOVE ME
    private static void debug(Set<Problem> set) {
        for (Problem p : set) {
            System.out.println(p.hash);
            System.out.println("DATA:");
            for (String datum : p.data) {
                System.out.println(datum);
            }
            System.out.println();
        }
        System.out.println("==============================");
    }
}