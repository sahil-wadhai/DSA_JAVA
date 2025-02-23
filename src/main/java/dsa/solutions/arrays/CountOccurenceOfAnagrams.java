package dsa.solutions.arrays;
import java.util.*;
public class CountOccurenceOfAnagrams {
    static int search(String pat, String txt) {
        Map<Character,Integer> patMap = new HashMap<>();
        Map<Character,Integer> winMap = new HashMap<>();

        for(char ch : pat.toCharArray()){
            patMap.put(ch,patMap.getOrDefault(ch,0)+1);
        }

        int n = txt.length();
        int k = pat.length();
        int count=0;

        for(int i=0,j=0 ; j<n ; j++){
            char ch = txt.charAt(j);
            winMap.put(ch, winMap.getOrDefault(ch,0)+1);

            if(j-i+1==k){
                if(patMap.equals(winMap)){
                    count++;
                }

                char rem = txt.charAt(i);
                i++;

                if(winMap.get(rem)<=1){
                    winMap.remove(rem);
                }else{
                    winMap.put(rem,winMap.get(rem)-1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        //for, orf and ofr appears in the txt, hence answer is 3.

        System.out.println("txt: "+txt);
        System.out.println("pat: "+pat);
        System.out.println("No. of anagrams of pat in txt : "+search(pat,txt));
    }
}
