# Problem Link: https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/?envType=daily-question&envId=2025-01-25

from collections import defaultdict
class Solution(object):
    def lexicographicallySmallestArray(self, nums, limit):
        """
        :type nums: List[int]
        :type limit: int
        :rtype: List[int]
        """
        sortedArr = sorted(nums)
        groupIndex = 0
        map_group_index_with_element = {}
        map_group_index_with_group = defaultdict(list)

        map_group_index_with_element[sortedArr[0]] = groupIndex
        map_group_index_with_group[groupIndex].append(sortedArr[0])

        for i in range(1, len(nums)):
            if abs(sortedArr[i] - sortedArr[i-1]) > limit:
                groupIndex +=1
            map_group_index_with_element[sortedArr[i]] = groupIndex
            map_group_index_with_group[groupIndex].append(sortedArr[i])

        for i  in  range(len(nums)):
            group = map_group_index_with_element[nums[i]]
            nums[i] = map_group_index_with_group[group].pop(0)

        return nums
