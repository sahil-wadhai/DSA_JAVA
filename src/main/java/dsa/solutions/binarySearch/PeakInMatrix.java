package dsa.solutions.binarySearch;

public class PeakInMatrix{
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int midCol = left + (right - left) / 2;
            int maxRow = 0;

            // Find the row with the maximum value in the mid column
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            // Check left and right neighbors
            boolean leftIsSmaller = (midCol == 0 || mat[maxRow][midCol] > mat[maxRow][midCol - 1]);
            boolean rightIsSmaller = (midCol == n - 1 || mat[maxRow][midCol] > mat[maxRow][midCol + 1]);

            if (leftIsSmaller && rightIsSmaller) {
                return new int[]{maxRow, midCol}; // Found a peak
            } else if (midCol > 0 && mat[maxRow][midCol - 1] > mat[maxRow][midCol]) {
                right = midCol - 1; // Move left
            } else {
                left = midCol + 1; // Move right
            }
        }

        return new int[]{-1, -1};
    }
}

/*
Steps:
    1) Binary Search on Columns → Start with midCol = (left + right) / 2.

    2) Find Max in Mid Column → Identify the row (maxRow) with the largest value in midCol.

    3) Check Left & Right Neighbors:

        If both neighbors (left & right) are smaller → Found Peak!

        If left neighbor is larger → Move left.

        If right neighbor is larger → Move right.

    4) Repeat Until Peak is Found → Search space reduces by half each step (O(mlog n)).
*/