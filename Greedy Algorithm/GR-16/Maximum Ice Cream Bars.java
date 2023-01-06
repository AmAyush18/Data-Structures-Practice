// LeetCode Problem Link: https://leetcode.com/problems/maximum-ice-cream-bars/description/

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // basically here we need to think greedily
        // we ought to buy those ice-creams first which are cheaper

        // So let's sort array according to cost prices
        Arrays.sort(costs);

        int count = 0;

        // check for all costs
        for(int cost : costs){
            // if we have enough coins to buy this ice-cream
            if(cost <= coins){
                count++;
                // now cost is paid from coins 
                // so update coins
                coins -= cost;
                // if coins get to zero break
                // as we can't but any coins further
                if(coins == 0) break;
            }
        }

        return count;
    }
}
