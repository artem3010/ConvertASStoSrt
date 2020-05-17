import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDrive {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Artem\\Downloads\\kekai senen\\1\\[HorribleSubs] Kekkai Sensen - 01 [720p].ass" );
        Converter converter = new Converter();
        FileWork fileWork = new FileWork(f);
//        for (String str: fileWork.getFileContent()) {
//            System.out.println(str);
//        }
        converter.convertASStoSRT(fileWork.getFileContent());
        for (StringBuffer str: converter.getSubsSTR()) {
            System.out.println(str);
        }
    }
}
