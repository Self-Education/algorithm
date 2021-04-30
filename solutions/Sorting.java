public class Sorting {
    /*
     * Bubble sort: move the local Max value to the end of the array in the each
     * iteration
     */
    public int[] bubbleSort(int[] arr) {
        if (arr.length <= 1)
            return arr;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swaped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaped = true;
                }
            }

            if (!swaped)
                break;
        }
        return arr;
    }

    /*
     * Selection sort: find the smallest value in the current window in each
     * interation swap the smallest value with the front element
     */
    public int[] selectSort(int[] arr) {
        if (arr.length <= 1)
            return arr;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = minIndex(arr, i, n - 1);
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
        return arr;

    }

    /*
     * Merge sort: split array into sub array, sort subarray then merge subarrays
     */
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }
        for (int n = l; n <= r; n++) {
            arr[n] = temp[n - l];
        }
    }

    /*
     * Quick Sort: randomly choose a pivot, place the pivot to the position it
     * should be at by move all element <= pivot to its left and all element > pivot
     * to its right
     */
    public void quickSort(int[] arr, int start, int end) {

        // pivot is the index of the elmenet which is at its right position
        int pivot = partition(arr, start, end);

        // now we need to sort arr[0, pivot - 1] and arr[pivot + 1, len]
        if (pivot - 1 >= start) {
            quickSort(arr, start, pivot - 1);
        }
        if (pivot + 1 <= end) {
            quickSort(arr, pivot + 1, end);
        }
    }

    public int partition(int[] arr, int l, int r) {
        // use the middle point as the pivot

        int pivot = arr[r];
        int w = l;
        for (int j = l; j <= r; j++) {
            if (arr[j] < pivot) {
                swap(arr, w, j);
                w++;
            }
        }
        swap(arr, w, r);
        return w;
    }

    /*
     * main function
     */
    public static void main(String[] args) {
        Sorting sort = new Sorting();
        int[] arr = new int[] { 5, 1, 4, 8, 2 };
        int[] arr1 = new int[] { 6, 3, 4, 7, 9, 2, 5 };
        int[] arr2 = new int[] { -1, 2, -8, 2, -1, -10 };
        sort.quickSort(arr2, 0, arr2.length - 1);
        Printer.printArray(arr2);
    }

    /*
     * utility function
     */
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int minIndex(int[] arr, int start, int end) {
        if (start > end)
            return -1;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
