import java.util.*;
public class ArrayLists {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //Add Operation
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1,9);
        list.add(32);
        list.add(100);
        System.out.println(list);
        //Get Operation
        int el = list.get(2);
        System.out.println(el);

        //Remove element
        // list.remove(2);
        // System.out.println(list);

        //Set Element at Index
        list.set(2,10);
        System.out.println(list);

        //Contains
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));
        
        //Size of an Array List
        System.out.println(list.size());

        //Sorting an Array List
        Collections.sort(list);
        System.out.println(list);

        //2-D Array List
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        list2.add(list);
        System.out.println(list2);
    }
}
