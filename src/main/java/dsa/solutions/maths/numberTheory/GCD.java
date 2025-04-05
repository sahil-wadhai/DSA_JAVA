package dsa.solutions.maths.numberTheory;


public class GCD{

    //euclidean algorithm
    public static int findGCDRec(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int num1 = 60, num2 = 36;
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + findGCD(num1, num2));
    }
}

/*
    - GCD(a, b) = GCD(b, a % b).
      This is the heart of the Euclidean Algorithm, and it's surprisingly simple once you get the idea.
      GCD of two numbers is the biggest number that can divide both of them.

      => If a number divides both a and b,
         it will also divide the remainder, which is a % b.

      And the opposite is also true:
      If a number divides b and a % b,
      it will also divide a.
      So the set of common divisors of (a, b) is the same as the set of common divisors of (b, a % b).

      Example to see it happen
      Let’s say:

    a = 60

    b = 36

    a % b = 24

    - Now:

    Divisors of 60: 1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60

    Divisors of 36: 1, 2, 3, 4, 6, 9, 12, 18, 36

    Common divisors: 1, 2, 3, 4, 6, 12 → so GCD = 12

    - Now check:

    GCD(36, 24) → also 12

    GCD(24, 12) → still 12

    GCD(12, 0) → finally 12

*/




