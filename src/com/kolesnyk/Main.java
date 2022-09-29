package com.kolesnyk;

public class Main {
    public static void main(String[] args) {
        String path = "folder";
        new FileService().iterateRecursive(path);
    }
}
