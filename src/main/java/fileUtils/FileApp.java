package fileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileApp {

    public static String readTestFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\fileUtils\\file.txt"));
        String result;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            result = bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }

        return result;
    }

}
