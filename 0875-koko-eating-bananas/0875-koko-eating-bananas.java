import java.util.*;
class Solution {
    //calculate hrs
    private long TotalHours(int[] piles, int speed) {
        long totalH = 0;
        for (int bananas : piles) {
            totalH += (bananas + speed - 1) / speed;
        }
        return totalH;
    }
    //min speed
    public int minEatingSpeed(int[] piles, int h) {
        // max element
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int low = 1, high = maxPile;
        int ans = maxPile;
        // Binary search on answer space
        while (low <= high) {
            int mid = (low + high) / 2;
            long totalH =TotalHours(piles, mid);
            //smaller speed
            if (totalH <= h) {
                ans = mid;
                high = mid - 1;
            }
            //larger speed
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}