package dsa.solutions.arrays;
import java.util.*;


//same as count sub arrays with sum k
public class CountSubArrWithXorK {

    static int count(List<Integer> A, int B) {

        int n = A.size();
        Map<Integer,Integer> preXor = new HashMap<>();
        int xor = 0; //running xor
        int count = 0;
        for(int i= 0 ; i<n ; i++){
            xor ^= A.get(i);

            if(xor == B) count++;

            int rem = xor ^ B;
            if(preXor.containsKey(rem)){
                //number of reminder means number of subarrays which were required
                count += preXor.get(rem);
            }

            preXor.put( xor , preXor.getOrDefault(xor,0)+1 );
        }
        return count;

    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(4, 2, 2, 6, 4);
        int k = 6;

        System.out.println(A);
        System.out.println("k: "+ k);
        System.out.println("Number of subarrays with xor equals k: "+count(A,k));
    }

}
