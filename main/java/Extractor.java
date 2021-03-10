public class Extractor {
    static private int incrementer;

    private static int[] splitTime(String strTime) {
        char[] tempCharArray = strTime.toCharArray();
        String stringHour = "";
        String stringMinutes = "";
        String stringSeconds = "";
        String stringMseconds = "";
        int[] indexesColon = new int[2];
        int countColon = 0;
        int indexDot = 0;
        /* Hours before first colon;
        minutes after first colon;
        seconds after second colon;
        mseconds after first DOT ;
         */
        for (int i = 0; i < tempCharArray.length; i++) {

            if (tempCharArray[i] == ':') {
                indexesColon[countColon] = i;
                countColon++;
            }
            if (tempCharArray[i] == '.') {
                indexDot = i;
            }
        }
        stringHour = strTime.substring(0, indexesColon[0]);
        stringMinutes = strTime.substring(indexesColon[0]+1, indexesColon[1]);
        stringSeconds = strTime.substring(indexesColon[1]+1, indexDot);
        stringMseconds = strTime.substring(indexDot+1);


        return new int[]{Integer.parseInt(stringHour), Integer.parseInt(stringMinutes),
                Integer.parseInt(stringSeconds), Integer.parseInt(stringMseconds)};
    }


    public static boolean isBeginOfPhrase(String str) {
        if (str.contains("Dialogue:")) {
            return true;
        }
        return false;
    }

    static public Phrase extractPhrase(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        int[] indexesCommas = new int[9];
        int countCommas = 0;
        char[] tempArray = str.toCharArray();

        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] == ',' && countCommas<9) {
                indexesCommas[countCommas] = i;
                countCommas++;
            }
        }
            String strTimeBegin = str.substring(indexesCommas[0]+1, indexesCommas[1]);//start time after first comma (by SSA specification)
            String strTimeEnd = str.substring(indexesCommas[1]+1, indexesCommas[2]);  //start time after first comma (by SSA specification)
            String phraseText = str.substring(indexesCommas[8]+1);                      // phrase text begin after ninth comma (by SSA specification)



        phraseText = extractText(phraseText);
        int[] intTimeBegin = splitTime(strTimeBegin);
        int[] intTimeEnd = splitTime(strTimeEnd);

        return new Phrase(++incrementer, intTimeBegin[0], intTimeBegin[1],intTimeBegin[2], intTimeBegin[3],
                intTimeEnd[0], intTimeEnd[1], intTimeEnd[2], intTimeEnd[3], phraseText);
    }


    private static String extractText(String string) {
        StringBuffer line = new StringBuffer(string);
        int openBracket = line.indexOf("{");
        int closeBracket = line.indexOf("}") + 1;

        while (openBracket > -1 && (closeBracket > -1 && closeBracket >= openBracket)) {
            line.delete(openBracket, closeBracket);
            openBracket = line.indexOf("{");
            closeBracket = line.indexOf("}") + 1;
        }

        while (line.indexOf("\\h") > 0) {
            line.delete(line.indexOf("\\h"), line.indexOf("\\h") + 2);
        }
        while (line.indexOf("\\N") != -1) {
            line.delete(line.indexOf("\\N"), line.indexOf("\\N") + 2);
        }

        return line.toString();
    }


}
