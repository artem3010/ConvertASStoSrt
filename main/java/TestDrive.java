import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestDrive {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Artem\\Downloads\\kekai senen\\1\\[HorribleSubs] Kekkai Sensen - 01 [720p].ass");
        File f2 = new File("C:\\Users\\Artem\\Downloads\\kekai senen\\1.srt");
        Converter converter = new Converter(f);
        converter.convertASStoSRT(f2);
        List<Dialogue> dialogues = converter.getDialogues();
    }
}
