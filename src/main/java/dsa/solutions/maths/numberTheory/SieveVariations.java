package dsa.solutions.maths.numberTheory;
import java.util.*;
/*
    [1] Highest prime factor and lowest prime factor of a number
    [2] Prime factorization using lowest prime factor sieve
    [3] Divisors
*/

public class SieveVariations {
    private static final int N = (int)1e5;
    static boolean [] isPrime = new boolean[N+1];
    static int [] lp = new int [N+1]; //lowest prime factor of i
    static int [] hp = new int[N+1]; //highest prime factor of i

    static void computeLowestHighest(){
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;
        lp[1]=hp[1]=1;
        for(int i=2; i<=N ; i++){
            if(isPrime[i]){
                lp[i] = i;
                hp[i] = i;
                for(int j=i*2 ; j<=N ; j += i){
                    isPrime[j] = false;
                    hp[j] = i; //last prime marking j is highest prime factor for j
                    if(lp[j]==0) lp[j] = i;// first prime marking j is lowest prime factor for j
                }
            }
        }
    }

    static List<Integer> primeFactorization(int num){
        List<Integer> primeFactors = new ArrayList<>();
        /*
            principle of prime factorization:
            - excluding 1, lowest factor of any composite number is a prime number
        */
        while(num>1){
            int lowestPrime = lp[num];
            primeFactors.add(lowestPrime);

            num = num/lowestPrime;
        }
        return primeFactors;
    }

    //Driver code
    public static void main(String[] args) {
        computeLowestHighest();

        int num =104;
        System.out.println("num: "+num);
        System.out.println("lowest prime factor: "+lp[num]);
        System.out.println("highest prime factor: "+hp[num]);
        System.out.println("Prime factorization: "+primeFactorization(num));
    }
}
