class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if(nums.length==1)
        {
            return 1;
        }
        Map<Integer,Integer> nm=new HashMap<>();
        int ans=0,maxi=0;
        for(int i=0,j=0;i<nums.length;i++)
        {
            nm.put(nums[i], nm.getOrDefault(nums[i],0)+1);
            maxi=Math.max(maxi,nm.get(nums[i]));
            if(maxi>k)
            {
                while(maxi>k)
                {
                    if(nm.get(nums[j])==1)
                    {
                        nm.remove(nums[j]);

                    }
                    else
                    {
                        nm.put(nums[j], nm.getOrDefault(nums[j],0)-1);
                    }
                    j++;
                    maxi=nm.get(nums[i]);
                }
            }
            else
            {
                ans=Math.max(ans,i-j+1);
            }
        }
        return ans;
    }
}
