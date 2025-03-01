package dsa.solutions.maths.numberTheory;

public class CountingTheory {
    /*
        nCr = n! / [r! * (n - r)!]
        nCr(7,3) = (7*6*5*4*3*2*1) / ((3*2*1)*(4*3*2*1);
        i.e, nCr(7,3) = (7*6*5) / (3*2*1)
    */
    static long nCr(int n, int r){
        if(r>n) return 0; // nCr is not defined if r > n

        long res = 1L;
        for(int i=1 ; i<=r ; i++){
            res = ( res * (n-r+i) ) / i ;
        }
        return res;
    }

    /*
        nPr = n! / (n - r)!
        nPr(7,3) = (7*6*5*4*3*2*1) / (4*3*2*1);
        i.e, nCr(7,3) = (7*6*5) / (3*2*1)
    */
    static long nPr(int n, int r) {
        long res = 1L;
        for (int i = 1; i <= r; i++) {
            res = res * (n-r+i);
        }
        return res;
    }

    /*
        Catalan numbers count sequences of pairs
        example: Counting valid sequences of n pairs of () parenthesis
        Cₙ = (1 / (n + 1)) × C(2n, n) = (2n)! / [(n + 1)! n!]
    */
    static long catalan(int n){
        long res = nCr(2*n,n);
        return res/(n+1);
    }
    public static void main(String[] args) {
        int n = 7;
        int r = 3;
        System.out.println("n=" + n + " and r=" + r);
        System.out.println("nCr: "+nCr(n,r));
        System.out.println("nPr: "+nPr(n,r));

        int pairs = 3;
        System.out.println("\nNumber of pairs: " + pairs);
        System.out.printf("Catalan number C(%d): %d", pairs, catalan(pairs));
    }
}

/*
    Addition Principle:
    If there are 'm' ways to do one thing and 'n' ways to do another,
    and these events are mutually exclusive (cannot happen together),
    then the total number of ways to do either one is: 'm+n'
    Example:
    You can travel to work by bus (3 routes) or train (2 routes). The total number of ways to commute is:
    3 + 2 = 5

    Multiplication Principle:
    If there are 'm' ways to do one thing and 'n' ways to do another,
    and both events must happen together, then the total number of ways is: 'm*n'
    Example:
    You have 4 shirts and 3 pants. The number of different outfits you can wear is:
    4 * 3 = 12

    Factorial:
    n! = 1*2*3*4*5*...*n example: 4! = 4*3*2*1 = 24
    It's used to count the number of ways to arrange or order a set of things.
    example: number of ways to arrange 4 books

    calculate nCr and nPr:
    - nCr is used to calculate combinations. nCr = n! / [(n - r)! r!].
    - nCr example : nCr where n=7 and r=5
      If you want to select 5 books from a group of 7 books on a shelf,
      you can use the combination formula to calculate how many ways you can do it.

    - nPr is used to calculate permutations. nPr = n! / (n−r)!
    - nPr = nCr * r!   (select and arrange)
    - nPr example : nPr where n=7 and r=5
      If you want to arrange 5 books from a group of 7 books on a shelf,
      you can use the permutation formula to calculate how many ways you can do it.
*/
