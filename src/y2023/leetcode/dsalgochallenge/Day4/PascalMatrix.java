package y2023.leetcode.dsalgochallenge.Day4;

import java.util.*;

public class PascalMatrix {
    public static void main(String[] args) {
        PascalMatrix obj = new PascalMatrix();
        obj.generate(5);
    }

    List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mainList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int prev = 1;
            int count = 0;
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    subList.add(prev);
                } else {
                    List<Integer> li = mainList.get(i - 1);
                    int sum = li.get(count) + li.get(count + 1);
                    subList.add(sum);
                    count++;
                }

            }
            mainList.add(subList);
        }
        return mainList;
    }
}

/*
0   1
1   1  1
2   1   2   1
3   1   3   3   1
4   1   4   6    4   1


 */
