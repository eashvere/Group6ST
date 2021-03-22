// This client program tests our priority queue
// by adding and removing several elements from it.

public class HeapMain {
    public static void main(String[] args) {
    	HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<>();
        Integer[] elements = {65, 50, 20, 90, 44, 60, 80, 70, 99, 10};
        for (int n : elements) {
            pq.add(n);
            System.out.println(pq);
        }
        
        // System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
            System.out.println(pq + ", size "+ pq.size());
        }
        
        System.out.println("==================================================================");
        HeapPriorityQueue<String> strPq = new HeapPriorityQueue<>();
        String[] strElements = {"Alex", "Greg", "Kelvin", "Maggie", "Eric", "Bob", "Zach", "Jake", "Barb", "Zilo", "Barb", "Chelsea"};
        for (String s : strElements) {
        	strPq.add(s);
            System.out.println(strPq);
        }
        
        // System.out.println(pq);
        while (!strPq.isEmpty()) {
            System.out.println(strPq.remove());
            System.out.println(strPq + ", size "+ strPq.size());
        }
    }
}
