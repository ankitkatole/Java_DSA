import java.util.*;
public class HSQuestions {
    /* Question 1: Count Distinct Elelments */
    public static int countDistinctElements(int arr[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int i : arr){
            hs.add(i);
        }
        return hs.size();
    }

    /* Question 2: Union and Intersection of two Arrays
     * arr1 = {7,3,9}
     * arr2 = {6,3,9,2,9,4}
     */

    public static void unionIntersection(int arr1[], int arr2[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int i : arr1){
            hs.add(i);
        }
        for(int i : arr2){
            hs.add(i);
        }
        System.out.println("Union: "+hs);
        hs.clear();
        for(int i : arr1){
            hs.add(i);
        }
        HashSet<Integer> hs2 = new HashSet<>();
        for(int i : arr2){
            if(hs.contains(i)){
                hs2.add(i);
            }
        }
        System.out.println("Intersection: "+hs2);
    }

    /* Question 3: Find itinerary of Tickets 
     * "Chennai" -> "Bangalore"
     * "Bombay" -> "Delhi"
     * "Goa" -> "Chennai"
     * "Delhi" -> "Goa"
     * Output: Bombay -> Delhi -> Goa -> Chennai -> Bangalore
    */
    public static void findItinerary(HashMap<String,String> tickets){
        HashSet<String> from = new HashSet<>();
        HashSet<String> to = new HashSet<>();
        for(Map.Entry<String,String> entry : tickets.entrySet()){
            from.add(entry.getKey());
            to.add(entry.getValue());
        }
        String start = "";
        for(String s: from){
            if(!to.contains(s)){
                start = s;
                break;
            }
        }
        if(start.equals("")){
            System.out.println("Invalid Input");
            return;
        }
        System.out.print(" -> "+start);
        while(tickets.containsKey(start)){
            start = tickets.get(start);
            System.out.print(" -> "+start);
        }
        System.out.println();
    }

    /* Question  4: Largest Subarray with 0 sum 
     * arr = {15,-2,2,-8,1,7,10,23}
     * Output: 5
    */
    
    public static void main(String[] args) {
        System.out.println("Question 1: Count Distinct Elements");
        int arr[] = {4,3,2,5,6,7,3,4,2,1};
        System.out.println("Array: "+Arrays.toString(arr));
        System.out.println(countDistinctElements(arr));
        System.out.println("-------------------------------");
        System.out.println("Question 2: Union and Intersection");
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        unionIntersection(arr1, arr2);
        System.out.println("-------------------------------");
        System.out.println("Question 3: Find Itinerary");
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","Bangalore");
        tickets.put("Bombay","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");
        System.out.print("*");
        findItinerary(tickets);
        System.out.println("-------------------------------");
    }
}
