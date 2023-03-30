public class FindConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if(nums==null || n<0) return 0;
        int left = 0;
        int result = 0;
        for(int right=0;right<n;right++){
            if(nums[right]==0) k--;
            if(k<0){
                // move left pointer till you escape a zero
                while(left<=right && nums[left]==1){
                    left++;
                }
                left++;
                k++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}

// TC - O(2n) ~ O(n)

public class FindConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if(nums==null || n<0) return 0;
        int left = 0;
        int result = 0;
        for(int right=0;right<n;right++){
            if(nums[right]==0) k--;
            if(k<0){
                if(nums[left]==0) k++;
                left++;
            }
        }
        return n-left;
    }
}

// TC - O(n)
// SC - O(1)