package dsa.solutions.binarySearch;
import java.util.*;

//https://www.naukri.com/code360/problems/allocate-books_1090540

public class BookAllocation{
    private static int findMax(ArrayList<Integer> arr){
        return Collections.max(arr);
    }

    private static int findTotalSum(ArrayList<Integer> arr){
        int total = 0;
        for(int x:arr){
            total += x;
        }
        return total;
    }

    private static int countStudents(ArrayList<Integer> arr, int xPages){
        int count = 1;
        int pagesAssigned = 0;
        for(int i = 0 ; i<arr.size() ; i++){
            if(pagesAssigned + arr.get(i) <= xPages){
                pagesAssigned += arr.get(i);
            }else{
                pagesAssigned = arr.get(i);
                count++;
            }
        }
        return count;
    }

    public static int findPagesBinarySearch(ArrayList<Integer> arr, int n, int m) {
        if(n<m){
            //number of books is less than students
            return -1;
        }

        int start = findMax(arr);
        int end = findTotalSum(arr);
        if(n==m)return start;

        int ans = -1;
        while(start<=end){

            int mid = start + (end-start)/2;
            int count = countStudents(arr,mid);

            if(count<=m){
                //the value mid is one of the possible answers.
                ans = mid;
                //But we want the minimum value.
                //So, we will eliminate the right half and consider the left half
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

    public static int findPagesLinearSearch(ArrayList<Integer> arr, int n, int m) {
        if(n<m){
            //number of books is less than students
            return -1;
        }

        int start = findMax(arr);
        int end = findTotalSum(arr);

        for(int i=start; i<=end; i++){
            if(countStudents(arr,i)==m){
                return i;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int m = 4;
        int n = arr.size();

        System.out.println("arr: "+ arr + ", m: " + m);
        System.out.println("Max number of pages assigned to a student: "+findPagesBinarySearch(arr,n,m));
    }
}
