package com.kanzaji.eedatagen.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Time;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FileUtils {
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

        //TODO: This requires testing because I literally have no idea if this works
        InputStream file;
        file = Files.newInputStream(FilePath);
        file.close();

        return file;
    }
    public static boolean delete(Path FilePath) throws IOException, InterruptedException {
        return delete(FilePath, false);
    }
    public static boolean delete(Path FilePath, boolean IgnoreExecutorOutput) throws IOException, InterruptedException {
        if (!Files.exists(FilePath)) {
            throw new FileNotFoundException("File requested to delete not exists!" + FilePath);
        }
        if(!Files.isDirectory(FilePath)) {
            Files.delete(FilePath);
            return true;
        }
        ExecutorService executor = Executors.newFixedThreadPool(8);
        try (Stream<Path> pathStream = Files.list(FilePath)) {
            pathStream.forEach(File -> executor.submit(() -> {
                try {
                    if (!Files.isDirectory(File)) {
                        Files.delete(File);
                    } else {
                        if (!delete(File)) {
                            throw new IllegalStateException("Failed to delete " + File + " directory!");
                        };
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Exception caught while trying to delete directory " + FilePath + " at file " + File, e);
                }
            }));
        }
        if (IgnoreExecutorOutput) {
            Logger.getInstance().warn("Executor output ignored! Directory designated to removal " + FilePath + " might not get deleted properly.");
        } else {
            if (!executor.awaitTermination(1, TimeUnit.DAYS)) {
                throw new RuntimeException("Removal of " + FilePath + " takes over a day!");
            }
        }
        return true;
    }
}
