public class HeapSort {
    public static void heapifyMax(int arr[],int i , int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left < size && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < size && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyMax(arr,largest,size);
        }
    }
    public void HeapSortAsc(int arr[]){
        int n = arr.length;
        for(int i = n/2;i>=0;i--){
            heapifyMax(arr,i,n);
        }

        for(int i = n-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapifyMax(arr,0,i);
        }
    }

    public void heapifyMin(int arr[],int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int smallest = i;
        if(left < size && arr[left] < arr[smallest]){
            smallest = left;
        }
        if(right < size && arr[right] < arr[smallest]){
            smallest = right;
        }
        if(smallest != i){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapifyMin(arr,smallest,size);
        }
    }

    public void HeapSortDesc(int arr[]){
        int n = arr.length;
        for(int i = n/2;i>=0;i--){
            heapifyMin(arr,i,n);
        }

        for(int i = n-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapifyMin(arr,0,i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        HeapSort ob = new HeapSort();
        ob.HeapSortAsc(arr);
        System.out.println("Sorted array in Ascending Order");
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nSorted array in Descending Order");
        ob.HeapSortDesc(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
