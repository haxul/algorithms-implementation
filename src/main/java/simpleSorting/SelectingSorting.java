package simpleSorting;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectingSorting {
    public static void main(String[] args) {

        List<Integer> list = IntStream.range(0, 4).boxed().map(i -> new Random().nextInt(10)).collect(Collectors.toList());
        System.out.println(list);
    }

    public static List<Integer> selectingSort(List<Integer> list) {
        int minIndex;
        for (int i = 0; i < list.size(); i++) {
            minIndex = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) minIndex = j;
            }
            int tmp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, tmp);
        }
        return list;
    }

    public static List<Integer> bubbleSorting(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        return list;
    }
}
