class Solution {
    private int day(int[] weights,int cap,int days){
        int d=1;
        int load=0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]<=cap){
                load+=weights[i];
            }
            else{
                d+=1;
                load=weights[i];
            }
        }
        return d;
    }
    public int shipWithinDays(int[] weights, int days) {
         int low = 0, high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int d=day(weights,mid,days);
            if(d<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}