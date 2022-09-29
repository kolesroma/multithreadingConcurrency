package com.kolesnyk;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileService {
    private final DataFinder finder = new DataFinder();
    private final DataLoader loader = new DataLoader();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void findNotesAndSaveToFile(String pathToFile) {
        List<String> notes = finder.findNotesInFile(pathToFile);

        System.out.println("notes>" + notes);

        if (!notes.isEmpty()) {
            loader.saveNotes(pathToFile, notes);
        }
    }

    public void iterateRecursive(String folderPath) {
        File fileFolder = new File(folderPath);
        for (File file : fileFolder.listFiles()) {
            if (file.isDirectory()) {
                executor.submit(() -> iterateRecursive(file.getPath()));
            } else {
                findNotesAndSaveToFile(file.getPath());
            }
        }
        executor.shutdown();
    }
}
