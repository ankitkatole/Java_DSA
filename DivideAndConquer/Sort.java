    public class Sort {

        public static void printArray(int arr[]){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public static void mergeSort(int arr[], int start, int end) {
            if(start>=end){
                return;
            }
            int mid = start + (end-start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr,start,mid,end);        
        }
        public static void merge(int arr[],int start,int mid,int end){
            int temp[] = new int[end-start+1];
            int i = start;
            int j = mid+1;
            int k = 0;
            while(i<=mid && j<=end){
                if(arr[i]<arr[j]){
                    temp[k] = arr[i];
                    i++;
                } else{
                    temp[k] = arr[j];
                    j++;
                }
                k++;
            }
            while(i<=mid){
                temp[k++] = arr[i++];
            }
            while(j<=end){
                temp[k++] = arr[j++];
            }
            for(k = 0, i = start;k<temp.length;k++,i++){
                arr[i] = temp[k];
            }
        }


        
        public static void quickSort(int arr[],int start, int end){
            if(start>=end){
                return;
            }
            int pivot = Partition(arr,start,end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot, end);
        }

        public static int Partition(int arr[], int start, int end){
            int pivot = arr[end];
            int i = start-1;

            for(int j = start; j < end; j++){
                if(arr[j]<=pivot){
                    i++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            i++;
            int temp = pivot;
            arr[end] = arr[i];
            arr[i] = temp;
            return i;
        }


        public static void main(String[] args) {
            int arr[] = {6,3,9,5,2,8};
            printArray(arr);
            //mergeSort(arr, 0, arr.length - 1);
            quickSort(arr, 0, arr.length-1);
            printArray(arr);
        }
    }
