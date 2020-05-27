import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private List<String> fileContent = new ArrayList<>();
    private File file;

    public FileWork(File f) throws IOException {
        file = f;
        readDialogues();
        for (String str : fileContent) {
            Separator.separateOnLines(str);
        }
    }

    public List<String> getFileContent() {
        return fileContent;
    }

    private void readDialogues() {
        String stringInByte = "";
        if (isTXT(file.getName())) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file.getName()));
                String line = null;
                String ls = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    fileContent.add(line);

                }
            } catch (FileNotFoundException e) {
                System.out.printf(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
                stringInByte = new String(bytes, "UTF-8");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                ;
            }
            fileContent = Separator.separateOnLines(stringInByte);

        }
    }

    private boolean isTXT(String string) {
        return ((string.indexOf(".txt") != -1) ? true : false);
    }

    public File getFile() {
        return file;
    }
}



