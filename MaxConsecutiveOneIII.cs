using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class MaxConsecutiveOneIII
    {
        /*
         * T.C: O(n) where n is no of element
         * S.C: O(1) no extra space used
         * 
         */
        public int LongestOnes(int[] nums, int k)
        {
            if (nums == null || nums.Length == 0) return 0;

            int left = 0;

            for (int i = 0; i < nums.Length; i++)
            {
                if (nums[i] == 0)
                {
                    k--;
                }

                if (k < 0)
                {
                    if (nums[left] == 0)
                    {
                        k++;
                    }
                    left++;
                }
            }

            return nums.Length - left;

        }
    }
}
