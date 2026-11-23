class Solution {
    private long sumD(int[] nums,int div){
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=(num+div-1)/div;
     
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int high=Arrays.stream(nums).max().getAsInt();
        int low=1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            long sum=sumD(nums,mid);
            if(sum<=threshold){
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