package com.kanzaji.eedatagen.jsons.deposits;

import com.kanzaji.eedatagen.jsons.JSONUtilityClasses;

public class Dense {
    public static String type;
    public static String dimension;
    public static String[] biomes;
    public static String registryName;
    public static Config config;

    public static class Config {
        public static JSONUtilityClasses.blocks[] blocks;
        public static String[] fillerTypes;
        public static int chance;
        public static int size;
        public static int minYLevel;
        public static int maxYLevel;
        public static String placement;
        public static String rarity;
        public static boolean generateSample;
        public static JSONUtilityClasses.sampleBlocks[] sampleBLocks;
    }
}
