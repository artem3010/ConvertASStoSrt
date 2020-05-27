import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeparatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void separateOnLines() {
        String string = "First line \n" +
                "Second line \n" +
                "Third Line \n" +
                "One more line \n" +
                "Blablabla line";
        List<String> expected = new ArrayList<>();
        expected.add("First line ");
        expected.add("Second line ");
        expected.add("Third Line ");
        expected.add("One more line ");
        expected.add("Blablabla line");
        List<String> actual = Separator.separateOnLines(string);
        assertEquals(expected,actual);
    }

    @Test
    void separateDialogue() {

    }
}