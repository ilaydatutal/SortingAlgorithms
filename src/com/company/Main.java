package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int arr[] = {0, -3, 4,12, 6, 5, 77, 1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length-1)));
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







}
