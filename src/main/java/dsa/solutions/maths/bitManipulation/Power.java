package dsa.solutions.maths.bitManipulation;

public class Power {

    static long pow(int base , int power){
        /*
          power can be represented in  addition of power of 2's , ex - 5 = (2^0) + (2^2)
          if base = 3 and power = 5
          3 power '101' (101 in binary => 5 in decimal)
            0    2
           2    2
          3  * 3  =  3 * 81 = 243
        */
        long ans = 1L;
        int p = power;
        while(p != 0){
            int bit = p&1;
            if(bit == 1){
                ans = ans * base;
            }
            base = base*base;
            p = p>>1;
        }
        return ans;
    }

    //Driver Code
    public static void main(String[] args){
        int base = 3;
        int power = 5;
        long ans = pow(base,power);

        System.out.println(ans);
    }
}

