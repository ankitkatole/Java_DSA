public class DisjointSets {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for (int i = 0; i < n; i++) {
            par[i] = i; 
            rank[i] = 0;
        }
    }
    public static int find(int x){
        if(par[x] != x){
            par[x] = find(par[x]); // Path compression
        }
        return par[x];
    }


    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);
        if(parA == parB) return; 
        
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] > rank[parB]){
            par[parB] = parA;
        }else{
            par[parA] = parB;
        }
        System.out.println("Union of " + a + " and " + b + " completed.");
    }
    public static void main(String[] args) {
        init();
        union(1,3);
        System.out.println("find(3): " + find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println("find(3): " + find(3));
        System.out.println("find(4): " + find(4));
        union(1,5);
        System.out.println("Ranks:");
        for (int i = 0; i < n; i++) {
            System.out.println("Rank of " + i + ": " + rank[i]);  
        }
    }
}
