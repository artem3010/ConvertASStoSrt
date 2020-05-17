import java.util.ArrayList;
import java.util.List;

public class Separator {
    public static List<String> separateOnLines(String string){
        char[] tempChar = string.toCharArray();
        List<String> list = new ArrayList<>();
        String temp="";
        for (char ch :tempChar ) {
            if(ch!='\n'){
                temp+=ch;
            } else {
                list.add(temp);
                temp ="";
            }
        }
        return list;
    }

    public static List<String> separateDialogue(List<String> strings, Converter.tumbler arg, Converter converter) {
        arg = Converter.tumbler.FIRSTLINE;
        int count = -1;
        for (int i = 0; i<strings.size(); i++ ) {
            if (arg == Converter.tumbler.FIRSTLINE) {
                converter.getSubsSTR().add(new StringBuffer(strings.get(i)));
                arg = Converter.tumbler.NOTFIRSTLINE;
                if (i+1<strings.size()) {
                    arg = (strings.get(i + 1).indexOf("Dialogue:") != -1) ? Converter.tumbler.FIRSTLINE : Converter.tumbler.NOTFIRSTLINE;
                }
                count++;
            } else if (arg== Converter.tumbler.NOTFIRSTLINE ){
                converter.getSubsSTR().get(count).append(" "+strings.get(i));
                if (i+1<strings.size()){
                    arg = (strings.get(i+1).indexOf("Dialogue:")!=-1)? Converter.tumbler.FIRSTLINE: Converter.tumbler.NOTFIRSTLINE;
                }
            }
        }
        return strings;
    }





}
