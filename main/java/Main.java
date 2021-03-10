import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
//        args[0] = "F:\\Рабочий стол\\untitled4\\src\\main\\java\\3.ass";
//        args[1] = "phrases";
        MainWorker mainWorker = new MainWorker(Path.of("F:\\Рабочий стол\\untitled4\\src\\main\\java\\3.ass"));
        mainWorker.convert(Path.of("F:\\Рабочий стол\\txt.srt"));

    }
}
