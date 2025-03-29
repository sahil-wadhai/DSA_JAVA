package dsa.solutions.binarySearch;

public class FindNthRoot {

    //required ans will lie between 1 to m
    static int nthRoot(int n, int m) {
        int start = 1;
        int end = m;

        while(start<=end){
            int mid = start + (end-start)/2;

            int midN = (int)Math.pow(mid,n);
            if(midN == m){
                return mid;
            }else if(midN<m){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    static double precisionNthRoot(int n, int m, int precision){
        double start = 1;
        double end = m;
        double precisionValue = Math.pow(10,-(precision+1)); //if we want precision of 5 : 10e-6

        while(end-start > precisionValue){
            double mid = start + (end-start)/2;

            double midN = Math.pow(mid,n);
            if(Math.abs(midN-m) < precisionValue){
                return mid; // the loop terminates when the difference is small enough.
            }else if(midN<m){
                start = mid;
            }else{
                end = mid;
            }
        }
        return start; // Returning the approximate root
    }


    public static void main(String[] args) {
        int n = 3;
        int m = 28;

        System.out.println("n: "+n + ", m: " + m);
        System.out.println("perfect: " + nthRoot(n,m));

        int precision = 5;
        String format = "With precision of %d: %." + precision + "f%n"; // Dynamic precision format
        System.out.printf(format , precision, precisionNthRoot(n,m,precision));
    }
}
