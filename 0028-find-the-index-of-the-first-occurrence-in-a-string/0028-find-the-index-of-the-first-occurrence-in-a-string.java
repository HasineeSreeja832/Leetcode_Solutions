class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        int[] lps = new int[m];

        // Build LPS array for needle
        int j = 0;

        for (int i = 1; i < m; i++) {

            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = lps[j - 1];
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        // Search needle inside haystack
        int i = 0;
        j = 0;

        while (i < n) {

            if (haystack.charAt(i) == needle.charAt(j)) {

                i++;
                j++;

                if (j == m) {
                    return i - m;
                }

            } else {

                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }
}