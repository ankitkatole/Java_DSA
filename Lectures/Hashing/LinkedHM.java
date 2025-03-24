import java.util.*;
public class LinkedHM {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> hm = new LinkedHashMap<>();
        hm.put("India", 135);
        hm.put("China", 200);
        hm.put("US", 40);
        hm.put("UK", 20);
        System.out.println(hm);

        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India", 135);
        tm.put("China", 200);
        tm.put("US", 40);
        tm.put("UK", 20);
        System.out.println(tm);
    }
}
