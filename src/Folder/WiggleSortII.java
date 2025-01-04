class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            pq1.add(nums[i]);
        }
        for(int i=1; i<n; i += 2){
            nums[i] = pq1.peek();
            pq1.poll();
        }
        for(int i=0; i<n; i += 2){
            nums[i] = pq1.peek();
            pq1.poll();
        }
    }
}