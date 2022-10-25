package com.kolesnyk;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        InputChecker inputChecker = new InputChecker();
        String folderPath = inputChecker.getValidFolderPath();
        FileService fileService = new FileService(new DataFinder(),
                new DataLoader(),
                Executors.newCachedThreadPool());
        fileService.iterateRecursive(folderPath);
    }
}
