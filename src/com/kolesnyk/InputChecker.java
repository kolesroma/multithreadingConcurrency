package com.kolesnyk;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InputChecker {
    public String getValidFolderPath() {
        System.out.print("Dir:>");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String input = sc.nextLine();
                Path path = Path.of(input);
                if (Files.exists(path) && Files.isDirectory(path)) {
                    return input;
                }
                System.err.println("no such dir");
            }
        }
    }
}
