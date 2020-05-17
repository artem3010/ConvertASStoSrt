import java.util.List;

public class DeleteSuperfluous {
    private StringBuffer line;


    public DeleteSuperfluous() {
        super();
        line = null;
    }

    public static void fullTreatmentASS(StringBuffer line){
        reduceBraces(line);
    }
    public void setLine(StringBuffer line) {
        this.line = line;
    }

    public static void reduceBraces(StringBuffer line) {
        int openBracket = line.indexOf("{");
        int closeBracket = line.indexOf("}")+1;

        while (openBracket > -1 && (closeBracket > -1 && closeBracket >= openBracket)) {
            line.delete(openBracket, closeBracket);
            openBracket = line.indexOf("{");
            closeBracket = line.indexOf("}")+1;
        }

    }

    public static void defineTime(StringBuffer line){
        int startTime = line.indexOf(",")+1;

    }

    public static void deleteNotDialogue(List<StringBuffer> string){
        for (int i = 0 ; i<string.size(); i++) {
            if (string.get(i).indexOf("Dialogue:")==-1){
                string.remove(i);
            }
        }
    }
}
