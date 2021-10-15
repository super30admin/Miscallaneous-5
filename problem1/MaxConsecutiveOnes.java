// Time Complexity : O(n), n -> Number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class MaxConsecutiveOnes {
	public int longestOnes(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;

		if (k >= n) {
			return n;
		}

		int left = 0;
		int right = 0;

		int cnt = 0;

		while (right < n) {
			if (nums[right] == 0) {
				cnt++;
			}

			if (cnt > k) {
				if (nums[left] == 0) {
					cnt--;
				}
				left++;
			}
			right++;
		}

		return right - left;
	}

	public static void main(String[] args) {
		MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
		int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;

		System.out.println(
				"Maximum number of consecutive ones if we can flip \'" + k + "\' 0's: " + obj.longestOnes(nums, k));
	}

}
