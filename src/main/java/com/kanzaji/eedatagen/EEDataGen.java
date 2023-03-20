package com.kanzaji.eedatagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.kanzaji.eedatagen.jsons.Data;
import com.kanzaji.eedatagen.jsons.deposits.VanillaDeposit;
import com.kanzaji.eedatagen.utils.FileUtils;
import com.kanzaji.eedatagen.utils.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EEDataGen {
    public static final String version = "DEVELOP";
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
                Path dataFolder = Path.of("data");
                FileUtils.delete(dataFolder);
                Files.createDirectory(dataFolder);
                Data data = gson.fromJson(Files.readString(DataFile), Data.class);
                for (Data.Deposits depo: data.deposits) {
                    if (depo.name != null) {
                        depo.registryName = depo.name;
                    }
                    if (depo.name == null && depo.registryName == null) {
                        depo.registryName = "vanilla_" + depo.material + ((depo.addon == null) ? "" : "_" + depo.addon);
                    }
                    if (depo.config == null) {
                        depo.config = new VanillaDeposit.Config();
                    }
                    if (!Files.exists(Path.of("data/" + depo.material))) {
                        Files.createDirectory(Path.of("data/" + depo.material));
                    }
                    VanillaDeposit out = new VanillaDeposit();
                    out.type = "emendatusenigmatica:vanilla_deposit";
                    out.dimension = "minecraft:overworld";
                    out.biomes = new String[0];
                    out.registryName = depo.registryName;
                    out.config = new VanillaDeposit.Config();
                    out.config.material = depo.material;
                    out.config.chance = depo.chance;
                    out.config.size = (depo.size == 0) ? 10 : depo.size;
                    out.config.minYLevel = depo.min;
                    out.config.maxYLevel = depo.max;
                    out.config.placement = (depo.config.placement == null) ? "uniform" : depo.config.placement;
                    out.config.rarity = (depo.config.rarity == null) ? "common" : depo.config.rarity;
                    out.config.fillerTypes = List.of(
                            "minecraft_deepslate",
                            "minecraft_tuff",
                            "minecraft_stone",
                            "minecraft_andesite",
                            "minecraft_granite",
                            "minecraft_diorite",
                            "create_limestone",
                            "create_ochrum",
                            "create_scoria",
                            "create_crimsite",
                            "create_asurine",
                            "create_veridium",
                            "byg_soapstone",
                            "byg_scoria_stone",
                            "byg_dacite",
                            "quark_jasper",
                            "quark_shale"
                    ).toArray(new String[0]);
                    Path file = Path.of("data/" + depo.material + "/" + depo.registryName + ".json");
                    Files.createFile(file);
                    Files.writeString(file, gson.toJson(out, VanillaDeposit.class));
                }
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