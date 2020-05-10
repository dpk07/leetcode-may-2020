class Solution {
  public boolean isPerfectSquare(int num) {
    // need to use long as it holds the square
    for (long i = 0; i * i <= (long) num; i++) {
      if (num == (long) i * i)
        return true;
    }
    return false;
  }
}