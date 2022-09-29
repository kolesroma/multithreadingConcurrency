package com.kolesnyk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataFinder {
    public List<String> findNotesInFile(String pathToFile) {
        try {
            return Files.readAllLines(Paths.get(pathToFile)).stream()
                    .flatMap(line -> Arrays.stream(line.split(" "))) // [\P{L}\p{N}]+
                    .filter(w -> w.matches("[+КС](.*)"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
