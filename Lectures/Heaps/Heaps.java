import java.util.*;

public class Heaps {
    static class MinHeap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int val){
            //Add at the end
            arr.add(val);
            int x = arr.size()-1;
            int par = (x-1)/2;
            while(arr.get(x) < arr.get(par)){ ///O(logn)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){ //O(1)
            return arr.get(0);
        }

        private void heapify(int i){ //O(logn)
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            if(left < arr.size() && arr.get(left) < arr.get(minIdx)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(right) < arr.get(minIdx)){
                minIdx = right;
            }
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }

        public int remove(){ //O(logn)
            if(isEmpty()){
                return -1;
            }
            int data = arr.get(0);


            //Swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //Remove last
            arr.remove(arr.size()-1);

            //Heapify
            heapify(0);

            return data;
        }


        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    static class MaxHeap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int val){
            //Add at the end
            arr.add(val);
            int x = arr.size()-1;
            int par = (x-1)/2;
            while(arr.get(x) > arr.get(par)){ ///O(logn)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){ //O(1)
            return arr.get(0);
        }

        private void heapify(int i){ //O(logn)
            int left = 2*i+1;
            int right = 2*i+2;
            int maxIdx = i;
            if(left < arr.size() && arr.get(left) > arr.get(maxIdx)){
                maxIdx = left;
            }
            if(right < arr.size() && arr.get(right) > arr.get(maxIdx)){
                maxIdx = right;
            }
            if(maxIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(maxIdx));
                arr.set(maxIdx, temp);
                heapify(maxIdx);
            }
        }

        public int remove(){ //O(logn)
            if(isEmpty()){
                return -1;
            }
            int data = arr.get(0);


            //Swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //Remove last
            arr.remove(arr.size()-1);

            //Heapify
            heapify(0);

            return data;
        }


        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        System.out.println("Min Heap");
        MinHeap h = new MinHeap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while(!h.isEmpty()){
            System.out.println(h.remove());
        }
        System.out.println("Max Heap");
        MaxHeap h1 = new MaxHeap();
        h1.add(3);
        h1.add(4);
        h1.add(1);
        h1.add(5);
        while(!h1.isEmpty()){
            System.out.println(h1.remove());
        }
    }
}
