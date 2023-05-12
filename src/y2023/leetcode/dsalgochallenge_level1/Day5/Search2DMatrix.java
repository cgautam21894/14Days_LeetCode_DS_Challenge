package y2023.leetcode.dsalgochallenge_level1.Day5;

public class Search2DMatrix {
    static int arr[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

    public static void main(String[] args) {
        Search2DMatrix obj = new Search2DMatrix();
        obj.searchMatrix(arr, 30);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        int pivotIndex, pivotElement;
        while (left <= right) {
            pivotIndex = (left + right) / 2;
            pivotElement = matrix[pivotIndex / col][pivotIndex % col];

            if (target == pivotElement) {
                return true;
            } else {
                if (target > pivotElement) {
                    left = pivotIndex + 1;
                } else {
                    right = pivotIndex - 1;
                }
            }
        }
        return true;
    }
}
