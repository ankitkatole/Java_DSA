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
        private int n = 0;
        private LinkedList<Node> buckets[]; //N

        @SuppressWarnings("unchecked") //To suppress the warning
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
            int di = 0;
            for(int i =0;i<ll.size();i++){
                if(ll.get(i).key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;            
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            size = size*2;
            buckets = new LinkedList[size];
            for(int i = 0; i < size; i++) {
                buckets[i] = new LinkedList<>();
            }
            n = 0;
            for(int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for(int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);//Valiid value or -1
            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            else{
                Node node = new Node(key,value);
                buckets[bi].add(node);
                n++;
            }
            double lambda = n*1.0/size;
            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di != -1){
                return true;
            }
            return false;
        }

        public V remove(K key,V value){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di != -1){
                return buckets[bi].get(di).value;
            }
            return null;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                LinkedList<Node> ll = buckets[i];
                for(int j = 0; j < ll.size(); j++) {
                    keys.add(ll.get(j).key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }

        public void printMap(){
            for(int i = 0; i < size; i++) {
                LinkedList<Node> ll = buckets[i];
                for(int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    System.out.println(node.key + "-->" + node.value);
                }
            }
        }
    }

    public static void main(String[] args) {
        //Creating a HashMap
        // HashMap<String, Integer> map = new HashMap<>();
        // map.put("John", 25);
        // map.put("Jane", 22);
        // map.put("Doe", 30);
        // System.out.println(map);

        // //Iterating over the keys
        // Set<String> set = map.keySet();
        // System.out.println(set);

        // for(String key: set) {
        //     System.out.println(key + " " + map.get(key));
        // }

        Map<String,Integer> map = new Map<>();
        map.put("John", 25);
        map.put("Jane", 22);
        map.put("Doe", 30);
        System.out.println(map.keySet());
        map.printMap();
    }
}
