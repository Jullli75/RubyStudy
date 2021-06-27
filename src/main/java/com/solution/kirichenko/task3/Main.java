package com.solution.kirichenko.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The {@code Main} class
 * A program that’ll execute merchants traveling and trading,
 * printing final and intermediate merchants
 * coins after visiting all 3 cities.
 * This class used for testing all methods
 *
 * @author Juliia Kirichenko
 * @since 25.06.2021
 * @version 1.0
 */
public class Main {
    /** org.apache.logging.log4j.Logger */
    private static final Logger LOG = LogManager.getLogger(com.solution.kirichenko.task1.Main.class);

    /**
     * Entry point method
     * @param args - array of command line parameters
     */
    public static void main(String[] args) {
        // --------------------------------------
        List<Good> pricelist1 = new ArrayList<>();
        pricelist1.add(new Good("salt", 20));
        pricelist1.add(new Good("fish", 50));
        pricelist1.add(new Good("cloth", 60));
        pricelist1.add(new Good("copper", 36));
        pricelist1.add(new Good("furs", 96));
        Town town1 = new Town("Lubeck", pricelist1);
        // --------------------------------------
        List<Good> pricelist2 = new ArrayList<>();
        pricelist2.add(new Good("salt", 35));
        pricelist2.add(new Good("fish", 50));
        pricelist2.add(new Good("cloth", 40));
        pricelist2.add(new Good("copper", 60));
        pricelist2.add(new Good("furs", 45));
        Town town2 = new Town("Reval", pricelist2);
        // --------------------------------------
        List<Good> pricelist3 = new ArrayList<>();
        pricelist3.add(new Good("salt", 62));
        pricelist3.add(new Good("fish", 15));
        pricelist3.add(new Good("cloth", 18));
        pricelist3.add(new Good("copper", 82));
        pricelist3.add(new Good("furs", 54));
        Town town3 = new Town("Bergen", pricelist3);
        // --------------------------------------
        TownsMap twnsMap = new TownsMap(Arrays.asList(town1, town2, town3));
        twnsMap.build();

        LOG.info("Max result: " + Trader.travelMap(50, twnsMap) + " coins");
    }
}