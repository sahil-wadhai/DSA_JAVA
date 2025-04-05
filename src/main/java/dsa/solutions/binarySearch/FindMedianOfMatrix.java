package dsa.solutions.binarySearch;
import java.lang.Math;
import java.util.Arrays;

public class FindMedianOfMatrix{

    private static int findCeil(int [] row, int x){
        int start = 0;
        int end = row.length-1;

        int ans = row.length;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(row[mid]<=x){
                start = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }

    private static int countSmallEqual(int [][] mat, int x){
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        for(int i=0; i<m ; i++){
            count += findCeil(mat[i],x);
        }
        return count;
    }

    static int median(int [][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int reqCount = (m*n)/2;

        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for(int row = 0; row<mat.length; row++){
            start = Math.min(start,mat[row][0]);
            end = Math.max(end,mat[row][n-1]);
        }

        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;

            int count = countSmallEqual(mat,mid);
            if(count<=reqCount){
                start = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] mat = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        System.out.println("Matrix: ");
        for(int [] row:mat){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\nmedian of matrix: "+median(mat));
    }
}
