class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        
        int ans = 0;
        
        for(int i = 0; i<boxTypes.length; i++){
            if(truckSize==0)
                break;
            else if(truckSize > boxTypes[i][0]){
                ans += boxTypes[i][1]*boxTypes[i][0];
                truckSize -= boxTypes[i][0];
            }
            else{
                ans += truckSize*boxTypes[i][1];
                truckSize = 0;
            }
        }
        return ans;        
    }
}
