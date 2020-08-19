package net.mshome.twisted.algorithm.chinasoft;

/**
 * # 字游戏
 * N * N 棋盘，横、竖、对角线连上就算赢
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/8/19
 */
public class TicTacToe {

    public static void main(String[] args) {
        // String[] board = new String[]{"XXX","XOX","OOX"};
        // String[] board = new String[]{"OOO","XOX","OOX"};
        String[] board = new String[]{"XOX", "O X", "OXO"};
        System.out.println(ticTacToe(board));
    }

    public static String ticTacToe(String[] board) {
        int length = board.length;
        char[][] arrays = new char[length + 1][length + 1];
        boolean lrDiagonal = true, rlDiagonal = true, hasBlank = false;
        for (int i = 0; i < length; i++) {
            System.arraycopy(board[i].toCharArray(), 0, arrays[i], 0, length);
            for (int j = 0; j < length; j++) {
                if (arrays[i][j] == ' ') {
                    hasBlank = true;
                }
                if (i == j && i != 0 && arrays[i][j] != arrays[i - 1][j - 1]) {
                    lrDiagonal = false;
                }
                if (i + j == length - 1 && j != length - 1 && arrays[i][j] != arrays[i - 1][j + 1]) {
                    rlDiagonal = false;
                }

                if (j != 0 && arrays[i][j] != arrays[i][j - 1]) {
                    arrays[i][length] = '#';
                }
                if (i != 0 && arrays[i][j] != arrays[i - 1][j]) {
                    arrays[length][j] = '#';
                }
                if (j == length - 1 && arrays[i][length] != '#') {
                    return String.valueOf(arrays[i][0]);
                }
                if (i == length - 1 && arrays[length][j] != '#') {
                    return String.valueOf(arrays[0][j]);
                }
            }
        }

        if (lrDiagonal) {
            return String.valueOf(arrays[0][0]);
        }

        if (rlDiagonal) {
            return String.valueOf(arrays[0][length - 1]);
        }
        if (hasBlank) {
            return "Pending";
        }
        return "Draw";

    }


}
