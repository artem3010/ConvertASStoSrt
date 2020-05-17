import java.util.List;

public class SearchNeedfuls {
    private StringBuffer line;


    public SearchNeedfuls() {
        super();
        line = null;
    }

    public static void fullTreatmentASS(StringBuffer line) {

        //reduceBraces(line);
    }

    public void setLine(StringBuffer line) {
        this.line = line;
    }

    public static void reduceBraces(StringBuffer line) {
        int openBracket = line.indexOf("{");
        int closeBracket = line.indexOf("}") + 1;

        while (openBracket > -1 && (closeBracket > -1 && closeBracket >= openBracket)) {
            line.delete(openBracket, closeBracket);
            openBracket = line.indexOf("{");
            closeBracket = line.indexOf("}") + 1;
        }

    }

    public static StringBuffer definePhrase(StringBuffer line) {
        StringBuffer phrase = new StringBuffer();
        phrase.append(line.substring(line.lastIndexOf(",,")+2,line.length()-1));
        return  phrase;
    }


    public static StringBuffer[] defineTime(StringBuffer line) {
        StringBuffer[] time = new StringBuffer[2];
        time[0] = new StringBuffer();
        time[1] = new StringBuffer();
        int timeLength = 10;
        int startTime = line.indexOf(",") > 0 ? line.indexOf(",") + 1 : 0;
        if (line.indexOf(",") > 0) {
            time[0].append(line.substring(startTime, startTime + timeLength));
            startTime = startTime + timeLength + 2;
            time[1].append(line.substring(startTime, startTime + timeLength));
        }
        return time;
    }

        public static void deleteSlashElements (StringBuffer line){
            while (line.indexOf("\\h") > 0) {
                line.delete(line.indexOf("\\h"), line.indexOf("\\h") + 2);
            }
            while (line.indexOf("\\N") != -1) {
                line.delete(line.indexOf("\\N"), line.indexOf("\\N") + 2);
            }

        }


    }
