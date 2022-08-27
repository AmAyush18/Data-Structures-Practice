//Problem Link: https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

class pair{
    double ratio;
    int wt;
    
    pair(double r, int w){
        this.ratio = r;
        this.wt = w;
    }
}

class compareRatio implements Comparator<pair>{
    @Override
    public int compare(pair p1, pair p2){
        if(p2.ratio - p1.ratio < 0)
            return -1; 
        if(p2.ratio - p1.ratio > 0)
            return 1;
        
        return p2.wt - p1.wt;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        pair[] p = new pair[n];
        
        for(int i = 0; i < n; i++){
            double ratio = (1.0*arr[i].value)/arr[i].weight;
            
            p[i] = new pair(ratio, arr[i].weight);
        }
        
        Arrays.sort(p, new compareRatio());
        
        double ans = 0.0;
        
        for(int i = 0; i<n; i++){
            if(W==0){
                break;
            }
            if(p[i].wt < W){
                ans += p[i].wt*p[i].ratio;
                W -= p[i].wt;
            }
            else{
                ans += W*p[i].ratio;
                W = 0;
            }
        }
        
        return ans;
    }
}
