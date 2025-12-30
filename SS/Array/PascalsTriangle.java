// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]

// Constraints:
// 1 <= numRows <= 30

import java.util.*;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(getRows(i));
        }
        return res;
    }

    public static List<Integer> getRows(int rowNo) {
        List<Integer> li = new ArrayList<>();
        int val = 1;
        li.add(val);
        for (int i = 1; i <= rowNo; i++) {
            val = val * (rowNo - i + 1);
            val = val / i;
            li.add(val);
        }
        return li;
    }

    public static void printPascalsTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {

        int[] testCases = { 1, 2, 5, 7 };

        for (int numRows : testCases) {
            System.out.println("Pascal Triangle for numRows = " + numRows);
            List<List<Integer>> triangle = generate(numRows);
            printPascalsTriangle(triangle);
            System.out.println();
        }
    }

}
