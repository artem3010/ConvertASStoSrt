import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dialogue {
    private StringBuffer[] time = new StringBuffer[2];
    private StringBuffer phrase;
    private int number;

    public Dialogue(){
        super();
    }
    public Dialogue(int number, StringBuffer[] time, StringBuffer phrase ){
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

    public void writeInFile(BufferedWriter bw){
        try{

            bw.write(number+System.getProperty("line.separator"));
            bw.write(time[0]+" --> "+ time[1]+System.getProperty("line.separator"));
            bw.write(phrase+System.getProperty("line.separator")+System.getProperty("line.separator"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
