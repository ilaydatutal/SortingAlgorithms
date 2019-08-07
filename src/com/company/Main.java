package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int arr[] = {0, -3, 4,12, 6, 5, 77, 1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length-1)));
       // mergeSort(arr, 0, arr.length - 1);
       //System.out.println(Arrays.toString(arr));

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
    /*public static int partition(int[] arr, int low, int high){
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
    */



    public static int partition(int[] arr, int low, int high){
        int temp;
        int pivot = arr[low];
        int i=low, j=high;

        while(i <= j){
            while(i <= high && arr[i] <= pivot){
                i++;
            }
            while(j >= low && arr[j] >= pivot){
                j--;
            }
            if (i <= high && j >= low) {

                if (i < j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                } else {
                    temp = arr[j];
                    arr[j] = arr[low];
                    arr[low] = temp;
                }

            }

        }


        return j;

    }


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
        int size1 = m - l + 1;
        int size2 = r - m;
        int L[] = new int[size1];
        int R[] = new int[size2];

        for (int i=0; i<size1; i++)
            L[i] = arr[l + i];
        for (int j=0; j<size2; j++)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < size1 && j < size2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < size1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < size2){
            arr[k] = R[j];
            j++;
            k++;
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





}
