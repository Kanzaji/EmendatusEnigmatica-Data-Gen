package com.kanzaji.eedatagen.jsons.deposits;

public class VanillaDeposit {
    public String type;
    public String dimension;
    public String[] biomes;
    public String registryName;
    public Config config;

    public static class Config {
        // Material/Block for the deposit, ONE ONLY
        public String material;
        public String block;
        public String[] fillerTypes;
        public int chance;
        public int size;
        public int minYLevel;
        public int maxYLevel;
        public String placement;
        public String rarity;
    }
}
