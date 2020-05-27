import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchNeedfulsTest {

    @Test
    void definePhrase() {
        StringBuffer stringBuffer = new StringBuffer("Dialogue: 5,0:00:08.98,0:00:10.40,It,,0,0,0,, Привет, Мишелла.\n");
        String actual = SearchNeedfuls.definePhrase(stringBuffer);
        String expected = " Привет, Мишелла.";
        assertEquals(expected,actual);
    }

    @Test
    void defineTime() {
        StringBuffer stringBuffer = new StringBuffer("Dialogue: 5,0:00:08.98,0:00:10.40,It,,0,0,0,, Привет, Мишелла.\n");
        String[] actual = SearchNeedfuls.defineTime(stringBuffer);
        String[] excepted = {"0:00:08,98","0:00:10,40"};
        assertEquals(excepted[0].toString(), actual[0].toString());
        assertEquals(excepted[1].toString(), actual[1].toString());
    }
}