package com.artem3010.converter;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        //from
        MainWorker mainWorker = new MainWorker(Path.of("F:\\Рабочий стол\\"));
        //to
        mainWorker.convert(Path.of("F:\\"));

    }
}
