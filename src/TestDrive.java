import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDrive {
    public static void main(String[] args) throws IOException {
        File f = new File(args[0]);
        File f2 = new File(args[1]);
        Converter converter = new Converter(f);
        converter.convertASStoSRT(f2);
        List<Dialogue> dialogues =converter.getDialogues();
        for (Dialogue diag: dialogues) {

            System.out.println( diag.getNumber());
            System.out.println(diag.getTime()[0]+" --> "+diag.getTime()[1]);
            System.out.println(diag.getPhrase()+" \n_____________________________________");
        }
    }
}
