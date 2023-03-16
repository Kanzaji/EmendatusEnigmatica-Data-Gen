package com.kanzaji.eedatagen.jsons.deposits;

import com.kanzaji.eedatagen.jsons.JSONUtilityClasses;

public class Sphere {
    public static String type;
    public static String dimension;
    public static String[] biomes;
    public static String registryName;
    public static Config config;

    public static class Config {
        public static JSONUtilityClasses.Blocks[] blocks;
        public static String[] fillerTypes;
        public static int chance;
        public static int radius;
        public static int minYLevel;
        public static int maxYLevel;
        public static String placement;
        public static String rarity;
        public static boolean generateSample;
        public static JSONUtilityClasses.sampleBlocks[] sampleBLocks;
    }
}
