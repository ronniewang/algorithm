package r.w.practice.sort;

import java.util.Arrays;

/**
 * @author ronniewang
 * 2019-10-29 14:12
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = new int[]{1, 23, 1, 23, 6, 5, 3, 2, 34, 6, 34, 1232, 5, 3234, 43, 2};
        sort(array);
        System.out.println("array = " + Arrays.toString(array));
    }

    private static void sort(int[] array) {

        if (array == null) {
            throw new IllegalArgumentException("null");
        }
        qSort(array, 0, array.length - 1);
    }

    private static void qSort(int[] array, int start, int end) {

        if (start >= end) {
            return;
        }
        int index = partition(array, start, end);
        qSort(array, start, index - 1);
        qSort(array, index + 1, end);
    }

    private static int partition(int[] array, int start, int end) {

        final int anchor = array[end];
        int slow = start - 1;
        for (int fast = start; fast < end; fast++) {
            if (array[fast] <= anchor) {
                ++slow;
                swap(array, slow, fast);
            }
        }
        swap(array, slow + 1, end);
        return slow + 1;
    }

    private static void swap(int[] array, int slow, int fast) {

        int tmp = array[slow];
        array[slow] = array[fast];
        array[fast] = tmp;
    }
}
