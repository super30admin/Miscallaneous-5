//Time Complexity: O(n); where n is length of array.
//Space Complexity: O(1)

public class MaxConsecutiveOnes_III {
	/**Approach: Sliding Window**/	
	public int longestOnes(int[] nums, int k) {
        int n= nums.length;               
        int left =0;        
        for(int i=0; i<n; i++){            
            if(nums[i] == 0) k--;  
            if(k < 0){                
                if(nums[left] == 0) k++; //Outgoing zero from left
                left++;
            }            
        }        
        return n - left; 
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {			
		MaxConsecutiveOnes_III ob  = new MaxConsecutiveOnes_III();
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
								
		System.out.println("Max no. of consecutive 1's after flipping "+k+" zeros are : "+ob.longestOnes(nums, k)); 
	}	
}
