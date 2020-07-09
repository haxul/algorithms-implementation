package recursion;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(9);
        int middle = splitter(list, 5);
        System.out.println(list);
    }

    public static int splitter(List<Integer> list, int pivot) {
        int leftIndex = 0;
        int rightIndex = list.size() - 1;
        while (true) {
            while(list.get(leftIndex++) > pivot) break;
            while(list.get(rightIndex--) < pivot) break;
            if (leftIndex >= rightIndex) break;
            else swap(leftIndex, rightIndex, list);
        }
        return leftIndex;
    }

    public static void swap(int i, int y, List<Integer> list) {
        int tmp = list.get(i);
        list.set(i, list.get(y));
        list.set(y, tmp);
    }
}
