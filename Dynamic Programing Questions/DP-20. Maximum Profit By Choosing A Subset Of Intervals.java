// GFG Problem Link: https://practice.geeksforgeeks.org/problems/649205908e04ac00f303626fa845261318adfa8f/1


class Solution {
    public static int maximum_profit(int n, int[][] intervals) {
        
        // Here treemap is similar to our dp array
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        // Sorting according to their end time
        Arrays.sort(intervals, (a, b)->(a[1] - b[1]));
        
        tm.put(0, 0);
        
        for(int interval[] : intervals){
            // Profit from biggest index which is smaller than current index
            int prevProfit = tm.floorEntry(interval[0]).getValue();
            
            int currProfit = interval[2] + prevProfit;
            
            // previous highest profit
            int prevMaxProfit = tm.lastEntry().getValue();
            
            // if our previous profit is less than current profit we update the value
            if(prevMaxProfit < currProfit){
                tm.put(interval[1], currProfit);
            }
        }
        
        return tm.lastEntry().getValue();
    }
}
