import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<String> toStringList(String file) {
        ArrayList<String> words = new ArrayList<>(); 
        try {
            words = (ArrayList<String>) Files.readAllLines(new File(file).toPath());
        } catch (IOException e) {}
        return words; 
    }
}
