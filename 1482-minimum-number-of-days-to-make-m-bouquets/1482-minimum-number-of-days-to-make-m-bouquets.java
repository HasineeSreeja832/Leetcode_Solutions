class Solution {
    private boolean poss(int[] bloomDay,int day,int m,int k){
        int n=bloomDay.length;
        int ct=0;
        int boq=0;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                ct++;
            }
            else{
                boq+=(ct/k);
                ct=0;
            }
        }
        boq+=(ct/k);
        return boq>=m; 
    }
    public int minDays(int[] bloomDay, int m, int k) {
         int n=bloomDay.length;
         if(n<m*k) return -1;
         int ans=-1;
         int low=Arrays.stream(bloomDay).min().getAsInt();
         int high=Arrays.stream(bloomDay).max().getAsInt();
         while(low<=high){
            int mid=(low+high)/2;
            if(poss(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
         }
         return ans;
    }
}