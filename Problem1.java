/*
Find Consecutive Ones
approach: we can see that to reduce nested arrays, we can do 2 pointers and move left pointer to the place where our k=0
time: O(2n)
space: O(1)
 */
public class Problem1 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, max = 0;
        for (int i=0;i< nums.length;i++) {
            if (nums[i]==0) k--;
            if (k<0) {
                while (left<=i && nums[left]==1) {
                    left++;
                }
                left++;k++;
            }
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}
