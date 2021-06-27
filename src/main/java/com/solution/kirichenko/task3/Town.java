package com.solution.kirichenko.task3;

import java.util.List;

/**
 * The {@code Town} class
 * This class determine name of town and price list goods
 *
 * @author Juliia Kirichenko
 * @since 25.06.2021
 * @version 1.0
 */
public class Town {

    private String name; // name of town
    private List<Good> pricelist; // price list goods

    /**
     * Constructor for class Town
     */
    public Town() {
    }

    /**
     * Constructor for class Town with parameters
     * @param name - name of town
     * @param pricelist - price list goods
     */
    public Town(String name, List<Good> pricelist) {
        this.name = name;
        this.pricelist = pricelist;
    }

    /**
     * Getter
     * @return price list of goods
     */
    public List<Good> getPricelist() {
        return pricelist;
    }

    /**
     * Returns a string representation of the object
     * @return name of town
     */
    @Override
    public String toString() {
        return name;
    }
}