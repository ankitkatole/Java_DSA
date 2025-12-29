import java.util.*;

public class Main {

    public static int linearSearch(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int stringSearch(String str,char target){
        if(str == null){
            return -1;
        }
        for(int i = 0; i<str.length();i++){
            if(str.charAt(i) == target){
                return i;
            }
        }
        return -1;
    }

    public static int searchInRange(int[] arr, int target, int start, int end) {
        if (arr == null || start < 0 || end >= arr.length || start > end) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("Array is null");
            return;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }   

    public static int[] searchIn2DArray(int[][] matrix, int target) {
        if (matrix == null) {
            return new int[] { -1, -1 };
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
    public static void main(String[] args) {

        System.out.println("Linear Search Examples:");
        int[] arr = { 3, 5, 7, 9, 11, 13, 15 };
        int target = 16;
        int ans = linearSearch(arr, target);
        if (ans == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + ans);
        }

        System.out.println("\nString Search Examples:");
        String str = "Hello, welcome to the world of Java!";
        char charTarget = 'w';
        int strAns = stringSearch(str, charTarget);
        if (strAns == -1) {
            System.out.println("Character not found");
        } else {
            System.out.println("Character found at index: " + strAns);
        }

        System.out.println("\nSearch in Range Examples:");
        int rangeTarget = 11;
        int start = 2;
        int end = 5;
        int rangeAns = searchInRange(arr, rangeTarget, start, end);
        if (rangeAns == -1) {
            System.out.println("Element not found in the specified range");
        } else {
            System.out.println("Element found at index: " + rangeAns);
        }

        System.out.println("\nPrint Array Examples:");
        printArray(arr);   

        System.out.println("\nSearch in 2D Array Examples:");
        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int matrixTarget = 5;
        int[] matrixAns = searchIn2DArray(matrix, matrixTarget);
        if (matrixAns[0] == -1) {
            System.out.println("Element not found in the 2D array");
        } else {
            System.out.println("Element found at position: (" + matrixAns[0] + ", " + matrixAns[1] + ")");
        }
        System.out.println((int)Math.log10(2345)+1);//To find no of digits in a number

    }
}