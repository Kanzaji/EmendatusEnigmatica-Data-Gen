package com.kanzaji.eedatagen.jsons;

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
        public static class effect {
            public static String effect;
            public static int level;
            public static boolean showParticles;
            public static boolean showIcon;
        }
    }
    public static class colors {

    }
    public static class gas {

    }
    public static class compat {

    }
}