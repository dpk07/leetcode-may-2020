class Solution {
  public int maxSubarraySumCircular(int[] A) {
    int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
    int totalSum = 0, maxTillHere = 0, minTillHere = 0;
    for (int a : A) {
      totalSum += a;
      maxTillHere += a;
      maxSum = Math.max(maxTillHere, maxSum);
      if (maxTillHere < 0)
        maxTillHere = 0;
      minTillHere += a;
      minSum = Math.min(minTillHere, minSum);
      if (minTillHere > 0)
        minTillHere = 0;
    }
    if (maxSum < 0)
      return maxSum;
    return Math.max(maxSum, totalSum - minSum);
  }
}