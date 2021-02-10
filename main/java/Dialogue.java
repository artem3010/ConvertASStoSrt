import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Dialogue {
    private String[] time = new String[2];
    private String phrase;
    private int number;
    public Dialogue(int number, String[] time, String phrase) {
        this.number = number;
        this.time = time;
        this.phrase = phrase;
    }

    public String[] getTime() {
        return time;
    }

    public void writeInFile(BufferedWriter bw) {
        try {
            bw.write(number + System.getProperty("line.separator"));
            bw.write(time[0] + " --> " + time[1] + System.getProperty("line.separator"));
            bw.write(phrase + System.getProperty("line.separator") + System.getProperty("line.separator"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean isInCollection(List<Dialogue> list) {
        for (Dialogue d : list) {
            if (d.equals(this)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dialogue dialogue = (Dialogue) o;
        return (time[0].equals(dialogue.getTime()[0]) &&
                time[1].equals(dialogue.getTime()[1]) &&
                phrase.equals(dialogue.phrase)) || (time[0].equals(dialogue.getTime()[0]) &&
                time[1].equals(dialogue.getTime()[1])) || (time[1].equals(dialogue.getTime()[0]) &&
                phrase.equals(dialogue.phrase));
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(phrase, number);
        result = 31 * result + Arrays.hashCode(time);
        return result;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
