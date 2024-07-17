import java.util.*

;
public class Problems {

    public static int noOfWays(int n){
        if(n==0 || n==1){
            return 1;
        }

        return noOfWays(n-1) + noOfWays(n-2);
    }

    public static int friendPairing(int n){
        if(n==1 || n==2){
            return n;
        }
        return friendPairing(n-1) + ((n-1)*friendPairing(n-2)); 
    }

    public static void printBinaryStrings(int n, int lastPlace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        // if(lastPlace == 0){
        //     printBinaryStrings(n-1, 0, str.append("0"));
        //     printBinaryStrings(n-1, 1, str.append("1"));
        // }
        // else{
        //     printBinaryStrings(n-1, 0, str.append("0"));
        // }
        printBinaryStrings(n-1,0, str+"0");
        if(lastPlace == 0){
            printBinaryStrings(n-1, 1, str+"1");
        }
    }

    public static String numCount(int key, int arr[], int i,String count){
        if(i==arr.length){
            return count;
        }
        if(arr[i]==key){
            return numCount(key, arr, i+1, count+i+" ");
        }
        return numCount(key, arr, i+1, count);
    } 

    public static int lenOfString(StringBuilder str,int len){
        if(str.isEmpty()){
            return len;
        }
        return lenOfString(str.deleteCharAt(0), len+1);
    }
    
    public static void main(String[] args) {
        int arr[] = {3,2,4,5,6,2,7,2,2};
        System.out.println(lenOfString(new StringBuilder("Ankit"), 0));    
    }
}
