class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())   return false;
        int[] mapst=new int[256];
        int[] mapts=new int[256];
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(mapst[ch1]!=mapts[ch2]) return false;
           mapst[ch1]=i+1;
           mapts[ch2]=i+1;
        }
        return true;
    }
}