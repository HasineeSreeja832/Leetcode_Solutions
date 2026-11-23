class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int low=0;
        int high=col-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int maxrow=0;
            for(int i=0;i<row;i++){
                if(mat[i][mid]>mat[maxrow][mid]){
                    maxrow=i;
                }
            }
            int leftval;
            if(mid-1>=0){
                leftval=mat[maxrow][mid-1];
            }
            else{
                leftval=-1;
            }
            int rightval;
            if(mid+1<col){
                rightval=mat[maxrow][mid+1];
            }
            else{
                rightval=-1;
            }
            if(mat[maxrow][mid]>leftval && mat[maxrow][mid]>rightval){
                return new int[]{maxrow,mid};
            }
            else if(mat[maxrow][mid]<leftval){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};    
    }
}