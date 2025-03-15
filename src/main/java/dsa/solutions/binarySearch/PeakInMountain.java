package dsa.solutions.binarySearch;

import java.util.Arrays;

public class PeakInMountain{

    static int findPeakElement(int[] arr){
        int n = arr.length;
        int start = 0 , end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;

            if(mid>0 && mid<n-1 && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }

            //mid is in increasing part of array
            if( mid<n-1 && arr[mid] < arr[mid+1]){
                start = mid+1;
            }
            else{
                // arr[mid] > arr[mid+1] , mid is in decreasing part of array
                end = mid-1;
            }
        }
        return -1; //dummy return (if array is not mountain array)
    }

    public static void main(String[] args){
        int [] arr = {3,4,5,6,2,1};
        System.out.println(Arrays.toString(arr));
        int ans = findPeakElement(arr);
        System.out.println("Peak Element = " + arr[ans]);
        System.out.println("Peak Index = " + ans);
    }
}
