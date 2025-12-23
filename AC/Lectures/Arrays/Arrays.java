public class Arrays {

    public static int linearsearch(int list[],int key){
        for(int i = 0; i< list.length;i++){
            if(list[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void reverseArray(int arr[]){
         int temp;
         int size = arr.length-1;
        for(int i = 0;i<(arr.length/2);i++){
            temp = arr[i];
            arr[i] = arr[size-i];
            arr[size-i] = temp;
        }
    }

    public static void pairsInArray(int arr[]){
        for(int i = 0;i<arr.length;i++){
            int current = arr[i];
            for(int j = i+1; j< arr.length;j++){
                System.out.print(("("+current+","+arr[j]+")"));
            }
            System.out.println();
        }
    }

    public static void subArrays(int arr[]){
        for(int i = 0; i<arr.length;i++){
            for(int j = i; j<arr.length;j++){
                for(int k = i; k <= j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int maxSubArraySum(int arr[]){
        int maximum = Integer.MIN_VALUE;

        for(int i = 0; i<arr.length;i++){
            for(int j = i; j<arr.length;j++){
                int num = 0;
                for(int k = i; k <= j;k++){
                    num+= arr[k];
                }
                if(num>maximum){
                    maximum = num;
                }
            }
        }
        return maximum;
    }


    public static int prefixSum(int arr[]){
        int prefix[] = new int[arr.length];
        int currSum = 0;
        int maximum = Integer.MIN_VALUE;

        
        prefix[0] = arr[0];

        for(int i = 1;i<arr.length;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }

        for(int i = 0;i<arr.length;i++){

            for(int j = i; j<arr.length;j++){
                currSum = i == 0 ? prefix[j] : prefix[j]-prefix[i-1];
                if(maximum < currSum){
                    maximum = currSum;
                }
            }
        }
        return maximum;
    }

    public static int kadanesAlgorithm(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            currSum = currSum+arr[i];
            if( currSum < 0){
                currSum = 0;
            }

            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        reverseArray(arr);
        System.out.println("Reversed Array");
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Pairs:");
        pairsInArray(arr);

        System.out.println("Sub Arrays");
        subArrays(arr);
        
        System.out.println("Maximum Sub array Sum: "+maxSubArraySum(arr));

        System.out.println("Maximum Sub array Sum: "+prefixSum(arr));
        
        System.out.println("Maximum Sub array Sum: "+kadanesAlgorithm(arr));
        
    }    
}
