public class NQueen {

    public static boolean isSafe(char board[][], int row, int col){
        //Vertically Up
        for(int i = row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //Diagonally Up Left
        for(int i = row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //Diagonally Right up
        for(int i = row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true; 
        
    }

    static int count = 0;
    public static void nQueens(char board[][], int row){
        if(row == board.length){
            count++;
            printBoard(board);
            return;
        }
        for(int j = 0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] ='Q';
                nQueens(board,row+1);
                board[row][j]='X';
            }
        }

    }

    public static boolean checkNQueens(char board[][], int row){
        if(row == board.length){
            count++;
            return true;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] ='Q';
                if(checkNQueens(board,row+1)){
                    return true;
                }
                board[row][j]='X';
            }
        }
        return false;

    }



    public static void printBoard(char board[][]){
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 4;
        char board[][]= new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n;j++){
                board[i] [j] = 'X';
            }
        }
        nQueens(board,0);
        System.out.println("No of ways to Place Queens is "+count);

        if(checkNQueens(board, 0)){
            System.out.println("Solution is Possible");
            printBoard(board);
        }else{
            System.out.println("Solution doesnt Exists");
        }
    }
}
