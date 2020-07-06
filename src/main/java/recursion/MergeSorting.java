package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSorting {
    public static void main(String[] args) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(1);
        left.add(11);
        left.add(111);
        left.add(1111);
        right.add(2);
        right.add(23);
        right.add(66);
        right.add(212);
        right.add(22222);
        List<Integer> merge = new ArrayList<>();
        mergeSorting(left, right, merge, right.size() - 1, left.size() - 1);

    }

//    public static List<Integer> mergeSort(List<Integer> list) {
//        if (list.size() == 1) return list;
//
//
//    }

    public static List<Integer> mergeSorting(List<Integer> left, List<Integer> right, List<Integer> merge, int rightLast, int leftLast) {
        if (left.isEmpty() && right.isEmpty()) return merge;
        else if (left.isEmpty()) {
            merge.add(right.get(rightLast));
            right.remove(rightLast);
            return mergeSorting(left, right, merge, rightLast - 1, 0);
        } else if (right.isEmpty()) {
            merge.add(left.get(left.size() - 1));
            left.remove(left.size() - 1);
            return mergeSorting(left, right, merge, 0, leftLast - 1);
        } else if (left.get(leftLast) > right.get(rightLast)) {
            merge.add(left.get(leftLast));
            left.remove(leftLast);
            return mergeSorting(left, right, merge, rightLast, leftLast - 1);
        } else {
            merge.add(right.get(rightLast));
            right.remove(rightLast);
            return mergeSorting(left, right, merge, rightLast - 1, leftLast);
        }


    }

}
