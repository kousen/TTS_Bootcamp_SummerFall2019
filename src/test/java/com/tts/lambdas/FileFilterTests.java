package com.tts.lambdas;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

@SuppressWarnings("ConstantConditions")
public class FileFilterTests {
    private String dir = "src/test/java/com/tts";

    @Test
    public void listAllFiles() {
        File root = new File(dir);
        for (File f : root.listFiles()) {
            System.out.println(f);
        }
    }

    @Test
    public void listOnlyJavaFilesUsingAnonInnerClass() {
        File root = new File(dir);
        for (File f : root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        })) {
            System.out.println(f);
        }
    }

    @Test
    public void listDirectoriesUsingLamda() {
        File root = new File(dir);
        for (File f : root.listFiles(pathname -> pathname.isDirectory())) {
            System.out.println(f);
        }
    }

    @Test
    public void listDirectoriesUsingMethodRef() {
        File root = new File(dir);
        for (File f : root.listFiles(File::isDirectory)) {
            System.out.println(f);
        }
    }
}
