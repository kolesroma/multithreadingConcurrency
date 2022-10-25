package com.kolesnyk;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class FileService {
    private final DataFinder finder;
    private final DataLoader loader;
    private final ExecutorService executor;

    public FileService(DataFinder finder, DataLoader loader, ExecutorService executor) {
        this.finder = finder;
        this.loader = loader;
        this.executor = executor;
    }

    public void findNotesAndSaveToFile(String pathToFile) {
        List<String> notes = finder.findNotesInFile(pathToFile);

        System.out.println(pathToFile + " notes> " + notes);

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
        try {
            TimeUnit.SECONDS.sleep(5);
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
