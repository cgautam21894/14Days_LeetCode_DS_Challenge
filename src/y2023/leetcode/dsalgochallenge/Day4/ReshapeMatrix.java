package y2023.leetcode.dsalgochallenge.Day4;

public class ReshapeMatrix {
    public static void main(String[] args) {
        int arr[][] = {{1, 2}, {3, 4}};
        ReshapeMatrix obj = new ReshapeMatrix();
        obj.matrixReshape2(arr, 4, 1);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rowNum = mat.length;
        int colNum = mat[0].length;
        //00 01 02 04
        int ans[][] = new int[r][c];
        int temp[] = new int[rowNum * colNum];
        int k = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                temp[k] = mat[i][j];
                k++;
            }
        }
        k = 0;
        if (r * c == rowNum * colNum) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ans[i][j] = temp[k];
                    k++;
                }
            }
        }
        return mat;
    }

    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        int rowNum = mat.length;
        int colNum = mat[0].length;

        int ans[][] = new int[r][c];
        int k = 0;

        int row = 0, col = 0;
        if (r * c == rowNum * colNum) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    ans[row][col] = mat[i][j];
                    col++;
                    if (col == c) {
                        col = 0;
                        row++;
                    }
                }
            }
            return ans;
        }
        return mat;
    }

    //division and modulus
    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int rowNum = mat.length;
        int colNum = mat[0].length;

        int ans[][] = new int[r][c];
        int k = 0;

        int count = 0;
        if (r * c == rowNum * colNum) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    System.out.println("count / c :" + count / c + "count % c :" + count % c);
                    ans[count / c][count % c] = mat[i][j];
                    count++;
                }
            }
        }
        return ans;
    }

}
