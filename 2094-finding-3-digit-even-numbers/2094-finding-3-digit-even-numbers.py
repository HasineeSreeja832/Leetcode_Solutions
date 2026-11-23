from itertools import permutations

class Solution(object):
    def findEvenNumbers(self, digits):
        valid_numbers = set()
        
        for comb in permutations(digits, 3):
            if comb[0] == 0:
                continue  
            num = comb[0] * 100 + comb[1] * 10 + comb[2]
            if num % 2 == 0:  
                valid_numbers.add(num)
        
        return sorted(valid_numbers)
