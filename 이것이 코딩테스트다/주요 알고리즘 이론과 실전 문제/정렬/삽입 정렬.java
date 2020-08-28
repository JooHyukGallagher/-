public class Main {
    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        int i, j;
        for (i = 1; i < array.length; i++) {
            int value = array[i];
            for (j = i-1; j >= 0; j--) {
                if (value < array[j]) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            j++;
            array[j] = value;
        }

        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
