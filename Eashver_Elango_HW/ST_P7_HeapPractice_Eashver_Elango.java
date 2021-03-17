import java.util.*;

public class ST_P7_HeapPractice_Eashver_Elango {
    /*
    isConsecutive takens in a PriorityQueue (a min heap) and returns
    whether the values are consecutive.

    We create a copy to not change the input queue. Then we iterate over 
    checking whether each value has a difference of 1. Return true or false
    based on whether its consecutive or not.

    Time Complex: O(n)
    Space Complex: O(n)
    */
    public boolean isConsecutive(PriorityQueue<Integer> pq){
        PriorityQueue<Integer> copy = new PriorityQueue<>(pq);

        while(copy.size() > 1){
            if(copy.poll() != copy.peek() - 1){
                return false;
            }
        }
        return true;
    }

    /*
    removeDuplicates removes duplicates from an inputted PriorityQueue

    We use a stack to keep track of duplicate values. We then iterate over
    the queue check whether we've seen that number before by cross-referencing
    with our Stack.

    Time Complex: O(n)
    Space Complex: O(n)
    */
    public PriorityQueue<Integer> removeDuplicates(PriorityQueue<Integer> pq) {
        Stack<Integer> st = new Stack<Integer>();
        Iterator qi = pq.iterator();
        while(qi.hasNext()){
            int side = (int) qi.next();
            if(st.isEmpty() || st.peek() != side){
                st.push(side);
            } else {
                qi.remove();
            }
        }

        return pq;
    }

    /*
    stutter adds another of each value assuming there are no duplicates already

    We iterate over the queue and add each value to a separate arraylist. We then
    add all the values from the arraylist back into the queue

    Time Complex: O(n)
    Space Complex: O(n)
    */
    public PriorityQueue<Integer> stutter(PriorityQueue<Integer> pq) {
        ArrayList<Integer> dups = new ArrayList<Integer>();
        Iterator qi = pq.iterator();
        while(qi.hasNext()){
            int side = (int) qi.next();
            dups.add(side);
        }

        pq.addAll(dups);

        return pq;
    }

    /*
    fillgaps adds values to make the queue have consecutive values

    Essentially we iterate over the queue and take the difference bewteen 
    each neighboring values. If there's a difference greater than 1, we 
    add in the values through an internal for loop. 

    Time Complex: O(n^2)
    Space Complex: O(n)
    */
    public PriorityQueue<Integer> fillGaps(PriorityQueue<Integer> pq){
        if(pq.isEmpty()){
            return pq;
        }
        ArrayList<Integer> gaps = new ArrayList<Integer>();
        Iterator qi = pq.iterator();
        int before = (int) qi.next();
        while(qi.hasNext()){
            int cur = (int) qi.next();
            int sep = cur-before-1;
            if(sep > 0){
                for(int i=1;i<=sep;i++){
                    gaps.add(before+i);
                }
            }
            before=cur;
        }
        pq.addAll(gaps);
        return pq;
    }
}