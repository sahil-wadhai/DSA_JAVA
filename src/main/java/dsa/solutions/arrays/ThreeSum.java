package dsa.solutions.arrays;
import java.util.*;

public class ThreeSum{
    //Optimized O(n**2)
    static List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++){

            // Skip duplicate elements for `i`
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i+1;
            int k = n-1;
            while(j<k){

                int sum = nums[i]+nums[j]+nums[k];

                if(sum==0){
                    List<Integer> ans = Arrays.asList(nums[i],nums[j],nums[k]);
                    res.add(ans);
                    j++;
                    k--;
                    // Move `j` and `k`, skipping duplicates
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;

                }else if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }
            }
        }
        return res;
    }

    //O(n**2) (slower due to HashSet for duplicate removal)
    // in the worst case, it may take O(n**2 * nlogn) time.
    private static List<List<Integer>> threeSumBetter(int[] nums) {
        int n = nums.length;
        int sum = 0;

        List<List<Integer>> res = new ArrayList<>(); //final response
        Set<Set<Integer>> resSet = new HashSet<>(); // to ensure every entry in res is unique

        for(int i=0; i<n; i++){
            Set<Integer> numSet = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int third = -(nums[i]+nums[j]);
                if(numSet.contains(third)){
                    List<Integer> ans = Arrays.asList(nums[i],nums[j],third);
                    Set<Integer> ansSet = new HashSet<>(ans);
                    if(!resSet.contains(ansSet)) res.add(ans);
                    resSet.add(ansSet);
                }
                numSet.add(nums[j]);
            }
        }
        return res;
    }

    //O(n**3)
    private static List<List<Integer>> threeSumBrute(int[] nums) {
        int n = nums.length;
        int sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        Set<Set<Integer>> resSet = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> ans = Arrays.asList(nums[i],nums[j],nums[k]);
                        Set<Integer> ansSet = new HashSet<>(ans);

                        if(!resSet.contains(ansSet)) res.add(ans);

                        resSet.add(ansSet);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        System.out.println("nums: "+Arrays.toString(nums));
        System.out.println("res: "+threeSum(nums));
    }
}
