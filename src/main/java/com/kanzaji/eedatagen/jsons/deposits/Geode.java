package com.kanzaji.eedatagen.jsons.deposits;

import com.kanzaji.eedatagen.jsons.JSONUtilityClasses;

public class Geode {
    public static String type;
    public static String dimension;
    public static String[] biomes;
    public static String registryName;
    public static Config config;

    public static class Config {
        public static JSONUtilityClasses.Blocks outerShellBlocks;
        public static JSONUtilityClasses.Blocks innerShellBlocks;
        public static JSONUtilityClasses.Blocks innerBlocks;
        public static JSONUtilityClasses.Blocks fillBlocks;
        public static String[] fillerTypes;
        public static String[] clusters;
        public static int chance;
        public static int crackChance;
        public static int minYLevel;
        public static int maxYLevel;
        public static String placement;
        public static String rarity;
        public static boolean generateSample;
        public static JSONUtilityClasses.sampleBlocks[] sampleBLocks;
    }
}
