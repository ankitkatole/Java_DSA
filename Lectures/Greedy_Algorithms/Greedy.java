import java.util.*;

public class Greedy {

    public static void activitySelection(int start[], int end[]){
        //end time basis sorted
        int maxActivities = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st Activity
        maxActivities++;
        ans.add(0);

        int lastEnd = end[0];
        for(int i = 1;i<end.length;i++){
            if(start[i] >= lastEnd){
                maxActivities++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Maximum activities: " + maxActivities);
    }


    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        System.out.println(activitySelection(start, end));
    }
}
