package reg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        String filePath = "files/";
        File oldFile = new File(filePath + "test.txt");
        File newFile = new File(filePath + "te.txt");
        try {
            FileInputStream fis  = new FileInputStream(oldFile);
            byte [] bytes = fis.readAllBytes();
            Path path = Path.of(newFile.getPath());
            Files.write(path,bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
