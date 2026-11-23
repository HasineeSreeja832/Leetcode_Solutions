class Solution {
    public int romanToInt(String s) {
        int[] val=new int[128];
        val['I']=1;
        val['V']=5;
        val['X']=10;
        val['L']=50;
        val['C']=100;
        val['D']=500;
        val['M']=1000;
        int result=0;
        int prev=0;
        for(int i=s.length()-1;i>=0;i--){
            int curr=val[s.charAt(i)];
            if(curr<prev){
                result-=curr;
            }
            else{
                result+=curr;
            }
            prev=curr;
        }
        return result;
    }
}