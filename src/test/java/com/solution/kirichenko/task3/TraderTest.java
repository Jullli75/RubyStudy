package com.solution.kirichenko.task3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The {@code TraderTest} class
 * Trader starts outside of any town with 50 coins.
 * He can visit each town only once.
 * When in town he can buy/sell goods for a given price,
 * carrying no more than one good while traveling
 * between towns.
 * Trader should get maximum possible profit in the process.
 *
 * @author Juliia Kirichenko
 * @since 27.06.2021
 * @version 1.0
 */
public class TraderTest {
    Trader trader = new Trader();
    @Test
    public void travelMap() {
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

        assertEquals(147, trader.travelMap(50, twnsMap));
    }

}