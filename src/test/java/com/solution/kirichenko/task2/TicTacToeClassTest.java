package com.solution.kirichenko.task2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The {@code TicTacToeClassTest} class
 * Class which testing determines the winner in the XO (Tic Tac Toe) game.
 * As an output it should return the winner ‘X’ or ‘‘O’ (return ‘’ if no winner).
 *
 * @author Juliia Kirichenko
 * @since 27.06.2021
 * @version 1.0
 */
public class TicTacToeClassTest {

TicTacToeClass ticTacToeClass = new TicTacToeClass();
    @Test
    public void calcTTTwinner() {
        String OSYMB = "'O'";
        String XSYMB = "'X'";
        String ESYMB = "' '";
        String[][] board1 = { { XSYMB, OSYMB, ESYMB }, { XSYMB, OSYMB, ESYMB }, { XSYMB, OSYMB, OSYMB } };
        assertEquals("' '", ticTacToeClass.calcTTTwinner(board1));

        String[][] board2 = { { XSYMB, OSYMB, OSYMB }, { XSYMB, ESYMB, ESYMB }, { XSYMB, ESYMB, OSYMB } };
        assertEquals("'X'", ticTacToeClass.calcTTTwinner(board2));

    }
}