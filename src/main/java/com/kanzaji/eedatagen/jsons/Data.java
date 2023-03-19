package com.kanzaji.eedatagen.jsons;

import com.kanzaji.eedatagen.jsons.deposits.VanillaDeposit;

public class Data {
    public Deposits[] deposits;

    public static class Deposits extends VanillaDeposit {
        public String template;
        public String name;
        public int chance;
        public int size;
        public String material;
        public int max;
        public int min;
        public String addon;
    }
}
