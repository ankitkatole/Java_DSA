public class backtracking {

    public static void changeArr(int arr[],int i, int val){
        if(i==arr.length){
            printArr(arr);
            return;
        }
        arr[i]=val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i] -2;
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //Find and print all subsets of a given string
    static int count;
     public static void findSubsets(String str,String ans,int index){
        if(index==str.length()){
            count++;
            if(ans.length()==0){
                System.out.println("NULL");
            }else{
                System.out.println(ans);
            }
            return;
        }
        findSubsets(str,ans+str.charAt(index),index+1);
        findSubsets(str,ans,index+1);
     }

     //Find and print permutation of a string
     public static void findPermutation(String str, String ans){
        if(str.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String dum = str.substring(0,i)+str.substring(i+1);
            findPermutation(dum, ans+ch);
        }
     }


    // (Grid ways) Find number of ways to reach from (0,0) to (N-1,M-1) in a N*M grid. ALlowed Moves are only right and down.
     public static int gridWays(int grid[][],int startRow,int startCol){
        if(startRow==grid.length-1 && startCol==grid[0].length-1){//Last Cell condn
            return 1;
        }
        if(startRow>=grid.length || startCol>=grid[0].length){//Out of Bound condn
            return 0;
        }
        
        return gridWays(grid,startRow+1,startCol)+gridWays(grid,startRow,startCol+1);
     }

     //Helper function
    public static int Factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * Factorial(n - 1);
    }

    public static int optimizedGridWays(int n,int m){
        return (Factorial(n-1+m-1)/(Factorial(n-1)*Factorial(m-1)));
    }


    public static void printSudoku(int board[][]){
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Write a function to complete Sudoku;
    public static boolean sudokuSolver(int sudoku[][], int row,int col){
        if(row == 9 && col ==0) return true;//Base case
        
        int nextRow = row, nextCol = col+1;
        if(col+1==9){
            nextRow = row+1;
            nextCol = 0;
        }
        if(sudoku[row][col] !=0){ //if cell is not empty
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }

    public static boolean isSafe(int sudoku[][], int row,int col,int digit){
        for(int i = 0;i<9;i++){
            if(sudoku[i][col]==digit) return false;
        }
        
        for(int i = 0;i<9;i++){
            if(sudoku[row][i]==digit) return false;
        }

        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i = startRow;i<startRow+3;i++){
            for(int j = startCol;j<startCol+3;j++){
                if(sudoku[i][j]==digit) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);

        System.out.println("Permutation:");
        System.out.println("Permutations of 'abc':");
        findPermutation("abc", "");
    
        System.out.println("\nPermutations of 'ab':");
        findPermutation("ab", "");
    
        System.out.println("\nPermutations of 'a':");
        findPermutation("a", "");
    
        System.out.println("\nPermutations of '':");
        findPermutation("", "");
    
        System.out.println("\nPermutations of 'aab':");
        findPermutation("aab", "");
    
        System.out.println("\nPermutations of 'abcd':");
        findPermutation("abcd", "");

        System.out.println();

        System.out.println("Grid Ways:");
        int[][] grid1 = new int[2][2];
        System.out.println("Expected: 2, Actual: " + gridWays(grid1, 0, 0));
        System.out.println("Expected: 2, Actual: " + optimizedGridWays(2,2));
        
    
        int[][] grid2 = new int[3][3];
        System.out.println("Expected: 6, Actual: " + gridWays(grid2, 0, 0));
        System.out.println("Expected: 6, Actual: " + optimizedGridWays(3,3));
    
        int[][] grid3 = new int[3][4];
        System.out.println("Expected: 10, Actual: " + gridWays(grid3, 0, 0));
        System.out.println("Expected: 10, Actual: " + optimizedGridWays(3,4));
    
        int[][] grid4 = new int[4][4];
        System.out.println("Expected: 20, Actual: " + gridWays(grid4, 0, 0));
        System.out.println("Expected: 20, Actual: " + optimizedGridWays(4,4));
    
        int[][] grid5 = new int[1][5];
        System.out.println("Expected: 1, Actual: " + gridWays(grid5, 0, 0));
        System.out.println("Expected: 1, Actual: " + optimizedGridWays(1,5));
    
        int[][] grid6 = new int[5][1];
        System.out.println("Expected: 1, Actual: " + gridWays(grid6, 0, 0));
        System.out.println("Expected: 1, Actual: " + optimizedGridWays(5,1));
    
        int[][] grid7 = new int[4][5];
        System.out.println("Expected: 35, Actual: " + gridWays(grid7, 0, 0));
        System.out.println("Expected: 35, Actual: " + optimizedGridWays(4,5));


        int sudoku[][] = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("Sudoku Solved");
            printSudoku(sudoku);
        }else{
            System.out.println("Sudoku Not Solved");
        }

    }
}
