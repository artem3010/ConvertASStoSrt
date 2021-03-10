import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainWorker {
    private Path pathSource;
    private DatabaseWork databaseWork;

    public MainWorker(Path pathSource) {
        this.pathSource = pathSource;
    }


    public void convert(Path destination) {
        String firstLine = "";
        String secondLine = "";
        try (BufferedReader bufferedReader = Files.newBufferedReader(pathSource);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(destination)) {
            while (bufferedReader.ready()) {
                if (!firstLine.equals("")) {
                    bufferedWriter.write(Extractor.extractPhrase(firstLine).toSRTFormat());
                    firstLine = secondLine;
                } else {
                    firstLine = bufferedReader.readLine();
                    firstLine = Extractor.isBeginOfPhrase(firstLine)?firstLine:"";
                    continue;
                }
                secondLine = bufferedReader.readLine();
                while (!Extractor.isBeginOfPhrase(secondLine)) {
                    firstLine += secondLine;
                    secondLine = bufferedReader.readLine();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void convert(String nameTable) {
        databaseWork = new DatabaseWork(nameTable);
        String firstLine = "";
        String secondLine = "";
        try (BufferedReader bufferedReader = Files.newBufferedReader(pathSource, Charset.forName("windows-1251"))) {
            while (bufferedReader.ready()) {

                if (!firstLine.equals("")) {
                    Phrase phrase = Extractor.extractPhrase(firstLine);
                    databaseWork.addElement(phrase);
                    firstLine = secondLine;
                } else {
                    firstLine = bufferedReader.readLine();
                    firstLine = Extractor.isBeginOfPhrase(firstLine)?firstLine:"";
                    continue;
                }
                secondLine = bufferedReader.readLine();
                while (!Extractor.isBeginOfPhrase(secondLine)) {
                    firstLine += secondLine;
                    secondLine = bufferedReader.readLine();
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
