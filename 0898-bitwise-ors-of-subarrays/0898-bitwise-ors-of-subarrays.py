from typing import List

class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        res = set()
        cur = set()
        for num in arr:
            # Compute new OR values for subarrays ending at current element
            new_cur = {num | x for x in cur} | {num}
            cur = new_cur
            res |= cur  # Add all new OR results to the result set
        return len(res)
