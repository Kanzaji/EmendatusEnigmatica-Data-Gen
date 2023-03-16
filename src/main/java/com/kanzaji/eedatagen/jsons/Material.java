package com.kanzaji.eedatagen.jsons;

import com.sun.jdi.event.StepEvent;

public class Material {
    public String id;
    public String source;
    public String localizedName;
    public String[] processedTypes;
    public boolean disableDefaultOre;
    public properties properties;
    public oreDrop oreDrop;
    public tools tools;
    public armor armor;
    public colors colors;
    public gas gas;
    public compat compat;

    public static class properties {
        public String materialType;
        public int harvestLevel;
        public boolean hasParticles;
        public boolean hasOxidation;
        public boolean isEmissive;
        public boolean isBurnable;
        public int burnTime;
        public int blockRecipeType;
        public int gemTexture;
    }
    public static class oreDrop {
        public String drop;
        public int min;
        public int max;
    }
    public static class tools {
        public float attackDamage;
        public int level;
        public int enchantability;
        public float efficiency;
        public tool TOOL;
        public static class tool {
            public toolStats sword;
            public toolStats pickaxe;
            public toolStats axe;
            public toolStats shovel;
            public toolStats hoe;
            public toolStats paxel;
            public static class toolStats {
                public float damage;
                public float speed;
                public int durability;
            }
        }
    }
    public static class armor {
        public boolean setArmor;
        public effect[] effects;
        public String setName;
        public String setDesc;
        public float toughness;
        public int enchantability;
        public float knockback;
        public armorPieces armor;
        public static class armorPieces {
            public armorStat helmet;
            public armorStat chestplate;
            public armorStat leggings;
            public armorStat boots;
            public armorStat shield;
            public static class armorStat {
                public int durability;
                public int protection;
            }
        }
        public static class effect {
            public String effect;
            public int level;
            public boolean showParticles;
            public boolean showIcon;
        }
    }
    public static class colors {
        public String fluidColor;
        public String particlesColor;
        public String oxidationColor;
        public String materialColor;
        public String gasColor;
    }
    public static class gas {
        public boolean isBurnable;
        public int burnTime;
        public long energyDensity;
        public boolean isRadioactive;
        public double radioactivity;
        public boolean isCoolant;
        public String coolantType;
        public double thermalEnthalpy;
        public double conductivity;
    }
    public static class compat {
        public boolean mekanism;
        public boolean thermal;
        public boolean create;
        public boolean ars_nouveau;
        public boolean occultism;
    }
}