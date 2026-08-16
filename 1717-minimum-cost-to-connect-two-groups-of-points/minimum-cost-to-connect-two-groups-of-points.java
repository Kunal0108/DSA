class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size();
        int size2 = cost.get(0).size();

        int totalMasks = 1 << size2;

        int[][] dp = new int[size1 + 1][totalMasks];

        for(int i = 0; i <= size1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        dp[0][0] = 0;

        for(int i = 0; i < size1; i++) {
            for(int mask = 0; mask < totalMasks; mask++) {
                for(int j = 0; j < size2; j++) {
                    int newMask = mask | (1 << j);

                    dp[i + 1][newMask] = Math.min(dp[i + 1][newMask], dp[i][mask] + cost.get(i).get(j));
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int mask = 0; mask < totalMasks; mask++) {

            int currentCost = dp[size1][mask];

            for(int j = 0; j < size2; j++) {

                if((mask & (1 << j)) == 0) {

                    int minCost = Integer.MAX_VALUE;

                    for(int i = 0; i < size1; i++) {
                        minCost = Math.min(minCost, cost.get(i).get(j));
                    }

                    currentCost += minCost;
                }
            }

            answer = Math.min(answer, currentCost);

        }

        return answer;
    }
}