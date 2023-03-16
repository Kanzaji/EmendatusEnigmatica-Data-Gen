package com.kanzaji.eedatagen.jsons.deposits;

public class Vanilla {
    public static String type;
    public static String dimension;
    public static String[] biomes;
    public static String registryName;
    public static Config config;

    public static class Config {
        // Material/Block for the deposit, ONE ONLY
        public static String material;
        public static String block;
        public static String[] fillerTypes;
        public static int chance;
        public static int size;
        public static int minYLevel;
        public static int maxYLevel;
        public static String placement;
        public static String rarity;
    }
}
