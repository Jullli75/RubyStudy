package com.solution.kirichenko.task3;

import java.util.List;

/**
 * The {@code Trader} class
 * Trader starts outside of any town with 50 coins.
 * He can visit each town only once.
 * When in town he can buy/sell goods for a given price,
 * carrying no more than one good while traveling
 * between towns.
 * He should get maximum possible profit in the process.
 *
 * @author Juliia Kirichenko
 * @since 26.06.2021
 * @version 1.0
 */
public class Trader {

    /**
     * This method get maximum possible profit in the process.
     * @param initialCoins - initial 50 coins in trader
     * @param map - current town
     * @return max profit
     */
    public static int travelMap(int initialCoins, TownsMap map) {

        StringBuilder logger = new StringBuilder();

        int max = 0; // max profit
        int run = 1; // number of runs

        for (Route route : map.getRoutes()) {
            logger.setLength(0);
            int profit = travelRoute(initialCoins, route, map.getTowns(), logger);
            if (profit >= 0) {
                System.out.println("Run " + run);
                System.out.println("Initial coins: " + initialCoins);
                System.out.println(logger);
                System.out.println("Final coins: " + profit);
                System.out.println();
                run++;
                if (profit > max)
                    max = profit;
            }
        }
        return max;
    }

    /**
     * This method determine travel route trader
     * @param initialCoins - initial 50 coins in trader
     * @param route - route of trader
     * @param towns - list of towns
     * @param logger - string for keep sell, buy and left coins
     * @return number of coins
     */
    public static int travelRoute(int initialCoins, Route route, List<Town> towns, StringBuilder logger) {
        int coins = initialCoins; //initial 50 coins in trader
        Good good = null; //trader hasn't good yet

        for (Checkpoint checkpoint : route.getCheckpoints()) {
            List<Good> pricelist = checkpoint.getTown().getPricelist();
            if (good != null) {
                int price = pricelist.get(pricelist.indexOf(good)).getPrice();
                coins += price;
                logger.append(
                        String.format("Sell %s for %d coins in %s.", good.getName(), price, checkpoint.getTown()));
                if (!checkpoint.isLast())
                    logger.append(String.format(" %d coins left\n", coins));
            }
            if (!checkpoint.isLast()) {
                good = checkpoint.getGood();
                int price = pricelist.get(pricelist.indexOf(good)).getPrice();
                coins -= pricelist.get(pricelist.indexOf(good)).getPrice();
                logger.append(String.format("Buy %s for %d coins in %s. %d coins left%n", good.getName(), price,
                        checkpoint.getTown(), coins));
            }
            if (coins < 0)
                return -1;
        }
        return coins;
    }
}