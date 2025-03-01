package dsa.solutions.maths.numberTheory;
import java.util.*;
// findDivisors(16) = 1,2,4,8,16
public class Divisors {
    static List<Integer> findDivisors(int n){
        List<Integer> divisors = new ArrayList<>();
        for(int i = 1; i<=n ; i++){
            if(n%i==0){
                divisors.add(i);
            }
        }
        return divisors;
    }

    /*
    findDivisors(16) = 1,2,4,8,16
        1 * 16
        2 * 8
        4 * 4
        8 * 2
        16 * 1

        just run the loop from i=1 to i=Math.sqrt(n) times
        if i divides n :
            then i and n/i are both divisors of n
    */

    static List<Integer> findDivisorsOptimized(int n){
        List<Integer> divisors = new ArrayList<>();
        for(int i = 1; i*i<=n ; i++){
            if(n%i==0){
                divisors.add(i);
                if(n/i != i){
                    divisors.add(n/i);
                }
            }
        }
        return divisors;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(findDivisorsOptimized(n));
    }
}

/*
    #Divisors:

    X is any integer
    X = P1**n1, P2**n2, P3**n3 ...... , P**n
    where Pi => prime number and ni => integer

    - Number of divisors of X = (n1+1) * (n2+1) ....
    - Sum of divisors = (P1**0 + P1**1 + P1**3 + .... + P1**n1) * (P2**0 + P2**1 + P2**3 + .... + P2**n2)

    #Multiples:

    findMultiples(2) = 2, 4, 6, 8, 10, 12, 14, ........, 2*n

    - Number of multiples of x :
    from 1 to 1000 = 1000/x

    -Number of multiples of x and y :
    from 1 to 1000 = 1000/(x*y)
*/