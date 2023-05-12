package y2023.leetcode.dsalgochallenge.Day5;

import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
        System.out.println(8 >> 1);
        System.out.println(8 << 1);
        char[][] arr = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(obj.isValidSudoku4(arr));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!validBox(board, i, j)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
        }
        return true;
    }

    boolean validBox(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }

    // r/3 * 3 +c/3 because we want to have 3 4 5 after 0 1 2 which is possible if we have multiplier of 3 with row and add with column.
    public boolean isValidSudoku1(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }


    public boolean isValidSudoku2(char[][] board) {
        int row[][] = new int[9][9];
        int col[][] = new int[9][9];
        int box[][] = new int[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int pos = board[i][j] - '1';
                if (row[i][pos] == 1) {
                    return false;
                }
                row[i][pos] = 1;
                if (col[j][pos] == 1) {
                    return false;
                }
                col[j][pos] = 1;
                int index = (i / 3) * 3 + j / 3;
                if (box[index][pos] == 1) {
                    return false;
                }
                box[index][pos] = 1;
            }
        }
        return true;
    }

    public boolean isValidSudoku4(char[][] board) {
        int N = 9;

        // Use a binary number to record previous occurrence
        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] boxes = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = board[i][j] - '0';
                int pos = 1 >> (value - 1);
                if ((rows[i] & pos) > 0) {
                    return false;
                }
                rows[i] |= pos;
                if ((cols[j] & pos) > 0) {
                    return false;
                }
                cols[j] |= pos;
                int index = (i / 3) * 3 + j / 3;
                if ((boxes[index] & pos) > 0) {
                    return false;
                }
                boxes[index] |= pos;
            }
        }
        return true;
    }


}
