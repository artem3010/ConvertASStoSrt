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


}
