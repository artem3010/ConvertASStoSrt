import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static List<StringBuffer> subsSTR = new ArrayList<>();

    public void convertASStoSRT(List<String> strings){
        subsSTR = Separator.separateDialogue(strings);
        DeleteSuperfluous.deleteNotDialogue(subsSTR);
       // DeleteSuperfluous.fullTreatmentASS(subsSTR.get(0));
    }



    public List<StringBuffer> getSubsSTR() {

        return subsSTR;
    }

    public void convertASStoTXT(File file){

    }





}
