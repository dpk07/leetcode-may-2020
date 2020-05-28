class Solution {
  public int[] countBits(int num) {

    int[] dp = new int[num + 1];
    dp[0] = 0;
    if (num == 0)
      return dp;
    dp[1] = 1;
    if (num == 1)
      return dp;
    dp[2] = 1;
    int closestPowerOfTwo = 1;
    for (int i = 2; i <= num; i++) {
      if ((i & (i - 1)) == 0) {
        dp[i] = 1;
        closestPowerOfTwo = i;
      } else {
        dp[i] = dp[closestPowerOfTwo] + dp[i - closestPowerOfTwo];
      }
    }
    return dp;
  }
}