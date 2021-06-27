package com.solution.kirichenko.task3;

/**
 * The {@code Good} class
 * This class determine name of goods and price list goods
 *
 * @author Juliia Kirichenko
 * @since 25.06.2021
 * @version 1.0
 */
public class Good {

    private String name; // name of good
    private int price; // price of good

    /**
     * Constructor for class Good
     */
    public Good() {
    }

    /**
     * Constructor for class Good with parameters
     * @param name - name of good
     * @param price - price of good
     */
    public Good(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    /**
     * Getter
     * @return get name of good
     */
    public String getName() {
        return name;
    }

    /**
     * Getter
     * @return price of good
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method return string final coins
     * @return final coins
     */
    @Override
    public String toString() {
        return name + ":" + price;
    }

    /**
     * Returns the hash code of a non-null argument and 0 for a null argument.
     * @return result
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * Returns true if the arguments are equal to each other and false otherwise.
     * Consequently, if both arguments are null, true is returned and
     * if exactly one argument is null, false is returned. Otherwise,
     * equality is determined by using the equals method of the first argument.
     * @param obj - an object
     * @return true if the arguments are equal to each other and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Good)) {
            return false;
        }

        Good other = (Good) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }
}