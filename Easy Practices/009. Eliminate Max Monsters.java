// https://leetcode.com/problems/eliminate-maximum-number-of-monsters

class Solution {
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] timeToReachCity = new int[n];

        for (int i = 0; i < n; i++) {
            timeToReachCity[i] = (dist[i] + speed[i] - 1) / speed[i];
        }

        Arrays.sort(timeToReachCity);

        for (int i = 0; i < n; i++) {
            if (timeToReachCity[i] <= i) {
                return i;
            }
        }

        return n;
    }
}
