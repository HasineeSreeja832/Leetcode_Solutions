class Solution(object):
    def minCost(self, basket1, basket2):
        from collections import Counter
        count1 = Counter(basket1)
        count2 = Counter(basket2)
        total_count = count1 + count2
        for fruit in total_count:
            if total_count[fruit] % 2 != 0:
                return -1 
        to_swap1 = []
        to_swap2 = []
        for fruit in total_count:
            diff = count1[fruit] - total_count[fruit] // 2
            if diff > 0:
                to_swap1.extend([fruit] * diff)
            elif diff < 0:
                to_swap2.extend([-fruit] * (-diff)) 
        to_swap1.sort()
        to_swap2.sort()
        min_fruit = min(min(basket1), min(basket2))
        total_cost = 0
        for a, b in zip(to_swap1, to_swap2):
            total_cost += min(min(a, -b), 2 * min_fruit)
        return total_cost
