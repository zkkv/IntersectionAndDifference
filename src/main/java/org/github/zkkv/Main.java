package org.github.zkkv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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

        Solver solver = new Solver();
        String[] solution = solver.solve(contents1, contents2);

        Files.writeString(Paths.get(outPath1), solution[0]);
        Files.writeString(Paths.get(outPath2), solution[1]);
        Files.writeString(Paths.get(outPathBoth), solution[2]);
    }
}