class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroes = 0;
        int maxLength = 0;

        for(int right = 0; right < nums.length; right++) {

            //Add the new element to our window
            if(nums[right] == 0) {
                zeroes++;
            }

            //Too many zeroes -> shrink the window
            while(zeroes > k) {
                if(nums[left] == 0) {
                    zeroes--; 
                }

                left++;
            }

            //Current window is valid
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}