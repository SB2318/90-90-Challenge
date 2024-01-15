/***
 Problem Date: 15/01/24
 Problem Name: Find Players With Zero or One Losses.
 Problem Link: https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 Problem Category: Array, DSA
*/

/*** Approach 1 : Using Array */

class Solution {

    public List<List<Integer>> findWinners(int[][] matches) {

       int[] losses = new int[100001];
       /** losses[i] = -1 // player win the game*/
       for(int i=0; i<matches.length; i++){

            int loss= matches[i][1];
            int win= matches[i][0];
            /** Handle win case */
            if(losses[win] ==0){
                losses[win] = -1;
            }
            /** May they win some cases, but now lost.*/
            if(losses[loss] == -1){
               losses[loss] =1;
            }else{
                losses[loss]++;
            }
       }

       List<Integer>  zeroLoss = new ArrayList<>();
       List<Integer>  oneLoss = new ArrayList<>();

       List<List<Integer>> result = new ArrayList<>();

       for(int i=1; i<losses.length; i++){

            if(losses[i]==-1){
                zeroLoss.add(i); // For win cases value will be -1 always and never increase
            }
            else if(losses[i] == 1){
                oneLoss.add(i);
            }
       }

        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
    }
}

/** Approach 2: Using Map */

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lost = new HashMap<>();

        for (int[] it : matches) {
            int lose = it[1];
            lost.put(lose, lost.getOrDefault(lose, 0) + 1);
        }

        List<Integer> notLost = new ArrayList<>();
        List<Integer> oneLos = new ArrayList<>();

        for (int[] it : matches) {
            int lose = it[1];
            int win = it[0];

            if (lost.get(lose) == 1) {
                oneLos.add(lose);
            }
            if (!lost.containsKey(win)) {
                notLost.add(win);
                lost.put(win, 2);
            }
        }

        Collections.sort(notLost);
        Collections.sort(oneLos);

        return Arrays.asList(notLost, oneLos);
    }
}