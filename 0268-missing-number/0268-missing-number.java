class Solution {
    public int missingNumber(int[] nums) {
    /*     Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if (i!=nums[i])return i;
        }
        return n;
 */
         int n=nums.length;
         int freq[]=new int[n+1];

         for(int i:nums){
            freq[i]=1;
         }
         for(int i=0;i<n+1;i++){
            if(freq[i]==0)return i;
         }
         return 0;


    

        
        
    }
}