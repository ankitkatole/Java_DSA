public class Pattern {

    public static void hollowRectangle(int row, int col) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 || i == row || j == 1 || j == col) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void invertedHalfPyramid(int n) {
        int empty = n - 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= empty) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            empty--;
            System.out.println();
        }
    }

    public static void invertedNumber(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void floydsTriangle(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num + "  ");
                num++;
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle(int n) {
        int flag;
        for (int i = 1; i <= n; i++) {
            flag = i % 2;
            for (int j = 1; j <= i; j++) {
                System.out.print(flag + " ");
                if (flag == 0) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle2(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void butterflyPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= (2 * (n - i)); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= (2 * (n - i)); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void solidRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            for (int space = n - i; space > 0; space--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hollowRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            for (int space = n - i; space > 0; space--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= n; j++) {
                if(i == 1 || i == n || j == 1 || j == n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    public static void diamondPattern(int n){
        int star = 1;
        for(int i = 1; i<= n;i++){
            for(int spaces = n-i; spaces > 0; spaces --){
                System.out.print("  ");
            }
            for(int j = 1; j<= star;j++){
                System.out.print("* ");
            }
            star += 2;
            System.out.println();
        }
        for(int i = n; i>=1;i--){
            for(int spaces = n-i; spaces > 0; spaces --){
                System.out.print("  ");
            }
            star -= 2;
            for(int j = 1; j<= star;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }

    public static void diamondPattern2(int n){
        for(int i = 1; i<= n;i++){
            for(int spaces = n-i; spaces > 0; spaces --){
                System.out.print("  ");
            }
            for(int j = 1; j<= (2*i)-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = n; i>=1;i--){
            for(int spaces = n-i; spaces > 0; spaces --){
                System.out.print("  ");
            }
            for(int j = 1; j<= (2*i)-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        hollowRectangle(4,5);
        invertedHalfPyramid(8);
        invertedNumber(5);
        floydsTriangle(5);
        zeroOneTriangle(5);
        zeroOneTriangle2(5);
        butterflyPattern(4);
        solidRhombus(10);
        hollowRhombus(10);
        diamondPattern(4);
        diamondPattern2(4);
    }
}