package com.solution.kirichenko.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The {@code Main} class
 * use for testing classes TicTacToeClass
 *
 * @author Juliia Kirichenko
 * @since 23.06.2021
 * @version 1.0
 */
public class Main {
    /** org.apache.logging.log4j.Logger */
    private static final Logger LOG = LogManager.getLogger(com.solution.kirichenko.task1.Main.class);

    private final static String OSYMB = "'O'";
    private final static String XSYMB = "'X'";
    private final static String ESYMB = "' '";

    /**
     * Entry point method
     * @param args - array of command line parameters
     */
    public static void main(String[] args) {
        String[][] board1 = { { XSYMB, ESYMB, ESYMB }, { ESYMB, XSYMB, ESYMB }, { OSYMB, ESYMB, OSYMB } };

        LOG.info("Board:\n"+ TicTacToeClass.boardToString(board1));
        LOG.info("Winner: " + TicTacToeClass.calcTTTwinner(board1));

        String[][] board2 = { { ESYMB, XSYMB, ESYMB }, { XSYMB, XSYMB, ESYMB }, { OSYMB, OSYMB, OSYMB } };
        LOG.info("Board:\n"+ TicTacToeClass.boardToString(board2));
        LOG.info("Winner: " + TicTacToeClass.calcTTTwinner(board2));
    }
}
