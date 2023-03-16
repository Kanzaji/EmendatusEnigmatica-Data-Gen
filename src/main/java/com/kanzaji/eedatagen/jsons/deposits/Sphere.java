package com.kanzaji.eedatagen.jsons.deposits;

import com.kanzaji.eedatagen.jsons.JSONUtilityClasses;

public class Sphere {
    public String type;
    public String dimension;
    public String[] biomes;
    public String registryName;
    public Config config;

    public static class Config {
        public JSONUtilityClasses.blocks[] blocks;
        public String[] fillerTypes;
        public int chance;
        public int radius;
        public int minYLevel;
        public int maxYLevel;
        public String placement;
        public String rarity;
        public boolean generateSample;
        public JSONUtilityClasses.sampleBlocks[] sampleBLocks;
    }
}
