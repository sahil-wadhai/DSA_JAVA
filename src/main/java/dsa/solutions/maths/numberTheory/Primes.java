package dsa.solutions.maths.numberTheory;

import java.util.*;
public class Primes{
    static boolean isPrime(int n){
        for(int i = 2; i<n ; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    //run loop upto sq.root(n)
    static boolean isPrimeOptimized(int n){
        for(int i=2 ; i*i<=n ; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    static List<Integer> primeFactorization(int n){
        List<Integer> primeFactors = new ArrayList<>();
        /*
            principle of prime factorization:
            - excluding 1, lowest factor of any composite number is a prime number
        */
        for(int i=2; i<=n ; i++){
            while(n%i==0){
                primeFactors.add(i);
                n = n/i;
            }
        }
        return primeFactors;
    }
    static List<Integer> primeFactorizationOptimized(int n){
        List<Integer> primeFactors = new ArrayList<>();
        /*
            principle of prime factorization:
            - excluding 1, lowest factor of any composite number is a prime number
            - for every composite number n, there exists a prime number less than sq root(n);
        */
        for(int i=2; i*i<=n ; i++){
            while(n%i==0){
                primeFactors.add(i);
                n = n/i;
            }
        }
        if(n>1){
            //for number with no perfect square root
            //it means a prime number is remaining at last
            primeFactors.add(n);
        }
        return primeFactors;
    }
    public static void main(String[] args) {
        int n = 36;
        System.out.println("n: "+n);
        System.out.println("is prime? : "+isPrimeOptimized(n));
        System.out.println("Prime factorization: "+primeFactorizationOptimized(n));
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
