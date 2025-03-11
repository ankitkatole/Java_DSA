import java.util.*;
public class Heaps {
    static class Student implements Comparable<Student>{
        int rank;
        String name;
        Student(int rank, String name){
            this.rank = rank;
            this.name = name;
        }
        @Override
        public int compareTo(Student o){
            return this.rank - o.rank;
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(10);
        // pq.add(20);
        // pq.add(15);
        // pq.add(30);
        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek());
        //     pq.remove();
        // }

        
    }
}