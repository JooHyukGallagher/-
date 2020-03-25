import java.io.*;
import java.util.*;

public class Solution {
 // Complete the quickSort function below.
    static void swap(int idx1, int idx2, int[] arr) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        ArrayList<Integer> leftlist = new ArrayList<>();
        ArrayList<Integer> rightlist = new ArrayList<>();

        for (int i = left + 1; i <= right; i++) {
            if(arr[i] > pivot){
                rightlist.add(arr[i]);
            } else {
                leftlist.add(arr[i]);
            }
        }
        copy(leftlist, arr, left);
        int ppos = leftlist.size()+left;
        arr[ppos] = pivot;
        copy(rightlist, arr, ppos+1);

        return left + leftlist.size();
    }

    static void copy(ArrayList<Integer> list, int[] arr, int startIdx){
        for(int num : list){
            arr[startIdx++] = num;
        }
    }

    static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int pos = partition(arr, left, right);

            quickSort(arr, left, pos-1);
            quickSort(arr, pos+1, right);

            printArray(arr, left, right);
        }
    }

    private static void printArray(int[] arr, int left, int right) {
        for(int i=left; i<=right; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(arr, 0, n-1);
    }
}
