import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDrive {
    public static void main(String[] args) throws IOException {
        List<Dialogue> dialogues = new ArrayList<>();
        File f = new File("C:\\Users\\Artem\\Downloads\\kekai senen\\1\\[HorribleSubs] Kekkai Sensen - 01 [720p].ass" );
        File f2 = new File("C:\\Users\\Artem\\Downloads\\1.srt");
        Converter converter = new Converter();
        FileWork fileWork = new FileWork(f);
        dialogues = converter.convertASStoSRT(fileWork.getFileContent());
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f2.getPath()))){
        for (Dialogue diag: dialogues) {
            diag.writeInFile(bw);
//            System.out.println( diag.getNumber());
//            System.out.println(diag.getTime()[0]+" --> "+diag.getTime()[1]);
//            System.out.println(diag.getPhrase()+" \n_____________________________________");
        }}catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
