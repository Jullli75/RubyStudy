package com.solution.kirichenko.task1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
/**
 * The {@code Main} class
 * use for testing classes Order
 *
 * @author Juliia Kirichenko
 * @since 22.06.2021
 * @version 1.0
 */
public class Main {
	/** org.apache.logging.log4j.Logger */
	private static final Logger LOG = LogManager.getLogger(Main.class);

	/**
	 * Entry point method
	 * @param args - array of command line parameters
	 */
	public static void main(String[] args) {
		Order order = new Order(new ArrayList<>(),new ArrayList<>());
		order.addItem(100.0, 10.0);
		order.addItem(112.2, 0.0);
		order.addItem(301.1, 0.0);

		LOG.info(order);
		LOG.info(order.calcTotalSumWithDiscounts());
	}
}
