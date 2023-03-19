package com.kanzaji.eedatagen.jsons.deposits;

import com.kanzaji.eedatagen.jsons.JSONUtilityClasses;

public class GeodeDeposit {
    public String type;
    public String dimension;
    public String[] biomes;
    public String registryName;
    public Config config;

    public static class Config {
        public JSONUtilityClasses.blocks outerShellBlocks;
        public JSONUtilityClasses.blocks innerShellBlocks;
        public JSONUtilityClasses.blocks innerBlocks;
        public JSONUtilityClasses.blocks fillBlocks;
        public String[] fillerTypes;
        public String[] clusters;
        public int chance;
        public int crackChance;
        public int minYLevel;
        public int maxYLevel;
        public String placement;
        public String rarity;
        public boolean generateSample;
        public JSONUtilityClasses.sampleBlocks[] sampleBLocks;
    }
}
