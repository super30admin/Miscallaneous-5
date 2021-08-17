public class FindConsecutiveOnes {


    //Sliding Window technique.
    //If it is not a valid sub array reduce the window - By increasing the left pointer
    //If the elements which is going out of the array is 0, then increasing the k value.
    //At the end the difference between left and right pointer will form the valid sub array.
    // TC: O(N) - Where N is the number of elements in the array.
    // SC: O(1) - Not using any extra space.
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int leftPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            int incoming = nums[i];
            int outgoing = nums[leftPointer];

            if (incoming == 0) {
                k--;
            }

            if (k < 0) { // Not Valid array
                if (outgoing == 0) { // Checking if the outgoind is zero,
                    k++;
                }
                leftPointer++;
            }
        }
        return nums.length - leftPointer;
    }

    public static void main(String[] args) {
        FindConsecutiveOnes findConsecutiveOnes = new FindConsecutiveOnes();
        int result = findConsecutiveOnes.longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2);
        System.out.println("The result:" + result);
    }
}