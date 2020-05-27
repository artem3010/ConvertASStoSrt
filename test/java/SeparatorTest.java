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
        List<String> stringList = new ArrayList<>();
        stringList.add(", Привет,");
        stringList.add("Dialogue: 5,0:00:08.98,0:00:10.40,It,,0,0,0,, Привет,");
        stringList.add("Мишелла.");
        stringList.add("Dialogue: 5,0:00:10.40,0:00:12.11,It,,0,0,0,,Как поживаешь?");
        stringList.add("Dialogue: 5,0:00:12.11,0:00:13.74,It,,0,0,0,,У меня всё хорошо.");
        stringList.add("Dialogue: 5,0:00:14.49,0:00:18.28,It,,0,0,0,,Уже полгода прошло с тех пор,");
        stringList.add("как я переехал в этот город.");
        List<StringBuffer> stringBuffers = Separator.separateDialogue(stringList);
        List<String> actual = new ArrayList<String>();
        for (StringBuffer sb: stringBuffers) {
        actual.add(sb.toString());
        }
        List<String> expected = new ArrayList<>();
        expected.add("Dialogue: 5,0:00:08.98,0:00:10.40,It,,0,0,0,, Привет, Мишелла.");
        expected.add("Dialogue: 5,0:00:10.40,0:00:12.11,It,,0,0,0,,Как поживаешь?");
        expected.add("Dialogue: 5,0:00:12.11,0:00:13.74,It,,0,0,0,,У меня всё хорошо.");
        expected.add("Dialogue: 5,0:00:14.49,0:00:18.28,It,,0,0,0,,Уже полгода прошло с тех пор, как я переехал в этот город.");
        assertEquals( expected,actual);
    }
}