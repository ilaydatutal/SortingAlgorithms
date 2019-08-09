package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int arr[] = {0, -3, 4,12, 6, 5, 77, 1};
        System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(quickSort(arr, 0, arr.length-1)));


       // mergeSort(arr, 0, arr.length - 1);
       heapSort(arr);


        System.out.println(Arrays.toString(arr));

    }



    public static int[] quickSort(int[] arr, int low, int high){
        int pivotIndex;
        if(low < high)
        {
            pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr,pivotIndex+1, high);
        }

        return arr;
    }
    public static int partition(int[] arr, int low, int high){
         int temp;
        int pivot = arr[high];
        int i = low-1;

        for(int j=low; j<=high-1; j++){
            if(arr[j] <= pivot){
                i++;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;


    }
    /*


    public static int partition(int[] arr, int low, int high) {
        int i = low, j = high;
        int tmp;
        int pivot = arr[(low + high) / 2];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
*/

    public static int [] selectionSort(int[] arr, int size){
        int temp, min;

        for(int i=0; i < size - 1; i++){
            min = arr[0];
            for(int j=i; j < size; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    min = arr[i];
                }
                else{
                    min = arr[i];
                }
            }
        }
        return arr;
    }


    public static int[] bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        return arr;
    }


    public static void merge(int[] arr, int l, int m, int r){

        int[] left = Arrays.copyOfRange(arr, l, m+1);
        int[] right = Arrays.copyOfRange(arr, m+1, r+1);

        int i = 0, j = 0;

        int index = l;
        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                arr[index] = left[i];
                i++;
            }
            else{
                arr[index] = right[j];
                j++;
            }
            index++;
        }
        while (i < left.length){
            arr[index] = left[i];
            i++;
            index++;
        }
        while (j < right.length){
            arr[index] = right[j];
            j++;
            index++;
        }
    }

    public static void mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }




    public static void heapify(int[] arr, int size, int i){

        int indexOfLargest = i;
        int leftChild = 2*i + 1;
        int rightChild = 2*i +2;
        int temp;

        if(leftChild < size && arr[leftChild] > arr[indexOfLargest]){
            indexOfLargest = leftChild;
        }
        if(rightChild < size && arr[rightChild] > arr[indexOfLargest]){
            indexOfLargest = rightChild;
        }
        if(indexOfLargest != i){
            temp = arr[i];
            arr[i] = arr[indexOfLargest];
            arr[indexOfLargest]= temp;

            heapify(arr, arr.length, 0);
        }
    }



    public static void heapSort(int[] arr){
        int currentSize = arr.length;

        // I need to build a max heap first.
        for(int i=0; i < arr.length; i++){
            heapify(arr, arr.length, i);
        }

        while(currentSize > 0){
            int temp = arr[0];
            arr[0] = arr[currentSize-1];
            arr[currentSize-1] = temp;

            currentSize--;

            for(int i=0; i < currentSize; i++){
                heapify(arr, currentSize, i);
            }
        }


    }


}
