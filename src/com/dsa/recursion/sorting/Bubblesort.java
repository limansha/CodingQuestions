package com.dsa.recursion.sorting;

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int arr[] = {4,5,6,73,2,1};
        int n = arr.length-1;
        bubblesort(arr,n,0,n); //row = 5 col = 1 //follows triangle pattern 
        System.out.println(Arrays.toString(arr));
        /*
        0123
        ****
        *** - largest elemnt will be at 3 idx so we sort 0-2
        **
        *
        */
        int arr1[] = {4,5,6,73,2,1};
        selectionsort(arr,n,0,0); //lets take max element as element at idx zero i.e arr[0] 
        System.out.println(Arrays.toString(arr1));
    }

    private static void bubblesort(int[] arr, int row, int col, int n) {
        if(row == 0){
            return;
        }
        if(col < row){
            if(arr[col] > arr[col+1]){
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubblesort(arr, row, col+1, n);//it comes to else block once the largest element sits in last idex i.e row 
        }
        else{
            bubblesort(arr, row-1, 0, n); //after putting the greatest to end we need to sort arr from o to again row-1
        }
    }
    
    private static void selectionsort(int[] arr, int row, int col, int max) {
        //correct selection sort
        //max variable is the idx at which max element lies
        //find the element max from 0 to n-1 and place it at n-1 pos and decrease the arr size by 1
        if(row == 0){
            return;
        }
        if(col < row){
            if(arr[col] > arr[max]){
                selectionsort(arr, row, col+1,  col);
            }
            else{
                selectionsort(arr, row, col+1,  max);
            }
        }
        else{
            int temp = arr[max];
            arr[max] = arr[row];
            arr[row] = temp;
            selectionsort(arr, row-1, col,  0);
        }
    }
}
