import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private List<String> fileContent = new ArrayList<>();
    private File file;

    public FileWork(File f) {
        file = f;
        readDialogues();
        fileContent.forEach(Separator::separateOnLines);
    }

    public List<String> getFileContent() {
        return fileContent;
    }

    private void readDialogues() {
        String stringInByte = "";
        String line = null;

            try (BufferedReader reader = new BufferedReader(new FileReader(file.getName()))){
                while ((line = reader.readLine()) != null) {
                    fileContent.add(line);
                }
            } catch (IOException e) {
                System.out.printf(e.getMessage());
            }
    }
}



