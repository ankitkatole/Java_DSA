import java.util.*;

public class HashSets {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Apple");
        set.add("Banana");
        System.out.println(set);
        System.out.println(set.contains("Apple"));
        System.out.println(set.contains("Grapes"));

        set.remove("Apple");
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println("--------------------");
        // Iterating over the elements via Iterator interface
        System.out.println("Iterating over the elements via Iterator interface");
        Iterator it = set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------------------");
        // Iterating over the elements via for-each loop
        System.out.println("Iterating over the elements via for-each loop");
        for(String s : set) {
            System.out.println(s);
        }
        
        System.out.println("---------------------------------------------------------------------------");
        //LinkedHashSet in Java
        System.out.println("LinkedHashSet in Java");
        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");
        System.out.println(cities);
        cities.remove("Mumbai");
        System.out.println(cities);
        System.out.println("--------------------");
        System.out.println("Iterating over the elements via for-each loop in LinkedHashSet");
        for(String city : cities) {
            System.out.println(city);
        }
        System.out.println("---------------------------------------------------------------------------");
        
        //TreeSet in Java
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(15);
        System.out.println(treeSet);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        
        System.out.println("--------------------");
        System.out.println("Iterating over the elements via for-each loop in TreeSet");
        for(int i : treeSet) {
            System.out.println(i);
        }
    }
}
