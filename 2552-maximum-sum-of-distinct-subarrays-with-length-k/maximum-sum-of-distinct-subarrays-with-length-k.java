class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        HashSet<Integer> set = new HashSet<>();

        long sum = 0;
        long maxSum = 0;

        int left = 0;

        for(int right = 0; right < nums.length; right++) {

            //If duplicate exists, remove elements
            //From the left until nums[right] becomes unique
            while(set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            //Add current element
            set.add(nums[right]);
            sum += nums[right];

            //If window is exactly k elements
            if(right - left + 1 == k) {

                maxSum = Math.max(maxSum, sum);

                //Remove left element
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}