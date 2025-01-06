class Solution {

    Map<String, Integer> dp;
    public int waysToReachStair(int k) {
        dp = new HashMap<>();

        return helper(1, k, 0, true);
    }

    //we start at stair 1
    //cannot go below 0
    private int helper(int currentStair, int targetK, int jump, boolean canGoDown) {

        String hash = currentStair + ";" + jump + ";" + canGoDown;

        if(dp.containsKey(hash))
            return dp.get(hash);

        int answer = 0;

        //impossible now
        if(currentStair > targetK + 1) {
            return 0;
        }

        //we are here
        if(currentStair == targetK) {
            answer++;
        }

        //go down if we can
        if(canGoDown && currentStair != 0) {
            answer += helper(currentStair - 1, targetK, jump, false);
        }

        //go up using jump
        int jumpPower = (int) Math.pow(2, jump);
        answer += helper(currentStair + jumpPower, targetK, jump + 1, true);

        dp.put(hash, answer);
        return answer;
    }
}