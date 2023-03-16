package com.kanzaji.eedatagen.jsons;

import com.sun.jdi.event.StepEvent;

public class Material {
    public static String id;
    public static String source;
    public static String localizedName;
    public static String[] processedTypes;
    public static boolean disableDefaultOre;
    public static properties properties;
    public static oreDrop oreDrop;
    public static tools tools;
    public static armor armor;
    public static colors colors;
    public static gas gas;
    public static compat compat;

    public static class properties {
        public static String materialType;
        public static int harvestLevel;
        public static boolean hasParticles;
        public static boolean hasOxidation;
        public static boolean isEmissive;
        public static boolean isBurnable;
        public static int burnTime;
        public static int blockRecipeType;
        public static int gemTexture;
    }
    public static class oreDrop {
        public static String drop;
        public static int min;
        public static int max;
    }
    public static class tools {
        public static float attackDamage;
        public static int level;
        public static int enchantability;
        public static float efficiency;
        public static tool TOOL;
        public static class tool {
            public static toolStats sword;
            public static toolStats pickaxe;
            public static toolStats axe;
            public static toolStats shovel;
            public static toolStats hoe;
            public static toolStats paxel;
            public static class toolStats {
                public static float damage;
                public static float speed;
                public static int durability;
            }
        }
    }
    public static class armor {
        public static boolean setArmor;
        public static effect[] effects;
        public static String setName;
        public static String setDesc;
        public static float toughness;
        public static int enchantability;
        public static float knockback;
        public static armorPieces armor;
        public static class armorPieces {
            public static armorStat helmet;
            public static armorStat chestplate;
            public static armorStat leggings;
            public static armorStat boots;
            public static armorStat shield;
            public static class armorStat {
                public static int durability;
                public static int protection;
            }
        }
        public static class effect {
            public static String effect;
            public static int level;
            public static boolean showParticles;
            public static boolean showIcon;
        }
    }
    public static class colors {
        public static String fluidColor;
        public static String particlesColor;
        public static String oxidationColor;
        public static String materialColor;
        public static String gasColor;
    }
    public static class gas {
        public static boolean isBurnable;
        public static int burnTime;
        public static long energyDensity;
        public static boolean isRadioactive;
        public static double radioactivity;
        public static boolean isCoolant;
        public static String coolantType;
        public static double thermalEnthalpy;
        public static double conductivity;
    }
    public static class compat {
        public static boolean mekanism;
        public static boolean thermal;
        public static boolean create;
        public static boolean ars_nouveau;
        public static boolean occultism;
    }
}