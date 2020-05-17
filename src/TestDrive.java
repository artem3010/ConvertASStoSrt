import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDrive {
    public static void main(String[] args) throws IOException {
        List<Dialogue> dialogues = new ArrayList<>();
        File f = new File("C:\\Users\\Artem\\Downloads\\kekai senen\\1\\[HorribleSubs] Kekkai Sensen - 01 [720p].ass" );
        Converter converter = new Converter();
        FileWork fileWork = new FileWork(f);
//chek commit
        dialogues = converter.convertASStoSRT(fileWork.getFileContent());
        for (Dialogue diag: dialogues) {
            System.out.println( diag.getNumber());
            System.out.println(diag.getTime()[0]+" --> "+diag.getTime()[1]);
            System.out.println(diag.getPhrase()+" \n_____________________________________");
        }
    }
}
