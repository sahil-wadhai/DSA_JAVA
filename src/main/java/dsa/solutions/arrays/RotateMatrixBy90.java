package dsa.solutions.arrays;
import java.util.*;
/*
    Brute Force : <=(solved)
    - Initialize new matrix
    - add elements from old to new in required manner
    - i.e, Take the first row of the matrix and put it in the last column of the dummy matrix,
    take the second row of the matrix, and put it in the second last column of the matrix and so.

    optimized :
    - Apply transpose on matrix
    - Reverse each row for clockwise rotation / Reverse each column for anti-clockwise rotation
*/

public class RotateMatrixBy90 {

    static void rotateMatrixBrute(int[][] matrix) {
        int n = matrix.length;
        int [][] res = new int[n][n];

        //Take the first row of the matrix and put it in the last column of the dummy matrix and so on...
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                res[j][n-i-1] = matrix[i][j];
            }
        }

        for(int i=0; i<n ; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }

    //clockwise
    static void rotateMatrixOptimized(int[][] matrix){
        int n = matrix.length;

        //Apply transpose on matrix
        for(int i=0 ; i<n ; i++){
            for(int j = i ; j<n ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //now, reverse each row in matrix
        for(int [] row : matrix){
            int start = 0;
            int end = row.length-1;
            while(start<end){
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;

                start++;
                end--;
            }
        }
    }

    public static void main(String[] args){
        int [][] matrix = {
                {1,2,3} ,
                {4,5,6} ,
                {7,8,9}
        };

        System.out.println("\nInput: ");
        for(int [] row:matrix){
            System.out.println(Arrays.toString(row));
        }

        rotateMatrixOptimized(matrix);

        System.out.println("\nOutput: ");
        for(int [] row:matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}