class Solution {
    
    int[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
         Data[] datas = new Data[startTime.length];
         dp = new int[startTime.length+1];
         Arrays.fill(dp,-1);

         for(int i=0; i<datas.length; i++){
             datas[i] = new Data(startTime[i], endTime[i], profit[i]);
         }

        Arrays.sort(datas, (a, b) -> Integer.compare(a.startTime, b.startTime));
         return solve(0, datas);
      
    }

    private int solve( int index, Data[] datas){
         
           if(index >= datas.length || index == -1){
               return 0;
           }
           else if(dp[index] != -1){
               return dp[index];
           }
           // Get next index for which the startTime >= datas[index].endTime
           int next = getNextIndex(datas, index+1, datas[index].endTime);

           // Take
           int take = datas[index].profit + solve(next, datas);

           //Skip
           int skip = solve(index+1, datas); // do not need to find next index

           return dp[index] = Math.max(take, skip);
    }


   private int getNextIndex(Data[] datas, int startIndex, int targetTime) {
    for (int i = startIndex; i < datas.length; i++) {
        if (datas[i].startTime >= targetTime) {
            return i;
        }
    }
    return -1; // If no such index is found
}

    class Data{
        int startTime, endTime, profit;

        public Data(int startTime, int endTime, int profit){

            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}