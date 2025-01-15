package javaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadAndWriteFile {
    public static void main(String[] args) {
        copyFileContent("C:\\Users\\ssmex\\IdeaProjects\\maximaLearn\\src\\javaIO\\source.txt",
                "C:\\Users\\ssmex\\IdeaProjects\\maximaLearn\\src\\javaIO\\result.txt");
    }

    public static void copyFileContent(String sourcePath, String targetPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             FileWriter writer = new FileWriter(targetPath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла " + e.getMessage());
        }
    }
}
