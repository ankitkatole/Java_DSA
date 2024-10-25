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
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String dum = str.substring(0,i)+str.substring(i+1);
            findPermutation(dum, ans+ch);
        }
     }

    public static void main(String[] args) {
        int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);
        String str = "abc";
        // findSubsets(str,"",0);
        // System.out.println(count);
        findPermutation(str, "");


    }
}
