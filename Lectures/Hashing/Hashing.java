import java.util.*;
public class Hashing {
    static class Map<K,V>{
        private class Node {
            K key;
            V value;
            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private LinkedList<Node> buckets[]; //N

        @SuppressWarnings("unchecked"); 
        public Map() {
            size = 4;
            buckets = new LinkedList[4];
            for(int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % size;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            
        }
        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key);

        }

        public boolean containsKey(K key) {

        }
    }

    public static void main(String[] args) {
        //Creating a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("John", 25);
        map.put("Jane", 22);
        map.put("Doe", 30);
        System.out.println(map);

        //Iterating over the keys
        Set<String> set = map.keySet();
        System.out.println(set);

        for(String key: set) {
            System.out.println(key + " " + map.get(key));
        }

    }
}
