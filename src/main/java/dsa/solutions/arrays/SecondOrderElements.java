package dsa.solutions.arrays;

import java.util.Arrays;

public class SecondOrderElements {

    static int[] getSecondOrders(int [] arr){
        int large = Integer.MIN_VALUE;
        int secondLarge = large;

        int small = Integer.MAX_VALUE;
        int secondSmall = small;

        for(int e:arr){
            if(e>large){
                secondLarge = large;
                large = e;
            }else if(e>secondLarge){
                secondLarge = e;
            }

            if(e<small){
                secondSmall = small;
                small = e;
            }else if(e<secondSmall){
                secondSmall = e;
            }

        }
        return new int[]{secondSmall,secondLarge};
    }

    //Driver Code
    public static void main(String[] args) {
        int [] arr = { 111, 13, 25, 9, 34, 1 };
        System.out.println(Arrays.toString(arr));
        int [] secondOrderElements = getSecondOrders(arr);
        System.out.println(Arrays.toString(secondOrderElements));
    }
}
