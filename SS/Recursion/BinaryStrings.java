import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryStrings {

/*
Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.



A binary string is a string consisting only of characters '0' and '1'.


Example 1

Input: n = 3

Output: ["000", "001", "010", "100", "101"]

Explanation: All strings are of length 3 and do not contain consecutive 1s.

Example 2

Input: n = 2

Output: ["00", "01", "10"]

Constraints

1 <= n <= 20 */

    public static void generate(List<String> li, int idx, int n, StringBuilder sb) {

        if(idx == n){
            li.add(sb.toString());
            return ;
        }

        if(sb.length() == 0){

            sb.append("0");
            generate(li, idx + 1, n, sb);

            sb.deleteCharAt(idx);

            sb.append("1");
            generate(li, idx + 1, n, sb);
            sb.deleteCharAt(idx);

        } else {

            if(sb.charAt(idx - 1) == '0'){

                sb.append("0");
                generate(li, idx + 1, n, sb);

                sb.deleteCharAt(idx);

                sb.append("1");
                generate(li, idx + 1, n, sb);
                sb.deleteCharAt(idx);

            } else {

                sb.append("0");
                generate(li, idx + 1, n, sb);
                sb.deleteCharAt(idx);
            }
        }
    }

    public static List<String> generateBinaryStrings(int n) {
        List<String> li = new ArrayList<>();
        generate(li, 0, n, new StringBuilder());
        return li;
    }

    public static void main(String[] args) {

    // Test Case 1
    int n = 1;

    List<String> expected = Arrays.asList("0", "1");
    List<String> actual = generateBinaryStrings(n);

    System.out.println("Test Case n = " + n);
    System.out.println("Expected: " + expected);
    System.out.println("Actual:   " + actual);
    System.out.println(expected.equals(actual) ? "PASS" : "FAIL");
    System.out.println();


    // Test Case 2
    n = 2;

    expected = Arrays.asList("00", "01", "10");
    actual = generateBinaryStrings(n);

    System.out.println("Test Case n = " + n);
    System.out.println("Expected: " + expected);
    System.out.println("Actual:   " + actual);
    System.out.println(expected.equals(actual) ? "PASS" : "FAIL");
    System.out.println();


    // Test Case 3
    n = 3;

    expected = Arrays.asList("000", "001", "010", "100", "101");
    actual = generateBinaryStrings(n);

    System.out.println("Test Case n = " + n);
    System.out.println("Expected: " + expected);
    System.out.println("Actual:   " + actual);
    System.out.println(expected.equals(actual) ? "PASS" : "FAIL");
    System.out.println();


    // Test Case 4
    n = 4;

    expected = Arrays.asList(
        "0000", "0001", "0010", "0100", "0101",
        "1000", "1001", "1010"
    );

    actual = generateBinaryStrings(n);

    System.out.println("Test Case n = " + n);
    System.out.println("Expected: " + expected);
    System.out.println("Actual:   " + actual);
    System.out.println(expected.equals(actual) ? "PASS" : "FAIL");
}
}
