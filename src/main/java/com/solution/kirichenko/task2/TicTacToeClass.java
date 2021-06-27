package com.solution.kirichenko.task2;
/**
 * The {@code TicTacToeClass} class
 * Class which determines the winner in the XO (Tic Tac Toe) game.
 * As an input this function should receive the game board
 * (two dimensional array aka matrix).
 * As an output it should return the winner ‘X’ or ‘‘O’ (return ‘’ if no winner).
 *
 * @author Juliia Kirichenko
 * @since 23.06.2021
 * @version 1.0
 */
public class TicTacToeClass {
    private final static String OSYMB = "'O'";
    private final static String XSYMB = "'X'";
    private final static String ESYMB = "' '";

    /**
     * Method used for calculate Tic Tac Toe winner
     * @param board - initial board
     * @return winner ('X' or 'O') or (' ') if we have not winner
     */
    public static String calcTTTwinner(String[][] board) {
        int count = 0; // cell counter
        String winner = ESYMB; // current winner ' '

        for (int r = 0; r < board.length; r++) {
            String rowWinner = seqWinner(getRow(r, board));
            if (rowWinner.contentEquals(OSYMB) || rowWinner.contentEquals(XSYMB)) {
                winner = rowWinner;
                count++;
            }
        }

        for (int c = 0; c < board[0].length; c++) {
            String colWinner = seqWinner(getColumn(c, board));
            if (colWinner.contentEquals(XSYMB) || colWinner.contentEquals(OSYMB)) {
                winner = colWinner;
                count++;
            }
        }

        String mainDiagWinner = seqWinner(getMainDiag(board));
        if (mainDiagWinner.contentEquals(XSYMB) || mainDiagWinner.contentEquals(OSYMB)) {
            winner = mainDiagWinner;
            count++;
        }

        String advDiagWinner = seqWinner(getAdvDiag(board));
        if (advDiagWinner.contentEquals(XSYMB) || advDiagWinner.contentEquals(OSYMB)) {
            winner = advDiagWinner;
            count++;
        }

        if ((winner.contentEquals(XSYMB) || winner.contentEquals(OSYMB)) && count == 1) {
            return winner;
        }

        return ESYMB;
    }

    /**
     * The method used for transform array board to string
     * @param board - array symbols in board
     * @return string board
     */
    public static String boardToString(String[][] board) {
        StringBuilder output = new StringBuilder();
        for (String[] strings : board) {
            for (String string : strings) {
                output.append(String.format("%1s", string));
            }
            output.append("\n");
        }
        return output.toString();
    }

    /**
     * The method used for find winner row on board
     * @param i - current cell board in row
     * @param board - string array cell board in row
     * @return row of board
     */
    public static String[] getRow(int i, String[][] board) {
        return board[i];
    }

    /**
     * The method used for find winner column on board
     * @param i - current cell board in column
     * @param board - string array cell board in column
     * @return column of board
     */
    public static String[] getColumn(int i, String[][] board) {
        String[] column = new String[board.length];
        for (int r = 0; r < board.length; r++) {
            column[r] = board[r][i];
        }
        return column;
    }

    /**
     * The method used for find winner main diagonal on board
     * @param board - string array cell board in diagonal
     * @return diagonal of board
     */
    public static String[] getMainDiag(String[][] board) {
        String[] diag = new String[Math.min(board.length, board[0].length)];
        for (int i = 0; i < diag.length; i++) {
            diag[i] = board[i][i];
        }
        return diag;
    }

    /**
     * The method used for find winner advanced diagonal on board
     * @param board - string array cell board in diagonal
     * @return diagonal of board
     */
    public static String[] getAdvDiag(String[][] board) {
        String[] diag = new String[Math.min(board.length, board[0].length)];
        for (int i = 0; i < diag.length; i++) {
            diag[i] = board[board.length - 1 - i][i];
        }
        return diag;
    }

    /**
     * The method return string winner
     * @param seq - sequence of desired cells
     * @return winner
     */
    public static String seqWinner(String[] seq) {
        String winner = seq[0];
        for (String val : seq) {
            if (!val.equals(winner)) {
                return "";
            }
        }
        return winner;
    }
}
