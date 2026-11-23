class Solution {
    public int repeatedStringMatch(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Repeat a until its length is at least b's length
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check if b is already a substring
        if (sb.toString().contains(b)) {
            return count;
        }

        // One extra repetition may be needed
        sb.append(a);
        count++;

        if (sb.toString().contains(b)) {
            return count;
        }

        return -1;
    }
}