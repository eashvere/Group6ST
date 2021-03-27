import java.util.*;

public class ST_P7_HeapSort_Eashver_Elango {
    /*
    Time Complexity: O(nlog(n))
    */
    public static int[] KsmallestMinHeap(int[] a, int k){
        // Check if a doesn't have any elements
        if(a.length == 0){
            return new int[0];
        }

        // Create Priority and add all the values of the array
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int value : a) minHeap.add(value);

        // Poll the first k of the priority queue
        int[] f = new int[k];
        for(int i=0; i<k; i++){
            f[i] = minHeap.poll();
        }

        return f;
    }

    public static int[] KsmallestMaxHeap(int[] a, int k){
        // Check if a has any elements
        if(a.length == 0){
            return new int[0];
        }

        // Create a max heap and add the first k elements of the array
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){ 
            @Override
            public int compare(Integer lhs, Integer rhs) {
                if (lhs < rhs) return +1;
                if (lhs.equals(rhs)) return 0;
                return -1;
            }
        });
        for(int i=0;i<k;i++) maxHeap.add(a[i]);

        //Iterate over the rest
        for(int i=k; i<a.length; i++){
            int curr = a[i];
            // if the current value is greater or equal to the largest value of the heap. ignore
            if(curr >= maxHeap.peek()) continue;
            // otherwise remove the largest value from the heap and add the smaller value from the array
            else {
                maxHeap.poll();
                maxHeap.add(curr);
            }
        }

        // Since values are only order in a Priority Queue when polling, poll the k values from the queue and return
        int[] r = new int[k];
        for(int i=k-1;i>=0;i--){
            r[i] = maxHeap.poll();
        }

        return r;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        int[] test2 = {};
        int[] test3 = {9, 5, 10, 4, 9, 3, 2, 1};
        int[] test4 = {2, 4, 1, 5, 7, 9, 2, 3};
        int[] test5 = {0, 0, 0, 0, 0, 0, 0};

        System.out.println(Arrays.toString(KsmallestMaxHeap(test1, 3)));
        System.out.println(Arrays.toString(KsmallestMinHeap(test1, 3)));

        System.out.println(Arrays.toString(KsmallestMaxHeap(test2, 5)));
        System.out.println(Arrays.toString(KsmallestMinHeap(test2, 5)));

        System.out.println(Arrays.toString(KsmallestMaxHeap(test3, 4)));
        System.out.println(Arrays.toString(KsmallestMinHeap(test3, 4)));

        System.out.println(Arrays.toString(KsmallestMaxHeap(test4, 4)));
        System.out.println(Arrays.toString(KsmallestMinHeap(test4, 4)));

        System.out.println(Arrays.toString(KsmallestMaxHeap(test5, 4)));
        System.out.println(Arrays.toString(KsmallestMinHeap(test5, 4)));
    }
}
