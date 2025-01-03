// problem_link: https://leetcode.com/problems/number-of-ways-to-split-array/?envType=daily-question&envId=2025-01-03
function waysToSplitArray(nums: number[]): number {
    
    let prefixSum: number[] = [];

    prefixSum[0] = nums[0];

    for(let i =1; i<nums.length; i++)
       prefixSum[i] = prefixSum[i-1]+nums[i];

    let count=0;
    for(let i=0; i<nums.length-1; i++){

        if(prefixSum[i] >= (prefixSum[nums.length-1] - prefixSum[i])){
            count++;
        }
    }

    return count;
};
