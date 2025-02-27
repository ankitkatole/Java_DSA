public class SearchInSortedMatrix {

    public static boolean staircaseSearch(int matrix[][],int key){
        int row = 0, col = matrix[0].length-1;
        while(row < matrix.length && col>=0){

            if(matrix[row][col] == key){
                System.out.println("Key Found @("+row+","+col+")");
                return true;
            }else if(key < matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        System.out.println("Key not Found in given matrix");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]={{10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                        {32,33,39,50}};
        int ar[][] = {{1,3,5,7},
                    {10,11,16,20},
                    {23,30,34,60}};
        int key = 33;
        staircaseSearch(ar, 3);    
    }
}
