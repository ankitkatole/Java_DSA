// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

// Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

// Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
// Constraints:

// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
 

// Follow up:

// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.

public class SetMatrixZero{
    public static void zeroMatrix1(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

            for(int i= 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(row[i] || col[j]){
                        matrix[i][j] = 0;
                    }
                }
            }
    }

    public static void zeroMatrix2(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        for(int i = 0;i<n;i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }
        for(int j = 0;j<m;j++){
            if(matrix[0][j] == 0){
                firstRow = true;
                break;
            }
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstCol){
            for(int i = 0;i<n;i++){
                matrix[i][0] = 0;
            }
        }
        if(firstRow){
            for(int j = 0;j<m;j++){
                matrix[0][j] = 0;
            }
        }
    }


    public static void printMatrix(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        
        printMatrix(matrix);
        zeroMatrix1(matrix);
        printMatrix(matrix);

        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        printMatrix(matrix2);
        zeroMatrix2(matrix2);
        printMatrix(matrix2);
    }
}