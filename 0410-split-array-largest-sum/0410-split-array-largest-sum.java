class Solution {
    private boolean poss(int[] nums,int cap,int k){
        int parts=1;
        int split=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+split<=cap){
                split+=nums[i];
            }
            else{
                parts++;
                split=nums[i];
                if (parts > k) return false;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
      if(k>nums.length) return -1;
      int ans=-1;
      int low=Integer.MIN_VALUE;
      int high=0;
      for(int n : nums){
        low=Math.max(low,n);
        high+=n;
      }
      while(low<=high){
        int mid=low+(high-low)/2;
        if(poss(nums,mid,k)){
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