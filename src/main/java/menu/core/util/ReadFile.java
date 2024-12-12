package menu.core.util;

import menu.core.constant.FileInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String fileName){
        try{
            List<String> fileInfo = Files.readAllLines(Paths.get(FileInfo.findFilePath(fileName)));
            fileInfo.remove(0);

            return fileInfo;
        }catch (IOException e){
            return null;
        }
    }
}
