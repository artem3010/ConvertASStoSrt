public class DeleteSuperfluous {
    private StringBuffer line;


    public DeleteSuperfluous() {
        super();
        line = null;
    }

    public DeleteSuperfluous(StringBuffer line) {
        this.line = line;
        reduceSuperfluous(this.line);
    }

    public void setLine(StringBuffer line) {
        this.line = line;
    }

    public void reduceSuperfluous(StringBuffer line) {
        int openBracket = line.indexOf("{");
        int closeBracket = line.indexOf("}");

        while (openBracket != -1 || closeBracket != -1) {
            line.delete(openBracket, closeBracket);
            openBracket = line.indexOf("{");
            closeBracket = line.indexOf("}");
        }

    }


}
