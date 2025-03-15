package dsa.solutions.binarySearch;

import java.util.Arrays;

/*
    Find largest element in Rotated Sorted Array (all unique elements)
*/
public class FindPivotInRotatedSorted1 {
        static int findPivot(int [] arr){
            int n = arr.length;

            int start = 0;
            int end = n-1;

            while (start<end){
                int mid = start + (end-start)/2;

                if( mid<n-1 && arr[mid] > arr[mid+1] ) return mid;
                if( mid>0 && arr[mid-1] > arr[mid]) return mid-1;

                if( arr[start] <= arr[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            return n-1;
        }

        public static void main(String[] args) {
            int[] arr = {4, 5, 6, 7, 0, 1};

            int pivotInd = findPivot(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println("pivot element index in array : " + pivotInd);
        }
}
