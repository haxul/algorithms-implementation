package arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(0,100).boxed().collect(Collectors.toList());
        System.out.println(binarySearch(list, 1));
    }

    public static int binarySearch(List<Integer> list, int element) {
        if (list.get(list.size()/2) == element) return element;
        if (list.size() == 1 && list.get(0) != element) return -1;
        if (element > list.get(list.size() / 2)) {
            List<Integer> right = list.stream().skip(list.size() / 2).collect(Collectors.toList());
            return binarySearch(right, element);
        }
        List<Integer> left = list.stream().takeWhile(e -> e < list.get(list.size() / 2)).collect(Collectors.toList());
        return binarySearch(left, element);
    }
}
