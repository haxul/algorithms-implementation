package simpleSorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BubbleSorting {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(0, 51)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(list::add);

        System.out.println(bubbleSorting(list, true, 0));
    }

    public static List<Integer> bubbleSorting(List<Integer> list, boolean isSorted, int index) {
        if (index >= list.size() - 1) return bubbleSorting(list, true, 0);
        if (list.get(index) < list.get(index + 1)) {
            int tmp = list.get(index);
            list.set(index, list.get(index + 1));
            list.set(index + 1, tmp);
            isSorted = false;
        }
        if (isSorted) return list;
        return bubbleSorting(list, true, index + 1);
    }
}
