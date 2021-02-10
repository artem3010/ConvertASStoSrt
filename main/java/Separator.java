import java.util.ArrayList;
import java.util.List;

public class Separator {
    public enum tumbler {
        FIRST_LINE_OF_PHRASE,
        NOT_FIRST_LINE_OF_PHRASE,
    }

    public static List<String> separateOnLines(String string) {
        String newString = string + "\u0000";
        char[] tempChar = newString.toCharArray();
        List<String> list = new ArrayList<>();
        String temp = "";
        for (char ch : tempChar) {
            if (ch != '\u0000' && ch != '\n') {
                temp += ch;
            } else {
                list.add(temp);
                temp = "";
            }
        }
        return list;
    }

    public static List<StringBuffer> separateDialogue(List<String> strings) {

        tumbler arg = tumbler.FIRST_LINE_OF_PHRASE;
        List<StringBuffer> list = new ArrayList<>();

        for (int i = 0; i < strings.size(); i++) {
            int count = i--;
            if (arg == tumbler.FIRST_LINE_OF_PHRASE) {
                list.add(new StringBuffer(strings.get(i)));
                arg = tumbler.NOT_FIRST_LINE_OF_PHRASE;
                count++;
            } else {
                list.get(count).append(" " + strings.get(i));
            }
            if (i + 1 < strings.size()) {
                arg = (strings.get(i + 1).indexOf("Dialogue:") != -1) ? tumbler.FIRST_LINE_OF_PHRASE : tumbler.NOT_FIRST_LINE_OF_PHRASE;
            }
        }
//        list.remove(0);
        return list;
    }
}
