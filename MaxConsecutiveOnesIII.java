package misc5;

public class MaxConsecutiveOnesIII {
	//Time Complexity : O(n), where n is length of nums array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int longestOnes(int[] nums, int k) {
		// null
		if(nums == null || nums.length == 0)
			return 0;

		int low = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 0)
				k--;
			if(k < 0) {
				if(nums[low] == 0)
					k++;
				low++;
			}
		}

		return nums.length - low;
	}
}
