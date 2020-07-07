package CompicatedSorting;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(62L);
        list.add(1L);
        list.add(112L);
        list.add(20L);
        list.add(12L);
        list.add(23L);
        list.add(23L);
        list.add(23L);
        list.add(23L);
        shellSort(list);
        System.out.println(list);
    }

    public static void shellSort(List<Long> theArray) {
        int inner, outer;
        long temp;
        int h = 1;
        while (h <= theArray.size() / 3)
            h = h * 3 + 1;
        while (h > 0) {
            for (outer = h; outer < theArray.size(); outer++) {
                temp = theArray.get(outer);
                inner = outer;
                while (inner > h - 1 && theArray.get(inner - h) >= temp) {
                    theArray.set(inner, theArray.get(inner - h));
                    inner -= h;
                }
                theArray.set(inner, temp);
            }
            h = (h - 1) / 3;
        }
    }
}
