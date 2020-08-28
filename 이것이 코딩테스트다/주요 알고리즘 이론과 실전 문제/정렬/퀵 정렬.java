public class Main {
    static void swap(int idx1, int idx2, int[] arr) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void quick_sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= right && arr[left] <= arr[pivot]) {
                left += 1;
            }
            while (right > start && arr[right] >= arr[pivot]) {
                right -= 1;
            }
            if (left > right) {
                swap(pivot, right, arr);
            } else {
                swap(left, right, arr);
            }
        }

        quick_sort(arr, start, right - 1);
        quick_sort(arr, right + 1, end);
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        quick_sort(array, 0, array.length - 1);
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

}
