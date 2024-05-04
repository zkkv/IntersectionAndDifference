import org.github.zkkv.Solver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSuite {

    private Solver solver;
    private final String relPath = "src/test/resources/";

    @BeforeEach
    void setUp() {
        solver = new Solver();
    }

    @Test
    void normalTest() throws IOException {
        String contents1 = Files.readString(Paths.get(relPath + "normalTest/in1.json"));
        String contents2 = Files.readString(Paths.get(relPath + "normalTest/in2.json"));

        String[] solution = solver.solve(contents1, contents2);

        String expected1 = Files.readString(Paths.get(relPath + "normalTest/out1.json"));
        String expected2 = Files.readString(Paths.get(relPath + "normalTest/out2.json"));
        String expectedBothV1 = Files.readString(Paths.get(relPath + "normalTest/out_both_v1.json"));
        String expectedBothV2 = Files.readString(Paths.get(relPath + "normalTest/out_both_v2.json"));

        List<String> expectedBoth = List.of(expectedBothV1, expectedBothV2);
        assertEquals(expected1, solution[0]);
        assertEquals(expected2, solution[1]);
        assertTrue(expectedBoth.contains(solution[2]));
    }

    @Test
    void oneEmptyTest() throws IOException {
        String contents1 = Files.readString(Paths.get(relPath + "oneEmptyTest/in1.json"));
        String contents2 = Files.readString(Paths.get(relPath + "oneEmptyTest/in2.json"));

        String[] solution = solver.solve(contents1, contents2);

        String expected1 = Files.readString(Paths.get(relPath + "oneEmptyTest/out1.json"));
        String expected2V1 = Files.readString(Paths.get(relPath + "oneEmptyTest/out2_v1.json"));
        String expected2V2 = Files.readString(Paths.get(relPath + "oneEmptyTest/out2_v2.json"));
        String expectedBoth= Files.readString(Paths.get(relPath + "oneEmptyTest/out_both.json"));

        List<String> expected2 = List.of(expected2V1, expected2V2);
        assertEquals(expected1, solution[0]);
        assertTrue(expected2.contains(solution[1]));
        assertEquals(expectedBoth, solution[2]);
    }
}
