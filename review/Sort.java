public class Sort {
    /* 
        move the local max to the rigth side, the smaller element eventually
        bubble up
    */
    public void bubbleSort(int[] arr){
        if(arr.length == 1) return;
        for(int i = 0; i < arr.length - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < arr.length - 1 - i; j ++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j + 1, j);
                    swapped = true;
                }
            }
            if(!swapped){
                return;
            }
        }
    }


    /* 
        Selection sort, find lcoal smallest element  in the window (dynamic) and swap with the front element
    */
    public void selectionSort(int[] arr){
        
        for(int i = 0; i < arr.length -1; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }


    /*  merge sort, split, solve and merge */

    public void mergeSort(int[] arr, int l, int r){
        int mid = (l + r)/2;
        if(l < r){
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
        
    }

    public void merge(int[] arr, int l, int mid, int r){
        int p1 = l, p2 = mid + 1, p3 = 0;
        int[] temp = new int[r - l + 1];
        while(p1 <= mid && p2 <= r){
            if (arr[p1] < arr[p2]){
                temp[p3++] = arr[p1++];
            }else{
                temp[p3++] = arr[p2++];
            }
        }
        while(p1 <= mid){
            temp[p3++] = arr[p1++];
        }

        while(p2 <= r){
            temp[p3++] = arr[p2++];
        }
        p3--;
        while(p3 >= 0){
            arr[r--] = temp[p3--];
        }
    }

    /* 
        quick Sort: choose a pivot, move all element < pivot to pivot's left
        and all element >= pivot to pivot's right
    */
    public void quickSort(int[] arr, int l, int r){
        if(l < r){
            int index = partition(arr, l,  r);
            quickSort(arr, l, index - 1);
            quickSort(arr, index + 1, r);
        }

    }

    public int partition(int[] arr, int low, int high){
        // choose most left element as pivot
        int pivot = arr[high], i= low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i, j);
            }
        }
        swap(arr, i+1, high);
        return i + 1;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        Sort sort  = new Sort();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        int[] arr1 = new int[]{10, 9, 8, 7, 6, 5, 4, 4, 23};
        sort.quickSort(arr1, 0 , arr1.length - 1);   
        Printer.printArray(arr1);
    }
}
