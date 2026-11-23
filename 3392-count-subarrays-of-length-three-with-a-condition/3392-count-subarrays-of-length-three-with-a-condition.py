class Solution(object):
    def countSubarrays(self, nums):
       count=0
       for i in range(len(nums)-2):
           first=nums[i]
           middle=nums[i+1]
           third=nums[i+2]
           if 2*(first+third)==middle:
              count +=1
       return count
       