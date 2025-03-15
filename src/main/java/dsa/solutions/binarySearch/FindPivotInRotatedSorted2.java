package dsa.solutions.binarySearch;

import java.util.Arrays;
/*
    Find largest element in Rotated Sorted Array (some elements are duplicate)
*/
public class FindPivotInRotatedSorted2 {
    static int findPivot(int [] arr){
        int n = arr.length;

        int start = 0;
        int end = n-1;

        while (start<end){
            int mid = start + (end-start)/2;

            if( mid<n-1 && arr[mid] > arr[mid+1] ) return mid;
            if( mid>0 && arr[mid-1] > arr[mid]) return mid-1;


            //handling edge case where arr[start]==arr[mid]==arr[end]
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                if( start<n-1 && arr[start]>arr[start+1] ){
                    return start;
                }else{
                    start++;
                }
                if( end>0 && arr[end-1]>arr[end] ){
                    return end-1;
                }else{
                    end--;
                }
            }

            else if( arr[start] <= arr[mid]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return n-1;
    }

    public static void main(String[] args) {
        int[] arr ={1,1,1,1,1,1,1,2,1,1};

        int pivotInd = findPivot(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("pivot element index in array : " + pivotInd);
    }
}
