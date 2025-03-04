package dsa.solutions.arrays;
import java.util.*;

public class SpiralMatrix {
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        int startRow = 0;
        int endRow = m-1;
        int startCol = 0;
        int endCol = n-1;

        while(count<m*n){
            //first row
            for(int i = startCol; i<=endCol && count<m*n ; i++){
                spiral.add(matrix[startRow][i]);
                count++;
            }

            //last col
            for(int i = startRow+1 ; i<=endRow && count<m*n ; i++){
                spiral.add(matrix[i][endCol]);
                count++;
            }

            //last row in reverse
            for(int i = endCol-1; i>=startCol && count<m*n ; i--){
                spiral.add(matrix[endRow][i]);
                count++;
            }

            //first col in reverse
            for(int i= endRow-1 ; i>startRow && count<m*n; i--){
                spiral.add(matrix[i][startCol]);
                count++;
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return spiral;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},
                           {5,6,7,8},
                           {9,10,11,12}};

        for(int [] row : matrix){
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Spiral: "+spiralOrder(matrix));

    }
}

