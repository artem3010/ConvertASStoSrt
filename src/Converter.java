import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static List<StringBuffer> subsSTR = new ArrayList<>();

    public static enum tumbler {
        FIRSTLINE,
        NOTFIRSTLINE,
    }

    private static boolean searchDialogue(String str) {
        if (str.indexOf("Dialogue:") != -1) {
            return true;
        } else {
            return false;
        }
    }


    public List<StringBuffer> getSubsSTR() {
        return subsSTR;
    }

    public void convertASStoTXT(File file){

    }





}
