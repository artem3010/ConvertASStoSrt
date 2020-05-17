import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static List<StringBuffer> subsSTR = new ArrayList<>();

    public List<Dialogue> convertASStoSRT(List<String> strings) {
        List<Dialogue> dialogues = new ArrayList<>();
        subsSTR = Separator.separateDialogue(strings);

       for (StringBuffer str: subsSTR) {
            dialogues.add(new Dialogue(dialogues.size()+1,
                    SearchNeedfuls.defineTime(str),SearchNeedfuls.definePhrase(str)));
       }
       return dialogues;
    }
}
