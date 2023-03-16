package com.kanzaji.eedatagen.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.MissingResourceException;
import java.util.Objects;

public class FileReader {
    public static InputStream getInternalFile(String url) throws IOException {
        InputStream file = Thread.currentThread().getContextClassLoader().getResourceAsStream(url);
        if (file == null) {
            throw new MissingResourceException("One of the integral assets is missing!\nThis may signal corrupted app. Please consider reinstalling the program.\nMissing asset: " + url + "\nError StackTrace:", url, url);
        }
        file.close();
        return file;
    }
    public static InputStream getFile(Path path) throws IOException {
        return getFile(null, path);
    }
    public static InputStream getFile(String url) throws IOException {
        return getFile(url, null);
    }
    public static InputStream getFile(String url, Path path) throws IOException {
        Path FilePath = Objects.requireNonNullElseGet(path, () -> Path.of(url));

        if (Files.exists(FilePath)) {
            throw new FileNotFoundException("File requested not found! Path: " + FilePath);
        }

        InputStream file;
        file = Files.newInputStream(FilePath);
        file.close();

        return file;
    }
}
