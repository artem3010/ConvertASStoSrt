package com.artem3010.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainWorker {
    private Path pathSource;
    private DAO DAO;

    public MainWorker(Path pathSource) {
        this.pathSource = pathSource;
    }

    /**
     * save to file
     * @param destination
     */
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
                    firstLine = Extractor.isBeginOfPhrase(firstLine) ? firstLine : "";
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

    /**
     * save to db
     * @param tableName
     * @param charset
     */
    public void convert(String tableName, String charset) {
        DAO = com.artem3010.converter.DAO.getInstance(tableName);
        String firstLine = "";
        String secondLine = "";
        try (BufferedReader bufferedReader = Files.newBufferedReader(pathSource, Charset.forName(charset))) {
            while (bufferedReader.ready()) {

                if (!firstLine.equals("")) {
                    Phrase phrase = Extractor.extractPhrase(firstLine);
                    DAO.addElement(phrase);
                    firstLine = secondLine;
                } else {
                    firstLine = bufferedReader.readLine();
                    firstLine = Extractor.isBeginOfPhrase(firstLine) ? firstLine : "";
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
