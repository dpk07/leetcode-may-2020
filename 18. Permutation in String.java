public class 18. Permutation in String {
  
}class Solution {
  public boolean checkInclusion(String s1, String s2) {
     if (s1 == null || s1.isEmpty()) return true;
      if (s2 == null || s2.isEmpty() || s2.length() < s1.length()) return false;
      int tlen = s1.length(), slen = s2.length();
      char[] chs = s2.toCharArray();
      int[] counter = new int[26];
      for (char c : s1.toCharArray()) {
          counter[c - 'a']++;
      }
      int count = tlen;
      for (int i = 0; i < tlen; i++) {
          if (counter[chs[i] - 'a']-- > 0) count--;
      }
      if (count == 0) return true;
      int left = 0, right = tlen;
      while (right < slen) {
          char currR = chs[right++];
          char currL = chs[left++];
          if (counter[currR - 'a']> 0) count--;
          counter[currR - 'a']--;
          counter[currL - 'a']++;
          if (counter[currL - 'a'] > 0) count++;
          if (count == 0) return true;
      }
      return false;
  }
}