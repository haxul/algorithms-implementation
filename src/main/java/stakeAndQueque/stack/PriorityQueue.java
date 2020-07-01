package stakeAndQueque.stack;

class MainRun {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(2);
        priorityQueue.insert(1);
        priorityQueue.insert(3);
        priorityQueue.insert(0);
        System.out.println("-------------");
    }
}

public class PriorityQueue {
    private int maxSize = 5;
    private long[] queArray = new long[maxSize];
    private int nItems = 0;
    private int front = 0;

    public void insert(long item) {
        if (nItems == 0) {
            queArray[nItems++] = item;
            return;
        }
        int j;
        for (j = nItems - 1; j >= 0; j--) {
            if (item > queArray[j]) queArray[j + 1] = queArray[j]; // сдвинуть вверх
            else break;
        }
        queArray[j + 1] = item;
        nItems++;

    }

    public void remove() {
        --nItems;
    }

}
