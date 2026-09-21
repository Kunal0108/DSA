class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        for(int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            windowCount[s.charAt(right) - 'a']++;

            if(right - left + 1 > p.length()) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }

            if(right - left + 1 == p.length()) {
                if(Arrays.equals(pCount, windowCount)) {
                    result.add(left);
                }
            }
        }

        return result;
    }
}