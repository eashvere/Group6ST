import java.util.Arrays;
import java.util.NoSuchElementException;

/* Eashver Elango: Comments and Coding
* Daniel Gao: Comments and Coding
* Daniel Hu: Comments and Coding
* Puvith: Comments 
*/

// Implements a priority queue of comparable objects using a
// min-heap represented as an array.
public class HeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;
    
    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        elementData = (E[])new Comparable[10];
        size = 0;
    }
    
    // Adds the given element to this queue.
    // Time Complexity of O(h) or O(logN) since in the worst case
    // a value would have to bubbled from the bottom of the heap to the top.
    public void add(E value) {
        // Increase size of elementData if necessary
        if (size + 1 >= elementData.length){
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }

        int index = size + 1;
        elementData[index] = value; //Add value to last slot

        // Move element until order is restored
        boolean finished = false;
        while(!finished && hasParent(index)){
            int parent = parent(index);
            if(elementData[parent].compareTo(elementData[index]) > 0){
                swap(elementData, index, parent);
                index = parent;
            } else {
                finished = true;
            }
        }
        size++;
    }
    
    // Returns true if there are no elements in this queue.
    // Time Complexity of O(1)
    public boolean isEmpty() {
    	return size == 0;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    // Time Complexity of O(1)
    public E peek() {
    	if(isEmpty()){
            throw new NoSuchElementException();
        }
    	return elementData[1];
    }
    
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    // Time Complexity of O(h) or O(logN) since in the worst case
    // a value would have to bubbled from the top of the heap to the bottom.
    public E remove() {
    	if(isEmpty()){
            throw new NoSuchElementException();
        }

        // save minimum value and remove it
        E result = elementData[1];

        elementData[1] = elementData[size];
        elementData[size] = null;
        size--;


        // restore order to min-heap
        boolean finished = false;
        int index = 1;
        while(!finished  && hasLeftChild(index)){
            int left = leftChild(index);
            int child = left;
            if(hasRightChild(index)) {
                int right = rightChild(index);
                if(elementData[right].compareTo(elementData[left]) < 0){
                    child = right;
                }
            }
            if(elementData[index].compareTo(elementData[child]) > 0){
                swap(elementData, index, child);
                index = child;
            } else {
                finished = true;
            }
        }

        return result;
    }
    
    // Returns the number of elements in the queue.
    // Time Complexity of O(1)
    public int size() {
    	return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    
    // helpers for navigating indexes up/down the tree
    // Time Complexity of O(1)
    private int parent(int index) {
    	return index/2;
    }
    
    // returns index of left child of given index
    // Time Complexity of O(1)
    private int leftChild(int index) {
    	return (2 * index);
    }
    
    // returns index of right child of given index
    // Time Complexity of O(1)
    private int rightChild(int index) {
    	return (index * 2) + 1;
    }
    
    // returns true if the node at the given index has a parent (is not the root)
    // Time Complexity of O(1)
    private boolean hasParent(int index) {
    	return index > 1;
    }
    
    // returns true if the node at the given index has a non-empty left child
    // Time Complexity of O(1)
    private boolean hasLeftChild(int index) {
    	return leftChild(index) <= size;
    }
    
    // returns true if the node at the given index has a non-empty right child
    // Time Complexity of O(1)
    private boolean hasRightChild(int index) {
    	return rightChild(index) <= size;
    }
    
    // switches the values at the two given indexes of the given array
    // Time Complexity of O(1)
    private void swap(E[] a, int index1, int index2) {
    	E swap = a[index1];
        a[index1] = a[index2];
        a[index2] = swap;
    }
}
