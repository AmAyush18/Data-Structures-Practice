import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        printArr(arr);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] a = new int[high - low + 1];
        int k = 0;
        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                a[k++] = arr[i];
                i++;
            } else {
                a[k++] = arr[j];
                j++;
            }
        }

        while (i <= mid) {
            a[k++] = arr[i++];
        }

        while (j <= high) {
            a[k++] = arr[j++];
        }

        k = 0;

        for (int idx = low; idx <= high; idx++) {
            arr[idx] = a[k++];
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
