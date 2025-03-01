package dsa.solutions.maths.numberTheory;
import java.util.*;
public class SieveOfEratosthenes
{
    static final int N = (int)(1e5);
    static boolean [] isPrime = new boolean[N+1];

    private static void preComputePrimes(){
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false; // 0 and 1 are neither prime nor composite

        for(int i=2; i<=N ; i++){
            if(isPrime[i]){
                //if i is prime it's multiples are not prime
                for(int j=i*2 ; j<=N ; j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }

    private static void preComputePrimesOptimized(){
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false; // 0 and 1 are neither prime nor composite

        //i will run only upto sqRoot(n)
        for(int i=2; i*i<=N ; i++){
            if(isPrime[i]){
                //if i is prime it's multiples are not prime
                for(int j=i*2 ; j<=N ; j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        preComputePrimesOptimized(); //Sieve of Eratosthenes
        for(int i = 2 ; i<=200 ; i++){
            System.out.println(i + " => " + isPrime[i]);
        }
    }
}

