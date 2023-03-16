package com.kanzaji.eedatagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kanzaji.eedatagen.jsons.Data;
import com.kanzaji.eedatagen.utils.Logger;

import java.nio.file.Files;
import java.nio.file.Path;

import static com.kanzaji.eedatagen.utils.FileReader.getFile;
import static com.kanzaji.eedatagen.utils.FileReader.getInternalFile;

public class EEDataGen {
    public static String version = "DEVELOP";
    private static final Logger logger = Logger.getInstance();
    private static final Path DataFile = Path.of("data.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        logger.init();
        logger.log("-----------------------------------------------");
        logger.log("Running EE Data Generator " + version);
        logger.log("-----------------------------------------------");
        try {
            System.out.println("-----------------------------------------------");
            System.out.println("EE Data Generator " + version);
            System.out.println("-----------------------------------------------");

            if (Files.exists(DataFile)) {
                //TODO: Welp, Data.json deserialization etc.
                //TODO: GUI!!!! Dear god
            } else {
                logger.warn("data.json doesn't exists! Generating a template...");
                Files.createFile(DataFile);
                System.out.println("data.json doesn't exists! Template generated.");
                System.exit(2);
            }
        } catch (Exception | Error e) {
            logger.logStackTrace("Something bad happened!", e);
            System.exit(1);
        }
        System.exit(0);
    }
}