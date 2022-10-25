package com.kolesnyk;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InputChecker {
    private final FileService fileService = new FileService();

    public void check() {
        System.out.print("Dir:>");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String path = sc.nextLine();
            if (!Files.exists(Path.of(path))) {
                System.err.println("wrong input");
                continue;
            }
            fileService.iterateRecursive(path);
            sc.close();
            break;
        }
    }
}
