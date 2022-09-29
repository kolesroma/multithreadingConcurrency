package com.kolesnyk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataLoader {
    private final String pathPrefix = "output/prod/";

    public void saveNotes(String pathToFile, List<String> notes) {
        Path path = Paths.get(pathPrefix + pathToFile);
        try {
            Files.createDirectories(path.getParent());
            Files.write(path, notes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
