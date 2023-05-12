package y2023.leetcode.dsalgochallenge_level1.Extra;

import java.util.*;

public class Leetcode73_SetMatrixZeroes {

    public static void main(String[] args) {
        Leetcode73_SetMatrixZeroes objj = new Leetcode73_SetMatrixZeroes();
        int matrix[][] = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        objj.setZeroes1(matrix);
    }

    public void setZeroes(int[][] matrix) {

        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowMap.put(i, 1);
                    colMap.put(j, 1);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowMap.containsKey(i)) {
                    matrix[i][j] = 0;
                }
                if (colMap.containsKey(j))
                    matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }

    }

    public void setZeroes1(int[][] matrix) {
        boolean col = false;
        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i][0] == 0) {
                col = true;
            }
            //starting from j=1 because whenever we will update 0th column it will update 0th row also.
            //to avoid that we are startng from j=1 & we kept i=0 since we want row to update 0,0 to 0
            for (int j = 1; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }


        for (int j = 0; j < matrix.length; j++) {
            if (col) {
                matrix[j][0] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }

    }

}
