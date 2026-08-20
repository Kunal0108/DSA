class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int num : nums1){
             set1.add(num);
        }

        for (int num : nums2){
             set2.add(num);
        }

        for (int num : nums3){
             set3.add(num);
        }

        Set<Integer> all = new HashSet<>();
        all.addAll(set1);
        all.addAll(set2);
        all.addAll(set3);

        List<Integer> result = new ArrayList<>();

        for(int num : all){
            int count = 0;

            if(set1.contains(num)) count++;
            if(set2.contains(num)) count++;
            if(set3.contains(num)) count++;

            if(count >= 2) {
                result.add(num);
            }
        }

        return result;


    }
}