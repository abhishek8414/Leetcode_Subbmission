class Solution {
    public int[] runningSum(int[] nums) {

        // this is not prtomum solution so i cant take it , to mai optimise solution karne ja rha hu mai 
        // opbro soi you k=can take ist easy way bro 
         int n=nums.length;

         int prefix[]=new int[n];
         prefix[0]=nums[0];
         for(int i=1;i<n;i++){
        
            prefix[i]=prefix[i-1]+nums[i];
         }
        return prefix;

        
        // Start from index 1 since the running sum at index 0 is just nums[0]
       // for (int i = 1; i < nums.length; i++) {
        //    nums[i] += nums[i - 1];
        //}
       // return nums;
    }
}

