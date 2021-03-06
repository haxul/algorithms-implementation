package recursion;

import java.util.List;

public class ShortSorting {
    public static void main(String[] args) {
        int maxSize = 16;
        ArrayPar arr;
        arr = new ArrayPar(maxSize);
        for (int j = 0; j < maxSize; j++) {
            long n = (int) (java.lang.Math.random() * 199);
            arr.insert(n);
        }
        arr.display();
        long pivot = 99;
        arr.recQuickSort(0, arr.size() - 1);
//        System.out.print("Pivot is " + pivot);
//        int size = arr.size();
//        int partDex = arr.partitionIt(0, size - 1, pivot);
//        System.out.println(", Partition is at index " + partDex);
        arr.display();

    }
}

class ArrayPar {
    private long[] theArray;

    private int nElems;


    public ArrayPar(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public int size() {
        return nElems;
    }

    public void display() {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " "); // Вывод
        System.out.println("");
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right &&
                    theArray[++leftPtr] < pivot)
                ; // (пустое тело цикла)
            while (rightPtr > left &&
                    theArray[--rightPtr] > pivot)
                ; // (пустое тело цикла)
            if (leftPtr >= rightPtr) break;
            else swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    public void swap(int dex1, int dex2) // Перестановка двух элементов
    {
        long temp;
        temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    public void recQuickSort(int left, int right) {
        if (right - left <= 0)
            return;
        else {
            long pivot = theArray[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right); // Сортировка правой части
        }
    }
}