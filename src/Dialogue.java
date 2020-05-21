import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Dialogue {
    private StringBuffer[] time = new StringBuffer[2];
    private StringBuffer phrase;
    private int number;

    public Dialogue() {
        super();
    }

    public Dialogue(int number, StringBuffer[] time, StringBuffer phrase) {
        this.number = number;
        this.time = time;
        this.phrase = phrase;
    }

    public StringBuffer[] getTime() {
        return time;
    }

    public StringBuffer getPhrase() {
        return phrase;
    }

    public int getNumber() {
        return number;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dialogue dialogue = (Dialogue) o;
        if (this.phrase == dialogue.phrase){
            return true;
        }
        return number == dialogue.number &&
                Arrays.equals(time, dialogue.time) &&
                Objects.equals(phrase, dialogue.phrase);
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
