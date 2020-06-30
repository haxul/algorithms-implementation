package simpleSorting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InsertionSorting {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 4).boxed().map(i -> new Random().nextInt(10)).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(Arrays.toString(insertSorting(new int[]{2, 4, 1, 3})));
    }


    public static int[] insertSorting(int[] list) {
        for (int out = 0; out < list.length; out++) {
            int in = out;
            int marker = list[out];
            while (in > 0  && list[in - 1] >= marker) {
                list[in] = list[in - 1];
                in--;
            }
            list[in] = marker;
        }
        return list;
    }

    public static List<Integer> insertSorting(List<Integer> list) {
        int in, out;
        for (out = 0; out < list.size(); out++) {
            int marker = list.get(out);
            in = out;
            while (in > 0 && list.get(in - 1) >= marker) {
                list.set(in, list.get(in - 1));
                in--;
            }
            list.set(in, marker);
        }
        return list;
    }
}

