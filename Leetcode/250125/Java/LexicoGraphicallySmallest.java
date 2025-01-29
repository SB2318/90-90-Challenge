// problem link: https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/?envType=daily-question&envId=2025-01-25

// Approach 1: Bruteforce (Intution Building)
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        for(int i=0; i<nums.length; i++){

        while(true){
            
            int idx =-1;

            for(int j= i+1; j<nums.length; j++){

                if(Math.abs(nums[i]-nums[j]) <= limit){

                    if(nums[j]< nums[i]){
                       idx = j;
                    }
                }

                
            }

            if(idx != -1){
                    int temp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = temp;
                }else{
                    break;
                }
        }
        }
        return nums;
    }
}

// Approach 2: Sorting And Grouping
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        // Intution: Grouping + Sorting
        // First take a clone of the array
        int[] sortedArr = nums.clone();

        Arrays.sort(sortedArr);

        int groupIndex =0;
        // Store each element corresponding their groupIndex
        HashMap<Integer, Integer> mapGroupIndexWithElelment = new HashMap<>();
       // Store each group corresponding groupIndex
       HashMap<Integer, ArrayList<Integer>> mapGroupIndexWithGroup = new HashMap<>();

       // Now add first element, as well as first list
      mapGroupIndexWithElelment.put(sortedArr[0], groupIndex);
     mapGroupIndexWithGroup.put(groupIndex, new ArrayList<>(Arrays.asList(sortedArr[0])));

       // start processing from second element
        for(int i=1; i<sortedArr.length; i++){

            if(Math.abs(sortedArr[i]-sortedArr[i-1]) > limit){
                // update group index
                groupIndex++;
            }

           // store group index or group numer of the element
            mapGroupIndexWithElelment.put(sortedArr[i], groupIndex);
            // check whether any group present in this index or not
            if(!mapGroupIndexWithGroup.containsKey(groupIndex)){
                // create new group
                mapGroupIndexWithGroup.put(groupIndex, new ArrayList<Integer>());
            }
            // add current element to group
            mapGroupIndexWithGroup.get(groupIndex).add(sortedArr[i]);

           
        }
        // Now groups are ready, now process each nums element and find their group

        for(int i=0; i<nums.length; i++){

            int group = mapGroupIndexWithElelment.get(nums[i]);
            nums[i] = mapGroupIndexWithGroup.get(group).get(0); // remove the top element, it will be lexicographically smallest, as array was sorted
            // remove the element
            mapGroupIndexWithGroup.get(group).remove(0);
        }

        return nums;

    }
}

// The Real world application of this problem is associated with api and databases
