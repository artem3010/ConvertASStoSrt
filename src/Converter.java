import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Converter {
    private static List<StringBuffer> subsSTR = new ArrayList<>();
    private FileWork fileWork;
    private List<Dialogue> dialogues = new ArrayList<>();

    public Converter() {
        super();
    }

    public List<Dialogue> getDialogues() {
        return dialogues;
    }

    public Converter(File file) {
        super();
        try {
            this.fileWork = new FileWork(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void convertASStoSRT(File file) {
        subsSTR = Separator.separateDialogue(fileWork.getFileContent());

        for (StringBuffer str : subsSTR) {
            if (dialogues.size() > 0
                    && !new Dialogue(dialogues.size() + 1,
                    SearchNeedfuls.defineTime(str),
                    SearchNeedfuls.definePhrase(str)).isInCollection(dialogues))
            {
                dialogues.add(new Dialogue(dialogues.size() + 1,
                        SearchNeedfuls.defineTime(str), SearchNeedfuls.definePhrase(str)));
            } else if (dialogues.size() == 0) {
                dialogues.add(new Dialogue(dialogues.size() + 1,
                        SearchNeedfuls.defineTime(str), SearchNeedfuls.definePhrase(str)));
            }

        }
        outInFile(file);
    }

    private void outInFile(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()))) {
            for (Dialogue diag : dialogues) {
                diag.writeInFile(bw);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
