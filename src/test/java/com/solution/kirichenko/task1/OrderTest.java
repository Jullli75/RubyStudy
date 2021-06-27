package com.solution.kirichenko.task1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The {@code OrderTest} class
 * This class used to testing calculate the sum of the Order in Online Shop.
 *
 * @author Juliia Kirichenko
 * @since 27.06.2021
 * @version 1.0
 */
public class OrderTest  {

    @Test (expected = RuntimeException.class)
    public void testAddItem() {
        Order order = new Order(new ArrayList<>(),new ArrayList<>());
        order.addItem(50.0, -10.0);
        order.addItem(112.2, 0.0);
        order.calcTotalSumWithDiscounts();

        Order order2 = new Order(new ArrayList<>(),new ArrayList<>());
        order2.addItem(100.0, 110.0);
        order2.calcTotalSumWithDiscounts();
    }

    @Test (expected = RuntimeException.class)
    public void testCalcTotalSumWithDiscounts() {

        Order order = new Order(new ArrayList<>(),new ArrayList<>());
        order.addItem(100.0, 10.0);
        order.addItem(112.2, 0.0);
        order.addItem(301.1, 0.0);
        assertEquals(503.3, order.calcTotalSumWithDiscounts(), 0.0);
    }
}