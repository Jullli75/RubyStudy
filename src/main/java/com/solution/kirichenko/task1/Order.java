package com.solution.kirichenko.task1;

import java.util.List;
/**
 * The {@code Order} class
 * This class used to calculate the sum of the Order in Online Shop.
 * The Order consists of: the list of Order Items and the list of Discounts.
 * Order Items is an array of items prices.
 * Discounts is an array of discounts for each Order Item in percent.
 *
 * @author Juliia Kirichenko
 * @since 22.06.2021
 * @version 1.0
 */
public class Order {
    private List<Double> prices; // list of prices
    private List<Double> discounts; // list of discounts

    /**
     * Constructor for class Order
     */
    public Order() {
    }

    /**
     * Constructor for class Order with parameters
     * @param prices - initial prices
     * @param discounts - initial discounts
     */
    public Order(List<Double> prices, List<Double> discounts) {
        if (prices == null) {
            throw new RuntimeException("Prices must not be null");
        }

        if (discounts == null) {
            throw new RuntimeException("Discounts must not be null");
        }

        if (prices.size() != discounts.size()) {
            throw new RuntimeException("Prices and discounts must be the same size");
        }

        this.prices = prices;
        this.discounts = discounts;
    }

    /**
     * The method used for add price and discount int list
     * @param price - initial price
     * @param discount - initial discount
     */
    public void addItem(double price, double discount) {
        prices.add(price);
        discounts.add(discount);

        if (discount > 100.0 || discount < 0.0) {
            throw new RuntimeException("Discounts must not in range [0...99.9]");
        }
    }

    /**
     * The method used for calculate total sum of money with discounts
     * @return sum - amount of money
     */
    public double calcTotalSumWithDiscounts() {
        double sum = 0.0;
        for (int i = 0; i < getSize(); i++)
            sum += getPrice(i) * getDiscountMultiplier(i);
        return sum;
    }

    /**
     * Getter
     * @param i - get price
     * @return price
     */
    public double getPrice(int i) {
        return prices.get(i);
    }

    /**
     * Getter
     * @param i - get discount
     * @return discount
     */
    public double getDiscount(int i) {
        return discounts.get(i);
    }

    /**
     * The method used for get discount multiplier
     * @param i - current discount
     * @return discount multiplier
     */
    public double getDiscountMultiplier(int i) {
        return 1 - discounts.get(i) / 100;
    }

    /**
     * The method used for get size of list
     * @return min (prices or discounts)
     */
    public int getSize() {
        return Math.min(prices.size(), discounts.size());
    }

    /**
     * The method used for get string prices and discounts
     * @return string prices and discounts
     */
    @Override
    public String toString() {
        return "price\t" + prices + "\ndisc\t" + discounts;
    }
}
